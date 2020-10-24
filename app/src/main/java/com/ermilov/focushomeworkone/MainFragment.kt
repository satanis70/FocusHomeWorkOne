package com.ermilov.focushomeworkone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ermilov.focushomeworkone.task1.FragmentA
import com.ermilov.focushomeworkone.task1.FragmentB
import com.ermilov.focushomeworkone.task1.FragmentC
import com.ermilov.focushomeworkone.task3.ContactFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {
    var i = 0
    val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    companion object{
        fun newInstanse() = MainFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        button_task1.setOnClickListener {
            when (i) {
                0 -> {
                        openFragment(FragmentA.newInstanse(i))
                        i += 1
                        FragmentA(i)
                }
                1 -> {
                        openFragment(FragmentB.newInstanse())
                        i += 1
                }
                2 -> {
                        openFragment(FragmentC.newInstanse())
                        i += 1
                }
                3 -> {
                    openFragment(FragmentA.newInstanse(i))
                        i = 0
                }
            }

        }



        button_task3.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_fragment, ContactFragment.newInstanse()).commit()
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun openFragment(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_fragment, fragment).commit()
    }




}