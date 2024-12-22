package com.fadymarty.wordsfactory.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManger {

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}