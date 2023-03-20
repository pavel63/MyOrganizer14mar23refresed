package com.pavelwinter.myorganizer.presentation.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.data.mocks.DataTypesGenerator
import com.pavelwinter.myorganizer.databinding.FragmentAddProjectBinding
import com.pavelwinter.myorganizer.databinding.QuotaFragmentBinding
import com.pavelwinter.myorganizer.presentation.view_models.QuotaViewModel
import com.pavelwinter.myorganizer.presentation.adapters.QuotaAdapter

class QuotaFragment : Fragment() {

    companion object {
        fun newInstance() =
            QuotaFragment()
    }
lateinit var binding : QuotaFragmentBinding
    private lateinit var viewModel: QuotaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuotaFragmentBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QuotaViewModel::class.java)

        // TODO: Use the ViewModel

        setList(DataTypesGenerator.generateParentList())
    }





    private fun setList(quotaModelList : List<ParentType>){

        with(binding.quotaFragmentRv) {
            adapter = QuotaAdapter(quotaModelList)
            layoutManager = LinearLayoutManager(this@QuotaFragment.context)
        }

    }

}
