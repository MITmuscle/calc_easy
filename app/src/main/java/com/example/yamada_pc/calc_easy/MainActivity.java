package com.example.yamada_pc.calc_easy;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView MAX_kg_view = (TextView) findViewById(R.id.MAX_kg_view);
        final TextView weight_RM3 =(TextView) findViewById(R.id.weight_RM3);
        final TextView weight_RM5 =(TextView) findViewById(R.id.weight_RM5);
        final TextView weight_RM7 =(TextView) findViewById(R.id.weight_RM7);
        final EditText edit = (EditText)findViewById(R.id.edit);
        Button kg_button = (Button) findViewById(R.id.kg_button);


        /*入力した重量を表示*/
        kg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Spinnerオブジェクトを取得
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                // spinnerから回数を取得
                int RM = spinner.getSelectedItemPosition();
                // 入力した重量をDouble型に変換
                Double weight = Double.parseDouble(edit.getText().toString());
                /*計算式1の場合*/
                Double MAX_weight = weight * 0.0333 * (RM+1) + weight;
                // 取得したMAX_weightを TextView に張り付ける
                MAX_kg_view.setText(Double.toString(MAX_weight));
                MAX_kg_view.setMaxLines(1);

                /*計算式1の場合で各回数で推定される重量*/
                Double weight_RM[] = new Double[21];
                Double j =1.0;
                for(int i = 1 ; i<=20 ; i++ ){
                    weight_RM[i]=MAX_weight/(0.0333*i+1);
                    /*weight_RM[i]=MAX_weight*j;
                    j=j-0.027;*/
                }

                // 取得したweight_RM3を TextView に張り付ける
                weight_RM3.setText(Double.toString(weight_RM[3]));
                weight_RM3.setMaxLines(1);

                // 取得したweight_RM5を TextView に張り付ける
                weight_RM5.setText(Double.toString(weight_RM[5]));
                weight_RM5.setMaxLines(1);

                // 取得したweight_RM7を TextView に張り付ける
                weight_RM7.setText(Double.toString(weight_RM[7]));
                weight_RM7.setMaxLines(1);

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
