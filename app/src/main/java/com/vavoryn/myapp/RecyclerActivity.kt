package com.vavoryn.myapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vavoryn.myapp.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private val listStudent= ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcData
        binding.rcData.setHasFixedSize(true)
        binding.rcData.layoutManager = LinearLayoutManager(this)

        listStudent.add(Student(name = "Adin", nim = "778328"))
        listStudent.add(Student(name = "Rose", nim = "423173"))
        listStudent.add(Student(name = "Jack", nim = "642313"))
        listStudent.add(Student(name = "Popy", nim = "8643212"))
        listStudent.add(Student(name = "Duby", nim = "1236342"))
        listStudent.add(Student(name = "Roxy", nim = "9978575"))

        val studentAdapter = StudentAdapter(listStudent)
        studentAdapter.setOnClickCallBack(object : StudentAdapter.onClickCallBack {
            override fun onItemClicked(data: Student) {
                showAlert(data)
            }
        })

        binding.rcData.adapter = studentAdapter

    }

    private fun showAlert(data: Student){
        Toast.makeText(this, "You Clicked " + data.name, Toast.LENGTH_SHORT).show()

    }
}