package com.example.scopedstorageattacker

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val show = findViewById<Button>(R.id.show)
        show.setOnClickListener {
            // 結果表示用のtextViewを初期化
            textView.text = ""

            // 他アプリのScopedStorage内test.txtのパスを直接指定する
            val testFile = File("/storage/emulated/0/Android/data/com.example.scopedstoragesample/files/test.txt")

            if (testFile.exists() && testFile.isFile) {
                var reader: BufferedReader? = null
                try {
                    reader = BufferedReader(FileReader(testFile))
                    var line: String? = reader.readLine()
                    while (line != null) {
                        println(line)
                        textView.append(line)
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
    }
}