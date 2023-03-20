package com.pavelwinter.myorganizer.presentation.fragments.Forms


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.pavelwinter.myorganizer.databinding.FragmentAddProjectBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AddProjectFragment : Fragment() {

    lateinit var binding: FragmentAddProjectBinding

    internal var calendar = Calendar.getInstance()
    internal var dateAndTime = Calendar.getInstance()

    internal var listCategories = arrayOf("home", "girls", "car")

    //variants for spinner time
    internal var variantsTime = arrayOf("1 day", "1 week", "1 month", "1 year", "Custom duration")

    internal var priorites = arrayOf("High", "Middle", "Low")

    //choose category
    internal var category = "Unknown category"

    //if system has no projects
    internal var project = "No project"

    lateinit var mContext: Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProjectBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        binding.fromDataProject.setOnClickListener { setDate() }
        binding.fromTimeProject.setOnClickListener { setTime() }
        binding.toDataProject.setOnClickListener { setDate() }
        binding.toTimeProject.setOnClickListener { setTime() }
        binding.buttonAddProject.setOnClickListener { }


    }


    internal fun refreshAdapter() {

        this.context?.let {

            val spendTime =
                ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, variantsTime)
            val priorityAdapter =
                ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, priorites)


            val categoryAdapter =
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    listCategories
                )

            binding.spinnerTimeSpendProject.adapter = spendTime
            binding.spinnerPriorityProject.adapter = priorityAdapter
            binding.spinnerCategoryProject.adapter = categoryAdapter
            binding.spinnerTimeSpendProject.setSelection(1)
            binding.spinnerPriorityProject.setSelection(1)
            binding.spinnerCategoryProject.setSelection(4)


            refreshDateChooser()


           binding.spinnerTimeSpendProject .onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>) {}

                    override fun onItemSelected(
                        parent: AdapterView<*>, view: View,
                        pos: Int, id: Long
                    ) {

                        calendar = Calendar.getInstance()

                        when (pos) {

                            0 -> calendar.add(Calendar.DAY_OF_YEAR, 1)
                            1 -> calendar.add(Calendar.WEEK_OF_MONTH, 1)
                            2 -> calendar.add(Calendar.MONTH, 1)
                            3 -> calendar.add(Calendar.YEAR, 1)
                        }


                        refreshDateChooser()

                        // Toast.makeText(NewAddItemActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
                    }
                }


           binding.spinnerPriorityProject .onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>) {}

                    override fun onItemSelected(
                        parent: AdapterView<*>, view: View,
                        pos: Int, id: Long
                    ) {
                        // Toast.makeText(NewAddItemActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
                    }
                }




            binding.spinnerPriorityProject.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>) {}

                    override fun onItemSelected(
                        parent: AdapterView<*>, view: View,
                        pos: Int, id: Long
                    ) {
                        // Toast.makeText(NewAddItemActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();
                    }
                }

        }
    }


    fun setDate() {

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


    internal fun setTime() {
        this.context?.let {

            TimePickerDialog(
                it, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true
            )
                .show()
        }
    }


    // установка обработчика выбора времени
    internal var t: TimePickerDialog.OnTimeSetListener =
        TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            dateAndTime.set(Calendar.MINUTE, minute)
            //   setInitialDateTime();


            Log.d("CHOOSEN_TIME", dateAndTime.timeInMillis.toString())
            Log.d("CURRENT_TIME", System.currentTimeMillis().toString())
        }

    // установка обработчика выбора даты
    internal var d: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            dateAndTime.set(Calendar.YEAR, year)
            dateAndTime.set(Calendar.MONTH, monthOfYear)
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            //setInitialDateTime();
            setTime()
        }


    fun refreshDateChooser() {

        this.context?.let {


            binding.fromDataProject .text = DateUtils.formatDateTime(
                it,
                dateAndTime.timeInMillis,
                DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
            )


            binding.fromTimeProject .text = DateUtils.formatDateTime(
                it,
                dateAndTime.timeInMillis,
                DateUtils.FORMAT_SHOW_TIME
            )


           binding.toDataProject .text = DateUtils.formatDateTime(
                it,
                //dateAndTime.getTimeInMillis()+ (temporaryAdd*1000)
                //
                calendar.timeInMillis,
                DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
            )


            calendar = Calendar.getInstance()



          binding.toTimeProject.text = DateUtils.formatDateTime(
                it,
                dateAndTime.timeInMillis,
                DateUtils.FORMAT_SHOW_TIME
            )

        }
    }
}
