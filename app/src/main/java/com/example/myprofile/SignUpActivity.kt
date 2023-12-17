package com.example.myprofile;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnSup=findViewById<Button>(R.id.supBtnSup)
        btnSup.setOnClickListener {
            val name=findViewById<EditText>(R.id.supEtName)
            val id=findViewById<EditText>(R.id.supEtId)
            val pwd=findViewById<EditText>(R.id.supEtPwd)
            if(name.text.toString()!="" && id.text.toString()!="" && pwd.text.toString()!=""){
                intent.putExtra("id", id.text.toString())
                intent.putExtra("pwd", pwd.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
            else{
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}