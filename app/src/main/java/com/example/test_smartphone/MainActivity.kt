package com.example.test_smartphone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val nazvanieArray = mutableListOf<String>()
    private val vremiaArray = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)

        val all_znach: Button = findViewById(R.id.clockButton)
        all_znach.setOnClickListener {
            showAllData()
        }

        val create_raspi: Button = findViewById(R.id.createButton)
        create_raspi.setOnClickListener {
            val intent = Intent(this, Raspi::class.java)
            startActivityForResult(intent, 1)
        }

        updateButtonsVisibility()
    }

    private fun showAllData() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Заголовок")
        builder.setMessage("${nazvanieArray}, ${vremiaArray}")
        builder.setPositiveButton("OK") { dialog, which -> }
        builder.setNegativeButton("Отмена") { dialog, which -> }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val nazvanie = data?.getStringExtra("nazvanie")
            val vremia = data?.getIntExtra("vremia", 0)
            if (nazvanie != null && vremia != null) {
                addDataToArrays(nazvanie, vremia)
                updateButtonsVisibility()
            }
        }
    }

    private fun addDataToArrays(nazvanie: String, vremia: Int) {
        nazvanieArray.add(nazvanie)
        vremiaArray.add(vremia)
    }

    private fun updateButtonsVisibility() {
        for (i in 1..15) {
            val buttonId = resources.getIdentifier("vid_raspi_$i", "id", packageName)
            val button = findViewById<Button>(buttonId)
            if (i <= nazvanieArray.size) {
                button.visibility = Button.VISIBLE
                button.setOnClickListener { vizov_okna(i - 1) }
            } else {
                button.visibility = Button.GONE
            }
        }
    }

    private fun vizov_okna(i: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Данные о дне:")
        builder.setMessage("Название: ${nazvanieArray[i]}\nВремя: ${vremiaArray[i]}")
        builder.setPositiveButton("OK") { dialog, which -> }
        val dialog = builder.create()
        dialog.show()
    }
}