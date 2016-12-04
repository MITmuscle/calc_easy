package com.example.yamada_pc.calc_easy;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView kg_view = (TextView) findViewById(R.id.kg_view);
        final EditText edit = (EditText)findViewById(R.id.edit);
        Button kg_button = (Button) findViewById(R.id.kg_button);
        /*入力した重量を表示*/
        kg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // エディットテキストのテキストを取得
                String text = edit.getText().toString();
                // 取得したテキストを TextView に張り付ける
                kg_view.setText(text);

            }
        });

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
