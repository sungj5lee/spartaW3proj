package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.GetChars
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val btnSin=findViewById<Button>(R.id.sinBtnSin)
        val btnSup=findViewById<Button>(R.id.sinBtnSup)
        val activlauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
            val id=findViewById<EditText>(R.id.sinEtId)
            val pwd=findViewById<EditText>(R.id.sinEtPwd)
            id.setText(result.data?.getStringExtra("id"))
            pwd.setText(result.data?.getStringExtra("pwd"))
        }
        btnSin.setOnClickListener {
            val id=findViewById<EditText>(R.id.sinEtId)
            val pwd=findViewById<EditText>(R.id.sinEtPwd)
            if(id.text.toString()!="" && pwd.text.toString()!="") {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("signinId", id.text.toString())
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        btnSup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activlauncher.launch(intent)
        }
    }
}