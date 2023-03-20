package com.pavelwinter.myorganizer.presentation.fragments.Forms

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.databinding.FragmentAddProjectBinding
import com.pavelwinter.myorganizer.databinding.FragmentAddQuotaBinding


class AddQuotaFragment : Fragment() {

    internal var str = arrayOf("a", "b", "c")
   lateinit var binding: FragmentAddQuotaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddQuotaBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


       binding.tvDigitHour .text = 0.toString()
       binding.tvDescrHour .text = "h   "
       binding.tvDescrMinute .text = 0.toString()
       binding.tvDescrMinute .text = "m   "
       binding.tvDescrPeriod .text = " for period: "
       binding.tvDigitMinute.text = "week"


       binding.llQuota .setOnClickListener {

            this.context?.let {

                val d = AlertDialog.Builder(it)
                val inflater = this.layoutInflater
                val dialogView = inflater.inflate(R.layout.picker_dialog_quota, null)
                d.setTitle("Title")
                d.setMessage("Message")
                d.setView(dialogView)


              binding.hourPicker.maxValue = 200
                binding.hourPicker.minValue = 0

                binding.minutePicker.maxValue = 59
                binding.minutePicker.minValue = 0

                binding.periodPicker.minValue = 0
                binding.periodPicker.maxValue = 2

                binding.periodPicker.displayedValues = str
                //new String[]{"a", "b", "c"});


               binding.hourPicker .setOnValueChangedListener { numberPicker, i, i1 ->
                    Log.d(
                        "TAG",
                        "onValueChange: $i1"
                    )
                }

               binding.minutePicker .setOnValueChangedListener(NumberPicker.OnValueChangeListener { numberPicker, i, i1 ->
                    Log.d(
                        "TAG",
                        "onValueChange: $i1"
                    )
                })


               binding.periodPicker.setOnValueChangedListener(NumberPicker.OnValueChangeListener { numberPicker, i, i1 ->
                    Log.d(
                        "TAG",
                        "onValueChange: $i1"
                    )
                })


                d.setPositiveButton("Done") { dialogInterface, i ->
                    Log.d("TAG", "onClickh: " + binding.hourPicker.value)
                    Log.d("TAG", "onClickm: " + binding.minutePicker.getValue())
                    Log.d("TAG", "onClickp: " + binding.periodPicker.getValue())


                  binding.tvDigitHour .text = binding.hourPicker.value.toString()
                    binding.tvDigitMinute.text = binding.minutePicker.value.toString()
                    binding.tvVariant.text = str[binding.periodPicker.value]
                }
                d.setNegativeButton(
                    "Cancel"
                ) { dialogInterface, i -> }

                val alertDialog = d.create()
                alertDialog.show()
            }
        }

       binding.btnq.setOnClickListener {  }

       }

 }
