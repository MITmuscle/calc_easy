package com.example.yamada_pc.calc_easy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;



/**
 * Created by yamada-PC on 2016/12/03.
 * Recreated by akasaka0107 on 2016/12/15.
 */

public class SubActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        /*Custom_Dialogからセット数とウォームアップセット数を取得*/
        final TextView set_select_view = (TextView) findViewById(R.id.setselect_view);
        int set =Custom_Dialog.set+1;
        int warmset =Custom_Dialog.warmset;
        set_select_view.setText(Integer.toString(set));

        // MainActivityからMAX_weightとweight_RM[]を取得し選択された重量を TextView に張り付ける
        final TextView set_kg_view = (TextView) findViewById(R.id.set_kg_view);
        int MAX_weight = MainActivity.MAX_weight;
        int weight_RM[] = MainActivity.weight_RM;
        int weight = 0;

        /*Custom_Dialogからセット数を取得*/
        final TextView set_RM_view = (TextView) findViewById(R.id.set_RM_view);
        int select = MainActivity.select;
        set_RM_view.setText(Integer.toString(select));

        for(int i=1 ; i<=21 ; i++){
            if(select==1){
                set_kg_view.setText(Double.toString(MAX_weight));
                set_kg_view.setMaxLines(1);
                weight = MAX_weight;
            }
            else if(select==i && select!=1 ){
                set_kg_view.setText(Double.toString(weight_RM[i]));
                set_kg_view.setMaxLines(1);
                weight =weight_RM[i];
            }
        }
        /*ウォームアップセット数の表示*/
        if(warmset==0){
            LinearLayout warmset1 = (LinearLayout) findViewById(R.id.warmset1_layout);
            warmset1.setVisibility(View.GONE);
            LinearLayout warmset2 = (LinearLayout) findViewById(R.id.warmset2_layout);
            warmset2.setVisibility(View.GONE);
            LinearLayout warmset3 = (LinearLayout) findViewById(R.id.warmset3_layout);
            warmset3.setVisibility(View.GONE);
        }
        else if (warmset==1){
            LinearLayout warmset2 = (LinearLayout) findViewById(R.id.warmset2_layout);
            warmset2.setVisibility(View.GONE);
            LinearLayout warmset3 = (LinearLayout) findViewById(R.id.warmset3_layout);
            warmset3.setVisibility(View.GONE);

        }
        else if (warmset==2){
            LinearLayout warmset3 = (LinearLayout) findViewById(R.id.warmset3_layout);
            warmset3.setVisibility(View.GONE);

        }

        //EditText etxtMax_weight = (EditText)findViewById(R.id.max_weight);
        TextView wormUpset1_kg = (TextView)findViewById(R.id.set1kg);
        TextView wormUpset2_kg = (TextView)findViewById(R.id.set2kg);
        TextView wormUpset3_kg = (TextView)findViewById(R.id.set3kg);
        TextView mainset1_kg = (TextView)findViewById(R.id.set4kg);
        TextView mainset2_kg = (TextView)findViewById(R.id.set5kg);
        TextView mainset3_kg = (TextView)findViewById(R.id.set6kg);

        //入力内容の取得
        //String Max_weight = etxtMax_weight.getText().toString();
        //数値に変換


        //それぞれの％に合わせて乗算
        double wormUpset1 = weight * 0.2;
        double wormUpset2 = weight * 0.55;
        double wormUpset3 = weight * 0.7;
        double mainset = weight * 0.8;

        //小数点以下切り上げて整数値に変更
        wormUpset1 = (int)Math.floor(wormUpset1);
        wormUpset2 = (int)Math.floor(wormUpset2);
        wormUpset3 = (int)Math.floor(wormUpset3);
        mainset = (int)Math.floor(mainset);

        wormUpset1_kg.setText(Double.toString(wormUpset1));
        wormUpset2_kg.setText(Double.toString(wormUpset2));
        wormUpset3_kg.setText(Double.toString(wormUpset3));
        mainset1_kg.setText(Double.toString(mainset));
        mainset2_kg.setText(Double.toString(mainset));
        mainset3_kg.setText(Double.toString(mainset));

        /*実行画面に映るボタン設定*/
        Button act_button = (Button) findViewById(R.id.act_button);
        act_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClassName("com.example.yamada_pc.calc_easy","com.example.yamada_pc.calc_easy.Actscreen");
                startActivity(intent);
            }
        });

        /*前の画面に戻る設定*/
        Button btn2 = (Button)findViewById(R.id.back_button);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}
