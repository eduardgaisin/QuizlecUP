package com.eduardg.quizlec

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.eduardg.quizlec.databinding.FragmentTestMenuBinding

class TestMenuFragment : Fragment() {

    private lateinit var binding: FragmentTestMenuBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_test_menu, container, false)

        binding.trainingButton.setOnClickListener {
            findNavController().navigate(TestMenuFragmentDirections.actionTestMenuFragmentToChooseCardCollectionFragment())
        }

        binding.cardCollectionButton.setOnClickListener{
            findNavController().navigate(TestMenuFragmentDirections.actionTestMenuFragmentToCardCollectionListFragment())
        }

        return binding.root
    }

}