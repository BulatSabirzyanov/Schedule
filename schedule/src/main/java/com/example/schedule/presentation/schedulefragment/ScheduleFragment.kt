package com.example.schedule.presentation.schedulefragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.schedule.databinding.FragmentScheduleBinding
import com.example.schedule.di.ScheduleComponentHolder
import com.example.schedule.presentation.adapter.ScheduleListAdapter
import com.example.schedule.presentation.createdialogfragment.CreateScheduleItemFragment
import com.example.schedule.utils.ViewModelFactory
import com.github.terrakok.cicerone.Screen
import kotlinx.coroutines.launch
import javax.inject.Inject


class ScheduleFragment : Fragment() {
    private val adapter = ScheduleListAdapter(
        onDeleteItem = { deletedItem ->
            viewModel.deleteScheduleItem(deletedItem)
        },
        onItemClickListener = {
            viewModel.navigateToScheduleDetail(it)
        }
    )
    private lateinit var binding: FragmentScheduleBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ScheduleViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupComponent()
    }

    private fun setupComponent() {
        ScheduleComponentHolder().get().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.scheduleLists.collect { scheduleLists ->
                adapter.submitList(scheduleLists)
            }
        }

        binding.createScheduleItemButton.setOnClickListener {
            val createItemFragment = CreateScheduleItemFragment()
            createItemFragment.show(childFragmentManager, "CreateItemFragment")
        }
    }

}