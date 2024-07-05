package com.sublime.raterover.data.fake

import com.sublime.raterover.data.PairConvertResource

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
