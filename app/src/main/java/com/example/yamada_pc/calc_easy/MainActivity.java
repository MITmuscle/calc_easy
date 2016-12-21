package com.example.yamada_pc.calc_easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.text.TextWatcher;

/**
 * Created by akasaka0107 on 2016/12/03.
  */

public class MainActivity extends AppCompatActivity {
    /*入力された最大重量となる値*/
    public static int MAX_weight;
    public static int Prod;
    /*計算式1の場合で各回数で推定される重量*/
    public static int weight_RM[] = new int[21];

    public static int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

       /* // Spinnerオブジェクトを取得
       final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        //Spinnerの文字サイズを大きくする
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,
                getResources().getStringArray(R.array.Numberlist));
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/


        final TextView MAX_kg_view = (TextView) findViewById(R.id.MAX_kg_view);
        final TextView weight_RM3 =(TextView) findViewById(R.id.weight_RM3);
        final TextView weight_RM5 =(TextView) findViewById(R.id.weight_RM5);
        final TextView weight_RM7 =(TextView) findViewById(R.id.weight_RM7);
        final TextView weight_RM8 =(TextView) findViewById(R.id.weight_RM8);
        final TextView weight_RM10 =(TextView) findViewById(R.id.weight_RM10);
        final TextView weight_RM12 =(TextView) findViewById(R.id.weight_RM12);
        final TextView weight_RM15 =(TextView) findViewById(R.id.weight_RM15);
        final TextView weight_RM20 =(TextView) findViewById(R.id.weight_RM20);
        final TextView RM_view =(TextView) findViewById(R.id.RM_view);
        final EditText edit_kg = (EditText)findViewById(R.id.edit_kg);
        //final Button kg_button = (Button) findViewById(R.id.kg_button);
        // シークバーオブジェクトを取得
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);

        // 初期値
        seekBar.setProgress(1);
        // 最大値
        seekBar.setMax(20);
        // ツマミの設定
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //ツマミがドラッグされると呼ばれる
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        RM_view.setText(String.valueOf(progress) + " 回");

                        // 回数を取得
                        int RMS = seekBar.getProgress();
                        if(edit_kg.length()==0) {
                            Double weight = 0.0;
                            Prod = (int) Math.floor(weight * 0.0333 * (RMS) + weight);
                            MAX_kg_view.setText(Double.toString(Prod));
                            MAX_kg_view.setMaxLines(1);

                            for(int i = 1 ; i<=20 ; i++ ){
                                //weight_RM[i]=MAX_weight*j;
                                //j=j-0.027;
                                if(RMS==i){
                                    weight_RM[i] = (int) Math.floor(weight);
                                }
                                else {
                                    weight_RM[i] = (int) Math.floor(Prod / (0.0333 * i + 1));
                                }
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

                            // 取得したweight_RM8を TextView に張り付ける
                            weight_RM8.setText(Double.toString(weight_RM[8]));
                            weight_RM8.setMaxLines(1);

                            // 取得したweight_RM10を TextView に張り付ける
                            weight_RM10.setText(Double.toString(weight_RM[10]));
                            weight_RM10.setMaxLines(1);

                            // 取得したweight_RM12を TextView に張り付ける
                            weight_RM12.setText(Double.toString(weight_RM[12]));
                            weight_RM12.setMaxLines(1);

                            // 取得したweight_RM15を TextView に張り付ける
                            weight_RM15.setText(Double.toString(weight_RM[15]));
                            weight_RM15.setMaxLines(1);

                            // 取得したweight_RM20を TextView に張り付ける
                            weight_RM20.setText(Double.toString(weight_RM[20]));
                            weight_RM20.setMaxLines(1);
                        }
                        else {
                            // 入力した重量をDouble型に変換
                            Double weight = Double.parseDouble(edit_kg.getText().toString());
                            if (RMS==0){
                                Prod = (int) Math.floor(0.0);
                                MAX_kg_view.setText(Double.toString(Prod));
                                MAX_kg_view.setMaxLines(1);
                            }
                            else if(RMS==1){
                                Prod = (int) Math.floor(weight);
                                MAX_kg_view.setText(Double.toString(Prod));
                                MAX_kg_view.setMaxLines(1);
                            }
                            else {
                                Prod = (int) Math.floor(weight * 0.0333 * (RMS) + weight);
                                MAX_kg_view.setText(Double.toString(Prod));
                                MAX_kg_view.setMaxLines(1);
                            }

                            for(int i = 1 ; i<=20 ; i++ ){
                                if(RMS==i){
                                    weight_RM[i] = (int) Math.floor(weight);
                                }
                                else {
                                    weight_RM[i] = (int) Math.floor(Prod / (0.0333 * i + 1));
                                }
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

                            // 取得したweight_RM8を TextView に張り付ける
                            weight_RM8.setText(Double.toString(weight_RM[8]));
                            weight_RM8.setMaxLines(1);

                            // 取得したweight_RM10を TextView に張り付ける
                            weight_RM10.setText(Double.toString(weight_RM[10]));
                            weight_RM10.setMaxLines(1);

                            // 取得したweight_RM12を TextView に張り付ける
                            weight_RM12.setText(Double.toString(weight_RM[12]));
                            weight_RM12.setMaxLines(1);

                            // 取得したweight_RM15を TextView に張り付ける
                            weight_RM15.setText(Double.toString(weight_RM[15]));
                            weight_RM15.setMaxLines(1);

                            // 取得したweight_RM20を TextView に張り付ける
                            weight_RM20.setText(Double.toString(weight_RM[20]));
                            weight_RM20.setMaxLines(1);

                        }


                    }

                    //ツマミがタッチされた時に呼ばれる
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    //ツマミがリリースされた時に呼ばれる
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }

                });


        //重量を入力せずに，決定ボタンを押すとアプリを強制終了してしまうこと防ぐためTextWatcherを使用
       /* kg_button.setEnabled(false);

                edit_kg.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        //テキスト変更前
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        //テキスト変更中
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        //テキスト変更後
                        if(s.toString().equals("重量を入力")==true) {
                            kg_button.setEnabled(false);
                        }
                        else{
                            kg_button.setEnabled(true);
                        }
                    }
                });*/

        /*入力した重量を表示*/
      /*  kg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 入力した重量をDouble型に変換
                Double weight = Double.parseDouble(edit_kg.getText().toString());
                // spinnerから回数を取得 ただしRM=0のときが1回である
                int RM = spinner.getSelectedItemPosition();
                // 計算式1の場合
                if (RM == 0) {
                    MAX_weight = (int) Math.floor(weight);
                    // 取得したMAX_weightを TextView に張り付ける
                    MAX_kg_view.setText(Double.toString(MAX_weight));
                    MAX_kg_view.setMaxLines(1);
                } else {
                    MAX_weight = (int) Math.floor(weight * 0.0333 * (RM + 1) + weight);
                    // 取得したMAX_weightを TextView に張り付ける
                    MAX_kg_view.setText(Double.toString(MAX_weight));
                    MAX_kg_view.setMaxLines(1);

                }

                for(int i = 1 ; i<=20 ; i++ ){
                    //weight_RM[i]=MAX_weight*j;
                    //j=j-0.027;
                    if(RM==i-1){
                        weight_RM[i] = (int) Math.floor(weight);
                    }
                    else {
                        weight_RM[i] = (int) Math.floor(MAX_weight / (0.0333 * i + 1));
                    }
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

                // 取得したweight_RM8を TextView に張り付ける
                weight_RM8.setText(Double.toString(weight_RM[8]));
                weight_RM8.setMaxLines(1);

                // 取得したweight_RM10を TextView に張り付ける
                weight_RM10.setText(Double.toString(weight_RM[10]));
                weight_RM10.setMaxLines(1);

                // 取得したweight_RM12を TextView に張り付ける
                weight_RM12.setText(Double.toString(weight_RM[12]));
                weight_RM12.setMaxLines(1);

                // 取得したweight_RM15を TextView に張り付ける
                weight_RM15.setText(Double.toString(weight_RM[15]));
                weight_RM15.setMaxLines(1);

                // 取得したweight_RM20を TextView に張り付ける
                weight_RM20.setText(Double.toString(weight_RM[20]));
                weight_RM20.setMaxLines(1);
          }

       });*/

        LinearLayout MAX_1RM_button = (LinearLayout) findViewById(R.id.MAX_1RM_button);
        MAX_1RM_button.setClickable(true);
        MAX_1RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=1;
            }
        });

        LinearLayout MAX_3RM_button = (LinearLayout) findViewById(R.id.MAX_3RM_button);
        MAX_3RM_button.setClickable(true);
        MAX_3RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=3;
            }
        });

        LinearLayout MAX_5RM_button = (LinearLayout) findViewById(R.id.MAX_5RM_button);
        MAX_5RM_button.setClickable(true);
        MAX_5RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=5;
            }
        });


        LinearLayout MAX_7RM_button = (LinearLayout) findViewById(R.id.MAX_7RM_button);
        MAX_7RM_button.setClickable(true);
        MAX_7RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=7;
            }
        });


        LinearLayout MAX_8RM_button = (LinearLayout) findViewById(R.id.MAX_8RM_button);
        MAX_8RM_button.setClickable(true);
        MAX_8RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=8;
            }
        });


        LinearLayout MAX_10RM_button = (LinearLayout) findViewById(R.id.MAX_10RM_button);
        MAX_10RM_button.setClickable(true);
        MAX_10RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=10;
            }
        });


        LinearLayout MAX_12RM_button = (LinearLayout) findViewById(R.id.MAX_12RM_button);
        MAX_12RM_button.setClickable(true);
        MAX_12RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=12;
            }
        });


        LinearLayout MAX_15RM_button = (LinearLayout) findViewById(R.id.MAX_15RM_button);
        MAX_15RM_button.setClickable(true);
        MAX_15RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=15;
            }
        });


        LinearLayout MAX_20RM_button = (LinearLayout) findViewById(R.id.MAX_20RM_button);
        MAX_20RM_button.setClickable(true);
        MAX_20RM_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Custom_Dialog dialog =new Custom_Dialog();
                dialog.show(getFragmentManager(),"tag");
                select=20;
            }
        });
    }

}

