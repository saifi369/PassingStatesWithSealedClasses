package com.saifi369.passingstateswithsealedclasses

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.saifi369.passingstateswithsealedclasses.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.uiState.observe(this){
            when(it){
                is UiState.Error -> showError(it.message)
                UiState.Loading -> loading()
                is UiState.Success -> dataLoaded(it.data)
            }
        }

        binding.btnRunCode.setOnClickListener{
            //load data from view-model
            mainViewModel.loadDataWithError()
        }
    }

    private fun dataLoaded(data: String) {
        with(binding){
            btnRunCode.isEnabled = true
            pbLoading.visibility = View.GONE
            tvOutput.text = data
        }
    }

    private fun loading() {
        with(binding){
            tvOutput.text = ""
            btnRunCode.isEnabled = false
            pbLoading.visibility = View.VISIBLE
        }
    }

    private fun showError(message: String) {
        with(binding){
            btnRunCode.isEnabled = true
            pbLoading.visibility = View.GONE
            tvOutput.text = message
        }
    }
}