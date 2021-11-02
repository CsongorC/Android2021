package com.example.quizapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_quiz_start.*


class QuizStartFragment : Fragment(R.layout.fragment_quiz_start) {

    private lateinit var playerName: EditText
    private lateinit var startButton: Button
    private lateinit var contactsButton: Button

    val viewModel: QuestionViewModel by activityViewModels()

    private val getMyContact =
        registerForActivityResult(ActivityResultContracts.PickContact()) {
            it?.also { contactUri ->
                val projection = arrayOf(ContactsContract.Contacts.DISPLAY_NAME)
                val cursor =
                    requireActivity().contentResolver.query(it, projection, null, null, null)
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        val nameIdx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                        playerName.setText(cursor.getString(nameIdx))
                    }
                }
                cursor?.close()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_start, container, false)
        view?.apply {
            initializeView(this)
            registerListeners(this)
        }
        return view
    }

    private fun initializeView(view: View) {
        playerName = view.findViewById(R.id.playerNameInput)
        startButton = view.findViewById(R.id.btn_start)
        contactsButton = view.findViewById(R.id.contact)
    }

    private fun registerListeners(view: View) {
        startButton.setOnClickListener {
            if (playerName.text.toString().isValidPlayerName()) {
                Snackbar.make(requireContext(), it, "You must enter your name", Snackbar.LENGTH_SHORT).show()
            }else{
                findNavController().navigate(R.id.action_quizStartFragment_to_questionFragment)
                if(viewModel.getName() != playerName.text.toString()){
                    viewModel.setHighScore("0")
                }
                viewModel.setName(playerName.text.toString())
            }
        }

        contactsButton.setOnClickListener {
            getMyContact.launch()
        }
    }

    private fun String.isValidPlayerName(): Boolean = this.trim().isEmpty()
}