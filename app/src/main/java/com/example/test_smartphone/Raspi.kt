package com.example.test_smartphone

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.CalendarView
import com.example.test_smartphone.R
import com.example.test_smartphone.MainActivity

import java.time.LocalDate
import java.util.Calendar

class Raspi : AppCompatActivity() {
    var nazvanie = ""
    var vremia: Int = 0
    var colors = arrayOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raspi)

        val view = layoutInflater.inflate(R.layout.activity_raspi, null)

        // Используем массив кнопок для создания расписания
        val scheduleButtons = listOf<Button>(
            findViewById(R.id.day_1), findViewById(R.id.day_2), findViewById(R.id.day_3),
            findViewById(R.id.day_4), findViewById(R.id.day_5), findViewById(R.id.day_6),
            findViewById(R.id.day_7), findViewById(R.id.day_8), findViewById(R.id.day_9),
            findViewById(R.id.day_10), findViewById(R.id.day_11), findViewById(R.id.day_12),
            findViewById(R.id.day_13), findViewById(R.id.day_14), findViewById(R.id.day_15)
        )
        scheduleButtons.forEach { button ->
            button.setOnClickListener {
                showBottomSheetDialog()
            }
        }

        val raspisanie: Button = findViewById(R.id.scheduleButton)
        raspisanie.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.sostav_raspi, null)
        bottomSheetDialog.setContentView(view)
        val editText = view.findViewById<EditText>(R.id.nazvaniednia)
        val viborVremeni = view.findViewById<EditText>(R.id.vibor_vremeni)
        val closeButton = view.findViewById<Button>(R.id.closeokno)

        val colorButtons = listOf(
            view.findViewById<Button>(R.id.day_red),
            view.findViewById<Button>(R.id.day_green),
            view.findViewById<Button>(R.id.day_blue),
            view.findViewById<Button>(R.id.day_yellow),
            view.findViewById<Button>(R.id.day_orange)
        )

        closeButton.setOnClickListener {
            nazvanie = editText.text.toString()
            val inputText = viborVremeni.text.toString()
            vremia = inputText.toInt()
            val obj = MainActivity()
            obj.nazvanieArray.add(nazvanie)
            obj.vremiaArray.add(vremia)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Заголовок")
            builder.setMessage("${obj.nazvanieArray}, ${obj.vremiaArray},$colors")
            builder.setPositiveButton("OK") { dialog, which ->
                // Действие при нажатии кнопки OK
            }
            builder.setNegativeButton("Отмена") { dialog, which ->
                // Действие при нажатии кнопки Отмена
            }
            val dialog = builder.create()
            dialog.show()

            // Устанавливаем обработчики нажатия на кнопки цвета
            for (button in colorButtons) {
                button.setOnClickListener {
                    val color = (button.background as ColorDrawable).color // Получаем цвет кнопки
                    colors.plus(color) // Добавляем цвет в массив
                }
            }

            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }
}
