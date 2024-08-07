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

interface IRemoteDataSource {
    suspend fun getCurrencies(): ResultWrapper<Exception, SupportedCode>

    suspend fun getConversionFactor(
        baseCurrency: Currency,
        targetCurrency: Currency,
    ): ResultWrapper<Exception, PairConversion>
}
