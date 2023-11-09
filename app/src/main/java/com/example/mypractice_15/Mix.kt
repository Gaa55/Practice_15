package com.example.mypractice_15

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Mix : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mix)

        val tv: TextView = findViewById(R.id.textView)

        var pet: Pet = Pet()

        val arguments: Bundle? = intent.extras
        if (arguments != null) {
            pet = arguments.getParcelable<Pet>(pet.javaClass.simpleName) as Pet
            tv.text = "Месяц: ${pet.getMonth()}\n Порода:${pet.getBreed()}\n Год: ${pet.getYear()}"
        }
    }
}