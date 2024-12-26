package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Raju")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.button)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        findViewById<Button>(R.id.doneButton).setOnClickListener {
//            addNickName(it)
//        }

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View) {
//        val editText = findViewById<EditText>(R.id.nickName_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_textview)

//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickNameTextView.visibility = View.VISIBLE

        binding.apply {
//            nicknameTextview.text = binding.nickNameEdit.text
            myName?.nickname = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameTextview.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}