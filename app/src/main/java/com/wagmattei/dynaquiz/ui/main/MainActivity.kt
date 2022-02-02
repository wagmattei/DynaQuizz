package com.wagmattei.dynaquiz.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wagmattei.dynaquiz.R
import com.wagmattei.dynaquiz.ui.quizquestion.QuizzQuestionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideActionBar()

        // Only for teste, replace it
        btn_start.setOnClickListener{
            if(!validate()) {
                Toast.makeText(this@MainActivity, "Preencha seu nome ou apelido, por favor.", Toast.LENGTH_SHORT).show()
            } else  {
                val i = Intent(this, QuizzQuestionActivity::class.java)
                i.putExtra("userName", et_name.text.toString())
                startActivity(i)
            }
        }

    }

    private fun hideActionBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide();
    }

    private fun validate(): Boolean {
        val userName = et_name.text.toString()
        return !userName.isNullOrBlank() && !userName.isNullOrEmpty()
    }
}