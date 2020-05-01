package com.pamo.bmi_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_bmi.*

class BmiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bmi, container, false)
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        calculateBtn!!.setOnClickListener {
            calculateBmi()
        }
    }

    private fun calculateBmi() {
        val weight = parseWithDefault(weightNumEditText.text.toString())
        val height = parseWithDefault(heightNumEditText.text.toString())
        var result = weight / Math.pow(height / 100.00, 2.0)
        result = Math.round(result).toDouble()
        showBmiResult(result)
    }

    private fun showBmiResult(bmiValue: Double) {
        val age = parseWithDefault(ageNumEditText.text.toString())
        val underweight = getString(R.string.descriptionUnderweight)
        val correctWeight = getString(R.string.descriptionCorrectWeight)
        val overweight = getString(R.string.descriptionOverweight)
        val obesity = getString(R.string.descriptionObesity)
        val extremeObesity = getString(R.string.descriptionExtremeObesity)
        val resultUnderEighteen = getString(R.string.descriptionResultUnderEighteen)
        var resultName = getString(R.string.descriptionResultName)
        if (age <= 17) {
            resultName = resultUnderEighteen
        }
        if (age in 18..24) {
            if (bmiValue < 19) {
                resultName = underweight
            } else if (bmiValue >= 19 && bmiValue.toInt() < 24) {
                resultName = correctWeight
            } else if (bmiValue >= 24 && bmiValue.toInt() < 29) {
                resultName = overweight
            } else if (bmiValue >= 29 && bmiValue.toInt() <= 39) {
                resultName = obesity
            } else if (bmiValue > 39) {
                resultName = extremeObesity
            }
        } else if (age >= 25 && age <= 34) {
            if (bmiValue < 20) {
                resultName = underweight
            } else if (bmiValue >= 20 && bmiValue.toInt() < 25) {
                resultName = correctWeight
            } else if (bmiValue >= 25 && bmiValue.toInt() < 30) {
                resultName = overweight
            } else if (bmiValue >= 30 && bmiValue.toInt() <= 40) {
                resultName = obesity
            } else if (bmiValue > 40) {
                resultName = extremeObesity
            }
        } else if (age in 35..44) {
            if (bmiValue < 21) {
                resultName = underweight
            } else if (bmiValue >= 21 && bmiValue.toInt() < 26) {
                resultName = correctWeight
            } else if (bmiValue >= 26 && bmiValue.toInt() < 31) {
                resultName = overweight
            } else if (bmiValue >= 31 && bmiValue.toInt() <= 41) {
                resultName = obesity
            } else if (bmiValue > 41) {
                resultName = extremeObesity
            }
        } else if (age in 45..54) {
            if (bmiValue < 22) {
                resultName = underweight
            } else if (bmiValue >= 22 && bmiValue.toInt() < 27) {
                resultName = correctWeight
            } else if (bmiValue >= 27 && bmiValue.toInt() < 32) {
                resultName = overweight
            } else if (bmiValue >= 32 && bmiValue.toInt() <= 42) {
                resultName = obesity
            } else if (bmiValue > 42) {
                resultName = extremeObesity
            }
        } else if (age in 55..64) {
            if (bmiValue < 23) {
                resultName = underweight
            } else if (bmiValue >= 23 && bmiValue.toInt() < 28) {
                resultName = correctWeight
            } else if (bmiValue >= 28 && bmiValue.toInt() < 33) {
                resultName = overweight
            } else if (bmiValue >= 33 && bmiValue.toInt() <= 43) {
                resultName = obesity
            } else if (bmiValue > 43) {
                resultName = extremeObesity
            }
        } else if (age >= 65) {
            if (bmiValue < 24) {
                resultName = underweight
            } else if (bmiValue >= 24 && bmiValue.toInt() < 29) {
                resultName = correctWeight
            } else if (bmiValue >= 29 && bmiValue.toInt() < 34) {
                resultName = overweight
            } else if (bmiValue >= 34 && bmiValue.toInt() <= 44) {
                resultName = obesity
            } else if (bmiValue > 44) {
                resultName = extremeObesity
            }
        }
        resultNumTextView.text = bmiValue.toString() + ""
        resultStringTextView.text = resultName
    }

    private fun parseWithDefault(number: String): Int {
        val defaultVal = 0
        return try {
            number.toInt()
        } catch (e: NumberFormatException) {
            defaultVal
        }
    }

}

