package com.vavoryn.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vavoryn.myapp.databinding.RowStudentBinding

class StudentAdapter(private val listData: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.DataViewHolder>() {
    private lateinit var onClickCallback: onClickCallBack

    fun setOnClickCallBack(data: onClickCallBack){
        this.onClickCallback = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(RowStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val (name, nim) = listData[position]
        holder.binding.txtName.text = name
        holder.binding.txtNim.text = nim

//        holder.txtName.setOnClickListener{
//            Toast.makeText(holder.txtName.context, "Clicked", Toast.LENGTH_SHORT).show()
//        }

        holder.itemView.setOnClickListener{
            onClickCallback.onItemClicked(listData[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listData.count()
    }

    interface onClickCallBack{
        fun onItemClicked(data: Student)
    }

//    class DataViewHolder(item: View): RecyclerView.ViewHolder(item){
//        val txtName: TextView = item.findViewById(R.id.txt_name)
//        val txtNim: TextView = item.findViewById(R.id.txt_nim)
//    }

    class DataViewHolder(val binding: RowStudentBinding): RecyclerView.ViewHolder(binding.root)

}