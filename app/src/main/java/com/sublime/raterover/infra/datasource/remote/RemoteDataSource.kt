/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sublime.raterover.infra.datasource.remote

import com.sublime.raterover.domain.entity.Currency
import com.sublime.raterover.domain.util.ResultWrapper
import com.sublime.raterover.infra.datasource.remote.dto.PairConversion
import com.sublime.raterover.infra.datasource.remote.dto.SupportedCode
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url

class RemoteDataSource(
    private val baseUrl: String,
) : IRemoteDataSource {
    private val client =
        HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }

            engine {
                connectTimeout = 60_000
                socketTimeout = 60_000
            }
        }

    override suspend fun getCurrencies(): ResultWrapper<Exception, SupportedCode> =
        ResultWrapper.build {
            client.get {
                url("$baseUrl/codes")
            }
        }

    override suspend fun getConversionFactor(
        baseCurrency: Currency,
        targetCurrency: Currency,
    ): ResultWrapper<Exception, PairConversion> =
        ResultWrapper.build {
            client.get {
                url("$baseUrl/pair/${baseCurrency.code}/${targetCurrency.code}")
            }
        }
}
