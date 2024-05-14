package com.vavoryn.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vavoryn.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//    private lateinit var text1: TextView
//    private lateinit var btn1: Button
//    private lateinit var btnphone: Button
//    private lateinit var btnRecycler: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        text1 = findViewById<TextView>(R.id.text1)
//        btn1 = findViewById<Button>(R.id.btn1)
//        btnphone = findViewById<Button>(R.id.btnphone)
//        btnRecycler = findViewById(R.id.btn_recycler)


        binding.text1.text = "Hello Programmer"

        // Explicit Intent
        binding.btn1.setOnClickListener {
            val intentDestination = Intent(this@MainActivity, MainActivity2::class.java)
//            intentDestination.putExtra(MainActivity2.EXTRA_DATA, "Hello Friend")
//            intentDestination.putExtra(MainActivity2.EXTRA_DATA, Student(name = "Anwar", nim = "12356"))
//            startActivity(intentDestination)

            resultLauncher.launch((intentDestination))
        }

        binding.btnphone.setOnClickListener {
            val number = "082176392"
            val intentPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intentPhone)
        }

        binding.btnRecycler.setOnClickListener {
            val intentDestination = Intent(this@MainActivity, RecyclerActivity::class.java)
            startActivity(intentDestination)
        }
        binding.btnFragment.setOnClickListener {
            val intentDestination = Intent(this@MainActivity, FragmentActivity::class.java)
            startActivity(intentDestination)
        }

    }
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if(result.resultCode==MainActivity2.RESULT_CODE && result.data != null){
            val name =result.data?.getStringExtra(MainActivity2.EXTRA_RETURN_VALUE)
            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()

        }
    }
}