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
package com.sublime.raterover

import android.content.Context
import com.sublime.raterover.data.exchange.FakeExchangeRepository
import com.sublime.raterover.data.exchange.PairConvertResource
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class FakeExchangeRateRepositoryTest {
    private lateinit var subject: FakeExchangeRepository

    @Mock
    private lateinit var mockContext: Context

    @Mock
    private lateinit var mockJsonObject: JSONObject

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        `when`(mockJsonObject.getString("result")).thenReturn("success")
        `when`(mockJsonObject.getString("documentation")).thenReturn("https://www.exchangerate-api.com/docs")
        `when`(mockJsonObject.getString("terms_of_use")).thenReturn("https://www.exchangerate-api.com/terms")
        `when`(mockJsonObject.getLong("time_last_update_unix")).thenReturn(1585267200L)
        `when`(mockJsonObject.getString("time_last_update_utc")).thenReturn("Fri, 27 Mar 2020 00:00:00 +0000")
        `when`(mockJsonObject.getLong("time_next_update_unix")).thenReturn(1585270800L)
        `when`(mockJsonObject.getString("time_next_update_utc")).thenReturn("Sat, 28 Mar 2020 01:00:00 +0000")
        `when`(mockJsonObject.getString("base_code")).thenReturn("EUR")
        `when`(mockJsonObject.getString("target_code")).thenReturn("GBP")
        `when`(mockJsonObject.getDouble("conversion_rate")).thenReturn(0.8412)
        `when`(mockJsonObject.getDouble("conversion_result")).thenReturn(5.8884)

        // Initialize FakeExchangeRepository with mockContext and mockJsonObject
        subject = FakeExchangeRepository(mockContext, mockJsonObject)
    }

    @Test
    fun testMonitor() {
        val expected =
            PairConvertResource(
                result = "success",
                documentation = "https://www.exchangerate-api.com/docs",
                termsOfUse = "https://www.exchangerate-api.com/terms",
                timeLastUpdateUnix = 1585267200,
                timeLastUpdateUtc = "Fri, 27 Mar 2020 00:00:00 +0000",
                timeNextUpdateUnix = 1585270800,
                timeNextUpdateUtc = "Sat, 28 Mar 2020 01:00:00 +0000",
                baseCode = "EUR",
                targetCode = "GBP",
                conversionRate = 0.8412,
                conversionResult = 5.8884,
            )

        val actual = subject.monitor()

        assertEquals(expected, actual)
    }
}
