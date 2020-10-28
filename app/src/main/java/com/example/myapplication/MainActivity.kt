package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed_name = findViewById<EditText>(R.id.ed_name);
        var tv_text = findViewById<TextView>(R.id.tv_text);
        var tv_name = findViewById<TextView>(R.id.tv_name);
        var tv_winner = findViewById<TextView>(R.id.tv_winner);
        var tv_mmora = findViewById<TextView>(R.id.tv_mmora);
        var tv_cmora = findViewById<TextView>(R.id.tv_cmora);
        var btn_scissor = findViewById<RadioButton>(R.id.btn_scissor);
        var btn_stone = findViewById<RadioButton>(R.id.btn_stone);
        var btn_paper = findViewById<RadioButton>(R.id.btn_paper);
        var btn_mora = findViewById<Button>(R.id.btn_mora);

        btn_mora.setOnClickListener {
            if (ed_name.length() < 1)
                tv_text.setText("請輸入玩家姓名")
            else {
                tv_name.text = "名字\n${ed_name.text}"
                tv_mmora.text = "我出出拳\n${if (btn_scissor.isChecked) "剪刀" else if (btn_stone.isChecked) "石頭ˊ" else "布"}"
                val computer = (Math.random() * 3).toInt()
                tv_cmora.text = "電腦出拳頭\n${if (computer == 0) "剪刀" else if (computer == 1) "石頭" else "布"}"

                when {
                    btn_scissor.isChecked && computer == 2 ||
                            btn_stone.isChecked && computer == 0 ||
                            btn_paper.isChecked && computer == 1 -> {
                        tv_winner.text = "勝利者\n${ed_name.text}"
                        tv_text.text = "恭喜你獲勝了"
                    }
                    btn_scissor.isChecked && computer == 1 ||
                            btn_stone.isChecked && computer == 2 ||
                            btn_paper.isChecked && computer == 0 -> {
                        tv_winner.text = "勝利者\n電腦"
                        tv_text.text = "可惜，電腦獲勝了"
                    }
                    else -> {
                        tv_winner.text = "勝利者\n平手"
                        tv_text.text = "平局，請再試一次"
                    }

                }
            }
        }
    }
}