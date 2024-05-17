package com.example.lf_parkcar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lf_parkcar.databinding.FragmentAddCarBinding


class AddCarFragment : Fragment() {

    private lateinit var binding:FragmentAddCarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddCarBinding.inflate(inflater,container,false)
        return binding.root
        registerEvents()
    }

    private fun registerEvents(){
        binding.btnattiva.setOnClickListener{
            val boxnomepark=binding.textPark.text.toString()
            val boxpsw=binding.textCar.text.toString()

            if(boxnomepark.isNotEmpty() && boxpsw.isNotEmpty()){

            }else{
                Toast.makeText(context, "Inserisci i valori mancanti", Toast.LENGTH_SHORT).show()
            }
        }
    }



}