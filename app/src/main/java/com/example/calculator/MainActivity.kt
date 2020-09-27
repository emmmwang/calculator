package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            //跳转到下一个界面  进行计算
            //创建Intent
            Intent().apply {
                //设置值
                putExtra("A",A.text.toString().toInt())
                //A(得到A本身）。text(得到A的数据(可变字符串)).toString()(变成String).toInt()(变成我们想要的Int类型）
                putExtra("B",B.text.toString().toInt())

                //设置从哪个页面跳到哪个页面
                setClass(this@MainActivity,MainActivity2::class.java)

                //跳转
                //startActivity(this)
                startActivityForResult(this,123)
            }

        }

    }

    //接受回调数据
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==123){
            data?.getIntExtra("result",0).also {
                //将结果赋值到textView上
                result.text=it.toString()
            }
        }
    }
}