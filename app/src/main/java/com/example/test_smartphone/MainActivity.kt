package com.example.test_smartphone

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.core.view.isVisible
import com.example.test_smartphone.Raspi

class MainActivity : ComponentActivity() {
    // Объявляем переменные для работы с SharedPreferences и массивами данных
    private lateinit var sharedPref: SharedPreferences
    val nazvanieArray = mutableListOf<String>()
    val vremiaArray = mutableListOf<Int>()
    val colorArray = mutableListOf<String>()
    private lateinit var buttons: Array<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)

        // Инициализируем SharedPreferences
        sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        // Загружаем данные из SharedPreferences
        loadDataFromPreferences()

        // Находим кнопки и устанавливаем для них обработчики
        buttons = arrayOf(
            findViewById(R.id.vid_raspi_1), findViewById(R.id.vid_raspi_2), findViewById(R.id.vid_raspi_3),
            // ... (добавьте остальные кнопки здесь)
            findViewById(R.id.vid_raspi_14), findViewById(R.id.vid_raspi_15)
        )

        // Находим кнопку для создания нового элемента и устанавливаем для нее обработчик
        val sozdanie_raspi: Button = findViewById(R.id.createButton)
        sozdanie_raspi.setOnClickListener{
            val intent = Intent(this, Raspi::class.java)
            startActivityForResult(intent, 1)
        }

        // Находим кнопку для изменения элемента и устанавливаем для нее обработчик
        val izmena: Button = findViewById(R.id.change)
        izmena.setOnClickListener{
            val intent = Intent(this,Raspi::class.java)
            startActivity(intent)
        }

        // Обновляем отображение кнопок на основе загруженных данных
        updateButtons()
    }

    // Метод для загрузки данных из SharedPreferences
    private fun loadDataFromPreferences() {
        nazvanieArray.clear()
        vremiaArray.clear()
        colorArray.clear()
        val size = sharedPref.getInt("arraySize", 0)
        for (i in 0 until size) {
            nazvanieArray.add(sharedPref.getString("nazvanie$i", "") ?: "")
            vremiaArray.add(sharedPref.getInt("vremia$i", 0))
            colorArray.add(sharedPref.getString("color$i", "") ?: "")
        }
    }

    // Метод для сохранения данных в SharedPreferences
    private fun saveDataToPreferences() {
        val editor = sharedPref.edit()
        editor.putInt("arraySize", nazvanieArray.size)
        for (i in nazvanieArray.indices) {
            editor.putString("nazvanie$i", nazvanieArray[i])
            editor.putInt("vremia$i", vremiaArray[i])
            editor.putString("color$i", colorArray[i])
        }
        editor.apply()
    }

    // Обработка результата возвращаемого активностью Raspi
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val nazvanie = data?.getStringExtra("nazvanie")
            val vremia = data?.getIntExtra("vremia", 0)
            val color = data?.getStringExtra("color")

            if (nazvanie != null) {
                nazvanieArray.add(nazvanie)
            }
            if (vremia != null) {
                vremiaArray.add(vremia)
            }
            if (color != null) {
                colorArray.add(color)
            }

            // Сохраняем обновленные данные в SharedPreferences
            saveDataToPreferences()
            // Обновляем отображение кнопок на основе обновленных данных
            updateButtons()
        }
    }

    // Обновление отображения кнопок на основе массивов данных
    private fun updateButtons() {
        for (i in buttons.indices) {
            if (i < nazvanieArray.size && i < vremiaArray.size && i < colorArray.size &&
                nazvanieArray[i].isNotEmpty() && vremiaArray[i] != 0 && colorArray[i].isNotEmpty()) {
                buttons[i].setOnClickListener {
                    val message = "Название: ${nazvanieArray[i]}\nВремя: ${vremiaArray[i]}\nЦвет: ${colorArray[i]}"
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Данные о дне")
                    builder.setMessage(message)
                    builder.setPositiveButton("OK") { dialog, which ->
                        // Действие, которое будет выполняться при нажатии на кнопку "OK"
                    }
                    val dialog = builder.create()
                    dialog.show()
                }
            } else {
                buttons[i].visibility = View.GONE
            }
        }
    }
}