package com.pamo.bmi_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calories.*

class CaloriesFragment : Fragment(), OnItemSelectedListener {

    private var gender: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calories, container, false)
    }
    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        val adapter = ArrayAdapter.createFromResource(
            this.context!!,
            R.array.caloriesGenderList,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        caloriesGenderSpinner.setAdapter(adapter)
        caloriesGenderSpinner.setOnItemSelectedListener(this)

        caloriesCalculateBtn.setOnClickListener(View.OnClickListener { calculatePpm() })
    }

    fun calculatePpm() {
        var result = 0.0
        val weight = parseDoubleWithDefault(caloriesWeightNumEditText!!.text.toString())
        val height = parseDoubleWithDefault(caloriesHeightNumEditText!!.text.toString())
        val age = parseDoubleWithDefault(caloriesAgeNumEditText!!.text.toString())
        val condition = getString(R.string.caloriesMale)
        try {
            result = if (gender == condition) {
                66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
            } else {
                655.1 + 9.563 * weight + 1.85 * height - 4.676 * age
            }
        } catch (e: ArithmeticException) {
            println(getString(R.string.arithmeticException) + e.message)
        }
        result = Math.round(result).toDouble()
        caloriesResultNumTextView!!.text = result.toString() + ""
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(
        parent: AdapterView<*>,
        view: View,
        position: Int,
        id: Long
    ) {
        gender = try {
            parent.getItemAtPosition(position).toString()
        } catch (e: Exception) {
            getString(R.string.unknownException) + e.message
        }
        Toast.makeText(parent.context, gender, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun parseDoubleWithDefault(number: String): Double {
            val defaultVal = 0.0
            return try {
                number.toDouble()
            } catch (e: NumberFormatException) {
                defaultVal
            }
        }
    }

}