package com.example.mypractice_15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View)
    {
        val tv_Poroda:TextView=findViewById(R.id.textViewPor)
        val tv_Year:TextView=findViewById(R.id.textViewYear)
        val tv_Month:TextView=findViewById(R.id.textViewMonth)

        if(tv_Poroda!!.text.toString()=="")
        {
            Toast.makeText(this,"Введите породу!!!",Toast.LENGTH_SHORT).show()
            tv_Poroda.requestFocus()
        }
        else if (tv_Year!!.text.toString()=="")
        {
            Toast.makeText(this,"Введите год!!",Toast.LENGTH_SHORT).show()
            tv_Year.requestFocus()
        }
        else if (tv_Year.text.toString().toInt()<1993 || tv_Year.text.toString().toInt()>2023)
        {
            Toast.makeText(this,"Выберите год от 1993 до 2023",Toast.LENGTH_SHORT).show()
            tv_Year.requestFocus()
        }
        else if (tv_Month!!.text.toString()=="")
        {
            Toast.makeText(this,"Введите месяц!!",Toast.LENGTH_SHORT).show()
            tv_Month.requestFocus()
        }
        else if (tv_Month.text.toString().toInt()<1 || tv_Month.text.toString().toInt()>12||tv_Month!!.text.toString()=="")
        {
            Toast.makeText(this,"Введите правильный месяц...",Toast.LENGTH_SHORT).show()
            tv_Month.requestFocus()
        }
        else
        {
            val breed:String = tv_Poroda.text.toString()
            val Year:Int = tv_Year.text.toString().toInt()
            val Month:Int = tv_Month.text.toString().toInt()

            val pet:Pet= Pet(breed,Year,Month)

            val intent:Intent=Intent(this@MainActivity,Mix::class.java)

            intent.putExtra(pet.javaClass.simpleName,pet)

            startActivity(intent)

        }

    }
}