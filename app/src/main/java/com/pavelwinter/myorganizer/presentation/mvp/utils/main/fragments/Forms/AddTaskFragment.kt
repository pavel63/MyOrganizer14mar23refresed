package com.pavelwinter.myorganizer.presentation.mvp.utils.main.fragments.Forms


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import com.pavelwinter.myorganizer.R
import java.util.*

class AddTaskFragment : Fragment() {

    lateinit var dateAndTime : Calendar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_task_form,container,false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        callTimePicker()
    }



    // region choose time picker

   private fun callTimePicker() {

       dateAndTime = Calendar.getInstance()

       this.context?.let {
           DatePickerDialog(
               it, d,
               dateAndTime.get(Calendar.YEAR),
               dateAndTime.get(Calendar.MONTH),
               dateAndTime.get(Calendar.DAY_OF_MONTH)
           )
               .show()
       }
   }


    private fun setTime() {

        this .context ?.let {
            TimePickerDialog(
                it, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true
            )
                .show()
        }
    }


    // установка обработчика выбора времени
     var t: TimePickerDialog.OnTimeSetListener =
        TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            dateAndTime.set(Calendar.MINUTE, minute)

            Log.d("CHOOSEN_TIME", dateAndTime.getTimeInMillis().toString())
            Log.d("CURRENT_TIME", System.currentTimeMillis().toString())
        }


    // установка обработчика выбора даты
     var d: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            dateAndTime.set(Calendar.YEAR, year)
            dateAndTime.set(Calendar.MONTH, monthOfYear)
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            //setInitialDateTime();
            setTime()
        }

    // endregion choose time picker ----------------------------------------------


}


