package com.example.responsi1mobile_h1d023008.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobile_h1d023008.data.model.Player
import com.example.responsi1mobile_h1d023008.databinding.FragmentDetailPemainBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailPemainFragment(private val player: Player) : BottomSheetDialogFragment() {

    private var _binding: FragmentDetailPemainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPemainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textPlayerName.text = player.name
        binding.textBornDate.text = player.dateOfBirth ?: "-"
        binding.textNationality.text = player.nationality ?: "-"
        binding.textPosition.text = player.position ?: "-"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
