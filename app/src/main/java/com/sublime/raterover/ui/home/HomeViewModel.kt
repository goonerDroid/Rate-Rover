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
package com.sublime.raterover.ui.home

import com.sublime.raterover.domain.entity.Currency
import com.sublime.raterover.domain.util.IDispatcherProvider
import com.sublime.raterover.domain.util.inrCurrency
import com.sublime.raterover.domain.util.usdCurrency
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val dispatcherProvider: IDispatcherProvider,
) : BaseEvent<HomeEvent>(),
    IHomePageUI.State,
    CoroutineScope {
    init {
        jobTracker = Job()
    }

    var baseDisplay: Double
        get() = baseCurrencyDisplay.value.toDouble()
        set(value) {
            launch {
                baseCurrencyDisplay.emit(String.format("%.2f", value))
            }
        }

    var targetDisplay: Double
        get() = targetCurrencyDisplay.value.toDouble()
        set(value) {
            launch {
                targetCurrencyDisplay.emit(String.format("%.2f", value))
            }
        }

    override val coroutineContext: CoroutineContext
        get() =
            jobTracker + dispatcherProvider.dispatchIOContext()

    override fun onEventChange(event: HomeEvent) {
        launch(dispatcherProvider.dispatchIOContext()) {
            when (event) {
                HomeEvent.OnBaseCurrencyChangeStart -> TODO()
                is HomeEvent.BaseCurrencyChange -> TODO()
                is HomeEvent.BaseCurrencyTextChange -> TODO()
                HomeEvent.OnEvaluatePress -> TODO()
                HomeEvent.OnSwitchCurrencyPress -> TODO()
                HomeEvent.OnTargetCurrencyChangeStart -> TODO()
                is HomeEvent.TargetCurrencyChange -> TODO()
            }
        }
    }

    override val baseCurrency: MutableStateFlow<Currency> = MutableStateFlow(usdCurrency)
    override val targetCurrency: MutableStateFlow<Currency> = MutableStateFlow(inrCurrency)
    override val baseCurrencyDisplay: MutableStateFlow<String> = MutableStateFlow("0.00")
    override val targetCurrencyDisplay: MutableStateFlow<String> = MutableStateFlow("0.00")
    override val isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override val error: MutableStateFlow<String?> = MutableStateFlow(null)
}
