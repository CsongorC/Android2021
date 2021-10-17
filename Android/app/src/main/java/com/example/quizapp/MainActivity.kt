package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

const val TAG: String = "MainActivity"
const val USERNAME_EXTRA: String = "username"

class MainActivity : AppCompatActivity() {
    private lateinit var playerName: EditText
    private lateinit var startButton: Button

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        registerListeners()
    }

    private fun registerListeners() {
        startButton.setOnClickListener { view ->
            if (playerName.text.toString().isValidPlayerName()) {
                Snackbar.make(this, view, "Please enter your name", Snackbar.LENGTH_SHORT).show()
                Log.i(TAG, "Start button pressed")
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java).apply {
                    putExtra(USERNAME_EXTRA, playerName.text.trim().toString())
                }
                startActivity(intent)
            }
        }

        val getPerson = registerForActivityResult(ActivityResultContracts.PickContact()) { uri ->
            val cursor = contentResolver.query(
                uri,
                arrayOf(ContactsContract.Contacts.DISPLAY_NAME),
                null,
                null,
                null
            )
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    val nameIdx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                    playerName.setText(cursor.getString(nameIdx))
                }
            }
            cursor?.close()
        }

        contact.setOnClickListener {
            getPerson.launch()
        }
    }

    private fun initializeView() {
        playerName = findViewById(R.id.playerNameInput)
        startButton = findViewById(R.id.btn_start)
    }

    private fun String.isValidPlayerName(): Boolean = this.trim().isEmpty()
}