package com.ermilov.focushomeworkone.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.ermilov.focushomeworkone.R

class FragmentA(var i: Int) : Fragment(){


    companion object {
        fun newInstanse(i: Int): FragmentA {
            return FragmentA(i)
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (i!=0) {
            val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
                activity?.supportFinishAfterTransition();
            }
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }
}