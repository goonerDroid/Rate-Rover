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
package com.sublime.raterover.domain.fake

import com.sublime.raterover.domain.entity.PairConvertResource

object FakePairConvertDataResource {
    val samplePairConvertResource =
        PairConvertResource(
            result = "success",
            documentation = "https://www.exchangerate-api.com/docs",
            termsOfUse = "https://www.exchangerate-api.com/terms",
            timeLastUpdateUnix = 1585267200L,
            timeLastUpdateUtc = "Fri, 27 Mar 2020 00:00:00 +0000",
            timeNextUpdateUnix = 1585270800L,
            timeNextUpdateUtc = "Sat, 28 Mar 2020 01:00:00 +0000",
            baseCode = "EUR",
            targetCode = "GBP",
            conversionRate = 0.8412,
            conversionResult = 5.8884,
        )

    val data =
        """
        {
            "dataResource": {
                "result": "success",
                "documentation": "https://www.exchangerate-api.com/docs",
                "termsOfUse": "https://www.exchangerate-api.com/terms",
                "timeLastUpdateUnix": 1585267200,
                "timeLastUpdateUtc": "Fri, 27 Mar 2020 00:00:00 +0000",
                "timeNextUpdateUnix": 1585270800,
                "timeNextUpdateUtc": "Sat, 28 Mar 2020 01:00:00 +0000",
                "baseCode": "EUR",
                "targetCode": "GBP",
                "conversionRate": 0.8412,
                "conversionResult": 5.8884
            }
        }
        """.trimIndent()
}
