package com.fadymarty.wordsfactory.domain.usecases.app_entry

import com.fadymarty.wordsfactory.domain.manager.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}