package com.example.ex_test_01

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ex_test_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.dark_header, "Bella", "1"))
        dataList.add(MyItem(R.drawable.ic_delete, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.dark_header, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.dark_header, "Duke", "1"))
        dataList.add(MyItem(R.drawable.alert_light_frame, "Max", "2"))
        dataList.add(MyItem(R.drawable.dialog_holo_dark_frame, "Happy", "4"))
        dataList.add(MyItem(R.drawable.arrow_down_float , "Luna", "3"))
        dataList.add(MyItem(R.drawable.btn_default_small, "Bob", "2"))


        // 어댑터 생성 및 연결
        binding.listView.adapter = MyAdapter(this, dataList)

        // 항목 클릭 이벤트 처리
        binding.listView.setOnItemClickListener{ parent, view, position, id ->
            val name: String = (binding.listView.adapter.getItem(position) as MyItem).aName
            Toast.makeText(this," $name 선택!", Toast.LENGTH_SHORT).show()
        }
    }
}