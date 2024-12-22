package com.fadymarty.wordsfactory.presentation.onboarding.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fadymarty.wordsfactory.domain.usecases.app_entry.AppEntryUseCases
import com.fadymarty.wordsfactory.presentation.onboarding.OnBoardingEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}