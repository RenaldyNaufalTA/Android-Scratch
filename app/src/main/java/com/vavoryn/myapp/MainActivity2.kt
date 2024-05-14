package com.vavoryn.myapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vavoryn.myapp.databinding.ActivityMain2Binding
import com.vavoryn.myapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"

        const val EXTRA_RETURN_VALUE = "extra_return_value"
        const val RESULT_CODE = 110
    }

    private lateinit var binding: ActivityMain2Binding

//    private lateinit var text1: TextView
//    private lateinit var edtName: EditText
//    private lateinit var btnSubmit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        text1 = findViewById<TextView>(R.id.text1)
//        edtName = findViewById<EditText>(R.id.edt_name)
//        btnSubmit = findViewById<Button>(R.id.btn_submit)
//        val strData = intent.getStringExtra(EXTRA_DATA)

        // Check Veersion Android
        val student = if(Build.VERSION.SDK_INT>= 34){
            intent.getParcelableExtra(EXTRA_DATA, Student::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        if (student!=null){
            binding.text1.text = student.name
        }

        binding.btnSubmit.setOnClickListener {
            val name = binding.edtName.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_RETURN_VALUE, name)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
//        text1.text = strData

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}