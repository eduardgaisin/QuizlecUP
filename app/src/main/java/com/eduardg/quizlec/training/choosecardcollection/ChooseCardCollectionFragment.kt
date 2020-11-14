package com.eduardg.quizlec.training.choosecardcollection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eduardg.quizlec.R

class ChooseCardCollectionFragment : Fragment() {
    private lateinit var viewModel: ChooseCardCollectionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.choose_card_collection_fragment, container, false)
    }

}