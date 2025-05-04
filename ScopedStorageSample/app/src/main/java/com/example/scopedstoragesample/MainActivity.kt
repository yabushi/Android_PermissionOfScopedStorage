package com.example.scopedstoragesample

import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val externalStorage = getExternalFilesDir(null)

        val show = findViewById<Button>(R.id.show)
        show.setOnClickListener {

            val testFile = File(externalStorage, "test.txt")
            // val testFile = File("/storage/emulated/0/Android/data/com.example.scopedstoragesample/files/test.txt")
            if (testFile.exists() && testFile.isFile) {
                var reader: BufferedReader? = null
                try {
                    reader = BufferedReader(FileReader(testFile))
                    var line: String? = reader.readLine()
                    while (line != null) {
                        println(line)
                        line = reader.readLine()
                    }
                } catch (e: Exception) {
                    println("Error reading file: ${e.message}")
                } finally {
                    reader?.close()
                }
            } else {
                println("File not found or not a file: ${testFile.path}")
            }
        }

        val read = findViewById<Button>(R.id.read)
        read.setOnClickListener {
            File(getExternalFilesDir(null), "test.txt").writer().use {
                val currentDateTime = LocalDateTime.now()
                it.write("Write by com.example.scopedstoragesample: $currentDateTime")
            }
        }
    }
}