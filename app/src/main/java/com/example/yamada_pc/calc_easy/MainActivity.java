package com.example.yamada_pc.calc_easy;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trans_btn = (Button)findViewById(R.id.trans_btn);
        trans_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sub画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.example.yamada_pc.calc_easy","com.example.yamada_pc.calc_easy.SubActivity");
                startActivity(intent);
            }
        });
    }
}
