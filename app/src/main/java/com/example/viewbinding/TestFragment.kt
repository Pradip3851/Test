package com.example.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbinding.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding
    private lateinit var adapter: TestAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTestBinding.inflate(inflater,container,false)

        adapter = TestAdapter()
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = this@TestFragment.adapter
        }


        return binding.root
    }
}