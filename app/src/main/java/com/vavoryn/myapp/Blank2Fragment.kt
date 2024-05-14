package com.vavoryn.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.vavoryn.myapp.databinding.FragmentBlank2Binding

class Blank2Fragment : Fragment() {
    private lateinit var binding: FragmentBlank2Binding
    companion object{
        var EXTRA_VALUE = "extra_value"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if (arguments != null){
//            val label = arguments?.getString(EXTRA_VALUE)
//            binding.myText.text = label
//        }

        val myStudent = Blank2FragmentArgs.fromBundle(arguments as Bundle).myStudent
        binding.myText.text = myStudent.name

        binding.btnNext.setOnClickListener {
//            val fragment1 = Blank1Fragment()
//            val mFragmentManager = parentFragmentManager
//
//            mFragmentManager
//                .beginTransaction().apply {
//                    replace(R.id.fragment_container, fragment1, Blank1Fragment::class.java.simpleName)
//                        .addToBackStack(null)
//                        .commit()
//
//                }

            view.findNavController().navigate(
                Blank2FragmentDirections.actionBlank2FragmentToBlank1Fragment()
            )
        }
    }
}