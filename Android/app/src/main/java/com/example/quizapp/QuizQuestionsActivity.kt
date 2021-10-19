package com.example.quizapp
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_quiz_questions.*


class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        initializeView()
        registerListeners()
    }

    private fun initializeView() {
        val userName = intent.getStringExtra(USERNAME_EXTRA)

        say_hello.text = "Hello, ${userName}!"
    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun registerListeners() {
        val getImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { image_preview.setImageURI(uri) }
        }

        chooseImage.setOnClickListener {
            getImage.launch("image/*")
        }

        takeImage.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            image_preview.setImageBitmap(imageBitmap)
        }
    }
}