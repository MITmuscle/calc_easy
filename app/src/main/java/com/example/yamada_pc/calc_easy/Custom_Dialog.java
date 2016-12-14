package com.example.yamada_pc.calc_easy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by akasaka0107 on 2016/12/14.
 */

public class Custom_Dialog extends DialogFragment {
    @Overridegit
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        // タイトル非表示
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        // フルスクリーン
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(R.layout.dialog_custom);
        // MainActivityからMAX_weightとweight_RM[]を取得し選択された重量を TextView に張り付ける
        final TextView setselect_view = (TextView) dialog.findViewById(R.id.setselect_view);
        int MAX_weight = MainActivity.MAX_weight;
        int weight_RM[] = MainActivity.weight_RM;
        int select = MainActivity.select;
        for(int i=1 ; i<=21 ; i++){
            if(select==1){
                setselect_view.setText(Double.toString(MAX_weight));
                setselect_view.setMaxLines(1);
            }
            else if(select==i && select!=1 ){
                setselect_view.setText(Double.toString(weight_RM[i]));
                setselect_view.setMaxLines(1);
            }
        }

        // OK ボタンのリスナ
        dialog.findViewById(R.id.positive_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*// Spinnerオブジェクトを取得
                Spinner spinner = (Spinner)findViewById(R.id.setspinner);
                // spinnerからセット数を取得 ただしset=0のときが1セットである
                int set = spinner.getSelectedItemPosition();*/
                //sub画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.example.yamada_pc.calc_easy","com.example.yamada_pc.calc_easy.SubActivity");
                startActivity(intent);
            }
        });
        // Cancel ボタンのリスナ
        dialog.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return dialog;
    }

}
