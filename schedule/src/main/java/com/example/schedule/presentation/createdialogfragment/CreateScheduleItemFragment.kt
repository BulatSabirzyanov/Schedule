package com.example.schedule.presentation.createdialogfragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.schedule.utils.ViewModelFactory
import com.example.schedule.databinding.FragmentCreateScheduleItemBinding
import com.example.schedule.di.ScheduleComponentHolder
import com.example.schedule.domain.models.ScheduleDomainListItem
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class CreateScheduleItemFragment : DialogFragment() {

    private lateinit var binding: FragmentCreateScheduleItemBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: CreateFragmentViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ScheduleComponentHolder().get().inject(this)
        binding = FragmentCreateScheduleItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.CENTER)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateItem.setOnClickListener {
            val title = binding.editTextTitle.text.toString().trim()

            val scheduleDomainListItem = ScheduleDomainListItem(
                id = UUID.randomUUID().toString(),
                title = title,
                scheduleItemsCount = 0,
            )

            lifecycleScope.launch {
                viewModel.createScheduleListItem(scheduleDomainListItem)
                dismiss()
            }
        }
    }
}