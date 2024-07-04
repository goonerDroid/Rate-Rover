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
package com.sublime.raterover.data.exchange

import android.content.Context
import org.json.JSONObject

class FakeExchangeRepository(
    private val context: Context,
    private val mockJsonObject: JSONObject,
) : ExchangeResourceRepository {
    override fun monitor(): PairConvertResource =
        PairConvertResource(
            result = mockJsonObject.getString("result"),
            documentation = mockJsonObject.getString("documentation"),
            termsOfUse = mockJsonObject.getString("terms_of_use"),
            timeLastUpdateUnix = mockJsonObject.getLong("time_last_update_unix"),
            timeLastUpdateUtc = mockJsonObject.getString("time_last_update_utc"),
            timeNextUpdateUnix = mockJsonObject.getLong("time_next_update_unix"),
            timeNextUpdateUtc = mockJsonObject.getString("time_next_update_utc"),
            baseCode = mockJsonObject.getString("base_code"),
            targetCode = mockJsonObject.getString("target_code"),
            conversionRate = mockJsonObject.getDouble("conversion_rate"),
            conversionResult = mockJsonObject.getDouble("conversion_result"),
        )
}
