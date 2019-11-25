package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener {
            try {
                var result : String = "Normal"

                var BMI_reuslt: Double = BMI_cal(weight.text.toString().toDouble(),height.text.toString().toDouble());

                if ( BMI_reuslt <=  18.5) {
                    result = "Under"
                    imageResult.setImageResource(R.drawable.under)
                }else if (BMI_reuslt >= 25) {
                    result = "Over"
                    imageResult.setImageResource(R.drawable.over)
                }else {
                    imageResult.setImageResource(R.drawable.normal)
                }

                BMI_result.text = "%.2f (%s)".format(BMI_reuslt,result)

            }catch (e:Exception) {
                val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show()
            }

            btn_reset.setOnClickListener {
                weight.setText("")
                height.setText("")
                BMI_result.setText("")

                imageResult.setImageResource(R.drawable.empty)
            }
        }

        /*try {
            if ( BMI_reuslt <=  18.5) {
                result = "Under"
                imageResult.setImageResource(R.drawable.under)
            }else if (BMI_reuslt >= 25) {
                result = "Over"
                imageResult.setImageResource(R.drawable.over)
            }else {
                imageResult.setImageResource(R.drawable.normal)
            }

            BMI_result.text = "%.2f (%s)".format(BMI_reuslt,result)
        }catch (e:Exception) {
            val toast:Toast = Toast.makeText(this,"Invalid Input",Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER,0,0);
            toast.show()
        }*/

    }

     fun BMI_cal(weight:Double,height:Double) : Double{

        var BMI: Double = weight / (height*height)

        return BMI.toString().toDouble()
    }
}
