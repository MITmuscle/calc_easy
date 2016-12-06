package com.example.yamada_pc.calc_easy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yamada-PC on 2016/12/03.
 */

public class SubActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        Button btn = (Button)findViewById(R.id.button_calc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText etxtMax_weght = (EditText)findViewById(R.id.max_weight);
                TextView wormUpset1_kg = (TextView)findViewById(R.id.set1kg);
                TextView wormUpset2_kg = (TextView)findViewById(R.id.set2kg);
                TextView wormUpset3_kg = (TextView)findViewById(R.id.set3kg);
                TextView mainset1_kg = (TextView)findViewById(R.id.set4kg);
                TextView mainset2_kg = (TextView)findViewById(R.id.set5kg);
                TextView mainset3_kg = (TextView)findViewById(R.id.set6kg);

                //入力内容の取得
                String Max_weight = etxtMax_weght.getText().toString();
                //数値に変換
                int weight = Integer.parseInt(Max_weight);

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

                wormUpset1_kg.setVisibility(View.VISIBLE);
                wormUpset2_kg.setVisibility(View.VISIBLE);
                wormUpset3_kg.setVisibility(View.VISIBLE);
                mainset1_kg.setVisibility(View.VISIBLE);
                mainset2_kg.setVisibility(View.VISIBLE);
                mainset3_kg.setVisibility(View.VISIBLE);
            }
        });

        Button btn2 = (Button)findViewById(R.id.back_button);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}
