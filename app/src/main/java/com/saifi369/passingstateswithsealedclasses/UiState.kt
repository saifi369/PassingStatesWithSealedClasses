package com.saifi369.passingstateswithsealedclasses

sealed class UiState {
    data class Success(val data:String) : UiState()
    data class Error(val message:String) : UiState()
    object Loading : UiState()
}