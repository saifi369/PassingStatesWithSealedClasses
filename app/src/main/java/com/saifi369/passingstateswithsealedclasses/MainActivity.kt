package com.saifi369.passingstateswithsealedclasses

import android.os.Bundle
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

        binding.btnRunCode.setOnClickListener{
            //load data from view-model
            val data = mainViewModel.loadData()
            binding.tvOutput.text = data
        }
    }
}