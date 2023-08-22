package com.example.ex_test_01

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex_test_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.arrow_down_float, "Bella", "1"))
        dataList.add(MyItem(R.drawable.alert_light_frame, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.dialog_frame, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.divider_horizontal_bright, "Duke", "1"))
        dataList.add(MyItem(R.drawable.arrow_down_float, "Max", "2"))
        dataList.add(MyItem(R.drawable.dialog_frame, "Happy", "4"))
        dataList.add(MyItem(R.drawable.ic_media_ff, "Luna", "3"))
        dataList.add(MyItem(R.drawable.dialog_holo_dark_frame, "Bob", "2"))

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@MainActivity," $name 선택!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}