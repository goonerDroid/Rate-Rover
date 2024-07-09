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

import com.sublime.raterover.domain.repository.ExchangeResourceRepository
import com.sublime.raterover.domain.entity.PairConvertResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * [ExchangeResourceRepository] implementation that provides static news resources to aid development
 */
class FakeExchangeRepository(
    private val ioDispatcher: CoroutineDispatcher,
) : ExchangeResourceRepository {
    private val deserializer = Json { ignoreUnknownKeys = true }

    override fun monitor(): Flow<PairConvertResource> =
        flow {
            emit(deserializer.decodeFromString<ResourceData>(FakePairConvertDataResource.data).dataResource)
        }.flowOn(ioDispatcher)
}

/**
 * Representation of resources aas fetched from [FakePairConvertDataResource]
 */
@Serializable
private data class ResourceData(
    val dataResource: PairConvertResource,
)
