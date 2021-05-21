package com.saifi369.passingstateswithsealedclasses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val uiState = MutableLiveData<UiState>()

    fun loadData() {
        uiState.value = UiState.Loading

        viewModelScope.launch {
            delay(3000)
            val data = getData()
            uiState.value = UiState.Success(data)
        }


    }

    fun loadDataWithError() {
        uiState.value = UiState.Loading

        viewModelScope.launch {
            delay(3000)
            val data = getData()
            uiState.value = UiState.Error("Error loading data")
        }


    }

    private fun getData() = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mattis ullamcorper velit sed ullamcorper morbi. Vitae sapien pellentesque habitant morbi tristique senectus. Vivamus at augue eget arcu dictum varius duis at consectetur. Et pharetra pharetra massa massa ultricies mi quis hendrerit dolor. Aliquam vestibulum morbi blandit cursus risus at ultrices. Sodales ut eu sem integer. Natoque penatibus et magnis dis parturient montes nascetur ridiculus mus. At in tellus integer feugiat scelerisque varius. Nulla aliquet enim tortor at auctor urna nunc. Id velit ut tortor pretium viverra suspendisse potenti. Nisl vel pretium lectus quam id. Amet justo donec enim diam vulputate ut pharetra sit. Velit laoreet id donec ultrices tincidunt. Sit amet facilisis magna etiam tempor orci. Habitant morbi tristique senectus et netus et malesuada fames. Diam vel quam elementum pulvinar etiam non quam lacus.\n" +
            "Sit amet commodo nulla facilisi nullam vehicula. Urna id volutpat lacus laoreet. Elementum integer enim neque volutpat ac tincidunt vitae. Et netus et malesuada fames. Massa tempor nec feugiat nisl pretium fusce. Ipsum nunc aliquet bibendum enim facilisis. Lectus quam id leo in vitae turpis massa sed elementum. A cras semper auctor neque vitae tempus. Maecenas ultricies mi eget mauris pharetra et ultrices neque ornare. Ut diam quam nulla porttitor."
}


