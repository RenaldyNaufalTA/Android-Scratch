package com.vavoryn.myapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.vavoryn.myapp.Blank1FragmentDirections
import com.vavoryn.myapp.databinding.FragmentBlank1Binding

class Blank1Fragment : Fragment() {
    private lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
//            val fragment2 = Blank2Fragment()
//            val mFragmentManager = parentFragmentManager
//            val bundle2 = Bundle()
//            bundle2.putString(Blank2Fragment.EXTRA_VALUE, "My Value from Fragment 2")
//            fragment2.arguments = bundle2
//
//            mFragmentManager
//                .beginTransaction().apply {
//                    replace(R.id.fragment_container, fragment2, Blank2Fragment::class.java.simpleName)
//                        .addToBackStack(null)
//                        .commit()
//
//                }
            val myStudent = Student( "Alex", "123456")
            view.findNavController().navigate(
                Blank1FragmentDirections.actionBlank1FragmentToBlank2Fragment(myStudent)
            )
        }

        binding.btnDialog.setOnClickListener {
            val mDialogFragment = MyDialogFragment()
            val mFramentManger = childFragmentManager

            mDialogFragment.show(mFramentManger, mDialogFragment::class.java.simpleName)
        }
    }

    var dialogListener: MyDialogFragment.DialogListener = object : MyDialogFragment.DialogListener {

        override fun onSubmit(text: String){
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
        
    }

}