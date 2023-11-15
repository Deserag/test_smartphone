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
        //
        // Инициализируем SharedPreferences
        sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        // Загружаем данные из SharedPreferences
        loadDataFromPreferences()

        val day_raspi_1: Button =  findViewById(R.id.vid_raspi_1)

        if (nazvanieArray[0].isNotEmpty() && vremiaArray[0] != 0 && colorArray[0].isNotEmpty()) {
            day_raspi_1.setOnClickListener {
                val message = "Название: ${nazvanieArray[0]}\nВремя: ${vremiaArray[0]}\nЦвет: ${colorArray[0]}"
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Данные из массивов")
                builder.setMessage(message)
                builder.setPositiveButton("OK") { dialog, which ->
                    // Действие, которое будет выполняться при нажатии на кнопку "OK"
                }
                val dialog = builder.create()
                dialog.show()
            }
        }
        else {
            day_raspi_1.visibility = View.GONE // Скрываем кнопку, если массивы пустые
        }
        val day_raspi_2: Button = findViewById(R.id.vid_raspi_2)

        if (nazvanieArray.size > 1 && vremiaArray.size > 1  &&
            nazvanieArray[1].isNotEmpty() && vremiaArray[1] != 0 ) {
            day_raspi_2.setOnClickListener {
                val message = "Название: ${nazvanieArray[1]}\nВремя: ${vremiaArray[1]}\nЦвет: ${colorArray[1]}"
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
            day_raspi_2.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }

        val day_raspi_3: Button = findViewById(R.id.vid_raspi_3)

        if (nazvanieArray.size > 2 && vremiaArray.size > 2 && colorArray.size > 2 &&
            nazvanieArray[2].isNotEmpty() && vremiaArray[2] != 0 && colorArray[2].isNotEmpty()) {
            day_raspi_3.setOnClickListener {
                val message = "Название: ${nazvanieArray[2]}\nВремя: ${vremiaArray[2]}\nЦвет: ${colorArray[2]}"
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
            day_raspi_3.isVisible = false
        }

        val day_raspi_4: Button = findViewById(R.id.vid_raspi_4)

        if (nazvanieArray.size > 3 && vremiaArray.size > 3 && colorArray.size > 3 &&
            nazvanieArray[3].isNotEmpty() && vremiaArray[3] != 0 && colorArray[3].isNotEmpty()) {
            day_raspi_4.setOnClickListener {
                val message = "Название: ${nazvanieArray[3]}\nВремя: ${vremiaArray[3]}\nЦвет: ${colorArray[3]}"
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
            day_raspi_4.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }


        val day_raspi_5: Button = findViewById(R.id.vid_raspi_5)

        if (nazvanieArray.size > 4 && vremiaArray.size > 4 && colorArray.size > 4 &&
            nazvanieArray[4].isNotEmpty() && vremiaArray[4] != 0 && colorArray[4].isNotEmpty()) {
            day_raspi_5.setOnClickListener {
                val message = "Название: ${nazvanieArray[4]}\nВремя: ${vremiaArray[4]}\nЦвет: ${colorArray[4]}"
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
            day_raspi_5.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }
        val day_raspi_6: Button =  findViewById(R.id.vid_raspi_6)

        if (nazvanieArray[5].isNotEmpty() && vremiaArray[5] != 0 && colorArray[5].isNotEmpty()) {
            day_raspi_1.setOnClickListener {
                val message = "Название: ${nazvanieArray[5]}\nВремя: ${vremiaArray[5]}\nЦвет: ${colorArray[5]}"
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Данные из массивов")
                builder.setMessage(message)
                builder.setPositiveButton("OK") { dialog, which ->
                    // Действие, которое будет выполняться при нажатии на кнопку "OK"
                }
                val dialog = builder.create()
                dialog.show()
            }
        }
        else {
            day_raspi_6.visibility = View.GONE // Скрываем кнопку, если массивы пустые
        }
        val day_raspi_7: Button = findViewById(R.id.vid_raspi_7)

        if (nazvanieArray.size > 6 && vremiaArray.size > 6  && nazvanieArray[6].isNotEmpty() && vremiaArray[6] != 0 ) {
            day_raspi_7.setOnClickListener {
                val message = "Название: ${nazvanieArray[6]}\nВремя: ${vremiaArray[6]}\nЦвет: ${colorArray[6]}"
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
            day_raspi_7.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }

        val day_raspi_8: Button = findViewById(R.id.vid_raspi_8)

        if (nazvanieArray.size > 7 && vremiaArray.size > 7 && colorArray.size > 7 && nazvanieArray[7].isNotEmpty() && vremiaArray[7] != 0 && colorArray[7].isNotEmpty()) {
            day_raspi_8.setOnClickListener {
                val message = "Название: ${nazvanieArray[7]}\nВремя: ${vremiaArray[7]}\nЦвет: ${colorArray[7]}"
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
            day_raspi_8.isVisible = false
        }

        val day_raspi_9: Button = findViewById(R.id.vid_raspi_9)

        if (nazvanieArray.size > 8 && vremiaArray.size > 8 && colorArray.size > 8 &&
            nazvanieArray[8].isNotEmpty() && vremiaArray[8] != 0 && colorArray[8].isNotEmpty()) {
            day_raspi_9.setOnClickListener {
                val message = "Название: ${nazvanieArray[8]}\nВремя: ${vremiaArray[8]}\nЦвет: ${colorArray[8]}"
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
            day_raspi_9.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }


        val day_raspi_10: Button = findViewById(R.id.vid_raspi_10)

        if (nazvanieArray.size > 9 && vremiaArray.size > 9 && colorArray.size > 9 && nazvanieArray[4].isNotEmpty() && vremiaArray[4] != 0 && colorArray[4].isNotEmpty()) {
            day_raspi_10.setOnClickListener {
                val message = "Название: ${nazvanieArray[9]}\nВремя: ${vremiaArray[9]}\nЦвет: ${colorArray[9]}"
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
            day_raspi_10.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }
        val day_raspi_11: Button =  findViewById(R.id.vid_raspi_11)

        if (nazvanieArray[10].isNotEmpty() && vremiaArray[10] != 0 && colorArray[10].isNotEmpty()) {
            day_raspi_11.setOnClickListener {
                val message = "Название: ${nazvanieArray[10]}\nВремя: ${vremiaArray[10]}\nЦвет: ${colorArray[0]}"
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Данные из массивов")
                builder.setMessage(message)
                builder.setPositiveButton("OK") { dialog, which ->
                    // Действие, которое будет выполняться при нажатии на кнопку "OK"
                }
                val dialog = builder.create()
                dialog.show()
            }
        }
        else {
            day_raspi_11.visibility = View.GONE // Скрываем кнопку, если массивы пустые
        }
        val day_raspi_12: Button = findViewById(R.id.vid_raspi_12)

        if (nazvanieArray.size > 11 && vremiaArray.size > 11  && nazvanieArray[11].isNotEmpty() && vremiaArray[11] != 0 ) {
            day_raspi_12.setOnClickListener {
                val message = "Название: ${nazvanieArray[11]}\nВремя: ${vremiaArray[11]}\nЦвет: ${colorArray[11]}"
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
            day_raspi_12.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }

        val day_raspi_13: Button = findViewById(R.id.vid_raspi_13)

        if (nazvanieArray.size > 12 && vremiaArray.size > 12 && colorArray.size > 12 && nazvanieArray[12].isNotEmpty() && vremiaArray[12] != 0 && colorArray[12].isNotEmpty()) {
            day_raspi_13.setOnClickListener {
                val message = "Название: ${nazvanieArray[12]}\nВремя: ${vremiaArray[12]}\nЦвет: ${colorArray[12]}"
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
            day_raspi_13.isVisible = false
        }

        val day_raspi_14: Button = findViewById(R.id.vid_raspi_14)

        if (nazvanieArray.size > 13 && vremiaArray.size > 13 && colorArray.size > 13 && nazvanieArray[13].isNotEmpty() && vremiaArray[13] != 0 && colorArray[13].isNotEmpty()) {
            day_raspi_14.setOnClickListener {
                val message = "Название: ${nazvanieArray[13]}\nВремя: ${vremiaArray[13]}\nЦвет: ${colorArray[13]}"
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
            day_raspi_14.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
        }


        val day_raspi_15: Button = findViewById(R.id.vid_raspi_15)

        if (nazvanieArray.size > 14 && vremiaArray.size > 14 && colorArray.size > 14 &&
            nazvanieArray[14].isNotEmpty() && vremiaArray[14] != 0 && colorArray[14].isNotEmpty()) {
            day_raspi_15.setOnClickListener {
                val message = "Название: ${nazvanieArray[14]}\nВремя: ${vremiaArray[4]}\nЦвет: ${colorArray[4]}"
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
            day_raspi_5.visibility = View.GONE // Скрываем кнопку, если массивы пустые или второго элемента нет
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