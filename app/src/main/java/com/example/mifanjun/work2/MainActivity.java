package com.example.mifanjun.work2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private RadioGroup radioGroup;
    private EditText editText1,editText2;
    private Button button;
    Double height,weight,sh;
    String str;
    private RelativeLayout ry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        editText1 = (EditText)findViewById(R.id.editText);
        editText2 =(EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button);
        textView =(TextView)findViewById(R.id.textView3);
        ry =(RelativeLayout) findViewById(R.id.rl);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                height=Double.parseDouble(editText1.getText().toString());
                weight=Double.parseDouble(editText2.getText().toString());
                switch (checkedId){
                    case R.id.radioButton:
                        sh=(height-100)*0.9;
                       if(sh==weight){
                           str="你的是标准体重哦~";
                       }else{
                           str="你的不是标准体重,加油~";
                       }
                        break;
                    case R.id.radioButton2:
                        sh=(height-100)*0.9-2.5;
                        if(sh==weight){
                            str="你的是标准体重哦~";
                        }else{
                            str="你的不是标准体重,加油~";
                        }
                        break;
                      default:
                          break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      ry.setBackgroundResource(R.drawable.slu);
             textView.setText(str);

            }
        });
    }
}
