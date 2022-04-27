package com.example.viewbinding

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.viewbinding.databinding.ActivityMainBinding
import com.example.viewbinding.databinding.DialogCustomBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment()

        binding.button.setOnClickListener {
            showDialog()
        }
    }

    private fun setFragment() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(binding.container.id, TestFragment())
        ft.commit()
    }

    private fun showDialog() {
        val dialog = Dialog(this, R.style.Theme_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)

        val binding = DialogCustomBinding.inflate(LayoutInflater.from(this))
        dialog.setContentView(binding.root)

        binding.tvTitle.text = getString(R.string.app_name)

        binding.btnYes.setOnClickListener {
            dialog.dismiss()
        }

        binding.btnNo.setOnClickListener { dialog.dismiss() }

        dialog.show()

    }


}