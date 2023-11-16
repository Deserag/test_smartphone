package com.example.test_smartphone

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialog

class Raspi : AppCompatActivity() {
    var nazvanie = "Название"
    var vremia: Int = 10
    private var bottomSheetDialog: BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raspi)

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
    }

    private fun showBottomSheetDialog() {
        bottomSheetDialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.sostav_raspi, null)
        bottomSheetDialog?.setContentView(view)
        val editText = view.findViewById<EditText>(R.id.nazvaniednia)
        val viborVremeni = view.findViewById<EditText>(R.id.vibor_vremeni)
        val closeButton = view.findViewById<Button>(R.id.closeokno)

        closeButton.setOnClickListener {
            nazvanie = editText.text.toString()
            val inputText = viborVremeni.text.toString()
            vremia = inputText.toInt()

            // Добавляем данные в массивы в MainActivity
            val intent = Intent()
            intent.putExtra("nazvanie", nazvanie)
            intent.putExtra("vremia", vremia)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        val all_znach: Button = findViewById(R.id.clockButton)
        all_znach.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Заголовок")
            builder.setMessage("$nazvanie, $vremia")
            builder.setPositiveButton("OK") { dialog, which ->
                // Действие при нажатии кнопки OK
            }
            builder.setNegativeButton("Отмена") { dialog, which ->
                // Действие при нажатии кнопки Отмена
            }
            val dialog = builder.create()
            dialog.show()
        }

        bottomSheetDialog?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        bottomSheetDialog?.dismiss()
    }
}