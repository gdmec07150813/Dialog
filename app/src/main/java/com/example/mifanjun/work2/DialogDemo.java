package com.example.mifanjun.work2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DialogDemo extends AppCompatActivity {
    private TextView tv;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);

        Button bt1 = (Button)findViewById(R.id.bt1);
        Button bt2 = (Button)findViewById(R.id.bt2);
        Button bt3 = (Button)findViewById(R.id.bt3);
        Button bt4 = (Button)findViewById(R.id.bt4);
        Button bt5 = (Button)findViewById(R.id.bt5);
        Button bt6 = (Button)findViewById(R.id.bt6);
        Button bt7 = (Button)findViewById(R.id.bt7);
        tv = (TextView) this.findViewById(R.id.tv1);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt1:
                        dialog1();
                        break;
                    case R.id.bt2:
                        dialog2();
                        break;
                    case R.id.bt3:
                        dialog3();
                        break;
                    case R.id.bt4:
                        dialog4();
                        break;
                    case R.id.bt5:
                        dialog5();
                        break;
                    case R.id.bt6:
                        dialog6();
                        break;
                    case R.id.bt7:
                        dialog7();
                        break;
                }
            }
        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);
        bt7.setOnClickListener(listener);
    }
    public void dialog1(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    DialogDemo.this.finish();
                }else if(which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }

        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog2(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog,int which) {
                String str = "";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "不忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "一般";
                        break;
                }
                tv.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener);
        dialog.show();

    }
    public void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        final EditText eText = new EditText(this);
        dialog.setView(eText);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("输入的是:"+eText.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog4(){
        final String [] str = new String[]{"北京","上海","广州"};
        final boolean[] blean = new boolean[str.length];
        DialogInterface.OnMultiChoiceClickListener mchoic = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                blean[which]=isChecked;
            }
        };
        builder =  new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(str,null,mchoic);
        dialog = builder.create();
        dialog.setTitle("复选框");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str1 = "你选择的是:　";
                for(int i=0;i<str.length;i++){
                    if(blean[i]){
                        str1 = str1+"\n"+str[i];
                    }
                }
                tv.setText(str1);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    int index=0;
    public void dialog5(){
        final String [] str = new String[]{"北京","上海","广州"};
        final boolean[] blean = new boolean[str.length];
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                blean[which] = true;
                index =which;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(str,-1,listener);
        dialog = builder.create();
        dialog.setTitle("单选");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str1 = " ";
                    if(blean[index]){
                        str1 = "你选择的是:\n"+str[index];
                        tv.setText(str1);
                    }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }
    public void dialog6(){
        final String [] str = new String[]{"北京","上海","广州"};
        final boolean[] blean = new boolean[str.length];
        DialogInterface.OnClickListener lis = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str1 = "你选择的是: "+str[which];
                tv.setText(str1);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(str,lis);
        dialog = builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"取消",listener);
        dialog.show();
    }
    public void dialog7(){
//        1-- 创建布局文件填充器
//        2-- 实例化并填充布局文件
//        3-- 在布局文件中填充控件
//        4-- 添加
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.divl,null);
        final EditText tEdit = (EditText) layout.findViewById(R.id.edt);
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listerner = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                tv.setText("输入的是: "+tEdit.getText().toString());
                }else if(which == DialogInterface.BUTTON_NEUTRAL){

                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listerner);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",listerner);
        dialog.show();
    }
}
