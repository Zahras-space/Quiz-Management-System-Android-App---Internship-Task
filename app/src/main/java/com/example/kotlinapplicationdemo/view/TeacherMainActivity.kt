package com.example.kotlinapplicationdemo.view
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.AddQuestionActivity
import com.example.kotlinapplicationdemo.DeleteQuestionsActivity
import com.example.kotlinapplicationdemo.DisplayAllQuestionsActivity
import com.example.kotlinapplicationdemo.databinding.ActivityTeacherBinding
import com.example.kotlinapplicationdemo.EditQuestionsActivity

class TeacherMainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityTeacherBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addQuestionBtn.setOnClickListener {
            val intent = Intent(this,AddQuestionActivity ::class.java)
            startActivity(intent)
        }
        binding.editQuestionBtn.setOnClickListener {
            val intent = Intent(this, EditQuestionsActivity::class.java)
            startActivity(intent)
        }

        binding.deleteQuestionBtn.setOnClickListener {
            val intent = Intent(this, DeleteQuestionsActivity ::class.java)
            startActivity(intent)
        }
        binding.displayQuestionsBtn.setOnClickListener {
            val intent = Intent(this, DisplayAllQuestionsActivity::class.java)
            startActivity(intent)
        }

// Exit button
        binding.exitBtn.setOnClickListener {
            finish()
        }
    }

}