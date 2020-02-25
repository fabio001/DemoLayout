package com.aybu.demolayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var points =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateRandomNumber()
    }

    public fun buttonCalls(view: View){
        val num1 = btn1.text.toString().toInt()
        val num2 = btn2.text.toString().toInt()
        if(view.id == R.id.btn1){
            if(num1 > num2) {
                //todo increase point
                points++

                Toast.makeText(this, "You got it", Toast.LENGTH_SHORT).show()
            }
            else{
                points--
                //penalty:wrong answer
                Toast.makeText(this, "Study more!", Toast.LENGTH_SHORT).show()
            }

        }else if (view ==btn2){
            if(num1 < num2) {
                //todo increase point
                points++
                Toast.makeText(this, "You got it", Toast.LENGTH_SHORT).show()
            }
            else{
                points--
                //penalty:wrong answer
                Toast.makeText(this, "Study more!", Toast.LENGTH_SHORT).show()
            }
        }
        txtPoints.text = "$points"
        generateRandomNumber()
    }

    private fun generateRandomNumber(){

        var random1 = Random.nextInt(0,10)
        var random2 = Random.nextInt(0,10)

        while (random1 == random2)
            random2 = Random.nextInt(0,10)

        btn1.text = random1.toString()
        btn2.text = random2.toString()
    }
}
