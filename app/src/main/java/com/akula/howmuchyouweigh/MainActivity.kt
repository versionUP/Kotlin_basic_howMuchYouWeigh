package com.akula.howmuchyouweigh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {


    val  marsGravity = 0.38
    val  jupiterGravity = 2.34
    val  venusGravity = 0.91

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonID.setOnClickListener{

          //  var res = calculateWeight(weight.toString().toDouble())

            //displayTextID.text =  "you weigh " + res.toString() + " on mars"
        }


        marsCheckBox.setOnClickListener(this)
        venusCheckBox.setOnClickListener(this)
        jupoitorCheckBox.setOnClickListener(this)
    }


    fun calculateWeight(userWeight: Double) : Double{

        var result = userWeight * marsGravity

        return result
    }


    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked :Boolean = v.isChecked
        var weight =  editTextID.text

        when(v.id) {
            R.id.marsCheckBox -> if (isChecked && !TextUtils.isEmpty(weight.toString())){
                calculateWeightForDifferentPlanets(weight.toString().toDouble(),v)
                venusCheckBox.isChecked = false
                jupoitorCheckBox.isChecked = false
            }
            R.id.venusCheckBox -> if (isChecked && !TextUtils.isEmpty(weight.toString())){
                calculateWeightForDifferentPlanets(weight.toString().toDouble(),v)
                marsCheckBox.isChecked = false
                jupoitorCheckBox.isChecked = false
            }
            R.id.jupoitorCheckBox -> if (isChecked && !TextUtils.isEmpty(weight.toString())){
                calculateWeightForDifferentPlanets(weight.toString().toDouble(),v)
                venusCheckBox.isChecked = false
                marsCheckBox.isChecked = false
            }
            }
    }

    fun  calculateWeightForDifferentPlanets(userWeight: Double, checkBox:CheckBox ){
        var result:Double?
        when(checkBox.id) {
            R.id.marsCheckBox -> {
                result = userWeight * marsGravity
                displayTextID.text = "you weigh " +  result.format(2) + " on Mars"

            }
            R.id.venusCheckBox -> {

                result = userWeight * venusGravity
                displayTextID.text = "you weigh " +  result.format(2) +" on venus"

            }
            R.id.jupoitorCheckBox -> {
            result = userWeight * jupiterGravity
                displayTextID.text = "you weigh " +  result.format(2) + " on Jupiter"

            }
            else -> {result = userWeight * marsGravity
                displayTextID.text = "you weigh " +  result.toString() + " on Mars"
            }

        }

    }

    fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

}
