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
package com.sublime.raterover.infra.datasource.remote.dto

import com.sublime.raterover.domain.entity.ConvertFactor
import com.sublime.raterover.domain.entity.Currency
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PairConversion(
    @SerialName("base_code") val baseCode: String,
    @SerialName("conversion_rate") val conversionRate: Double,
    val documentation: String,
    val result: String,
    @SerialName("target_code") val targetCode: String,
    @SerialName("terms_of_use") val termsOfUse: String,
    @SerialName("time_last_update_unix") val timeLastUpdateUnix: Long,
    @SerialName("time_last_update_utc") val timeLastUpdateUtc: String,
    @SerialName("time_next_update_unix") val timeNextUpdateUnix: Long,
    @SerialName("time_next_update_utc") val timeNextUpdateUtc: String,
)

fun PairConversion.toDomain(
    baseCurrency: Currency,
    targetCurrency: Currency,
) = ConvertFactor(
    baseCurrency,
    targetCurrency,
    conversionRate,
    Instant.fromEpochMilliseconds(timeLastUpdateUnix),
)
