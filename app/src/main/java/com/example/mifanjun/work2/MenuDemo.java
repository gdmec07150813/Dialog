package com.example.mifanjun.work2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuDemo extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);
        textView = (TextView) findViewById(R.id.menuTxtview);
        registerForContextMenu(textView);
    }

    @Override
//  创建选项菜单
//     1-- 创建menu对象
//     2-- 为menu创建填充布局文件,获取布局文件资源
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater mi = getMenuInflater();
//        mi.inflate(R.menu.menu,menu);
//        参数:是否分组,项目编号(一个item对应一menu选项),显示顺序,选项中显示的文字
        menu.add(0,1,0,R.string.cd1);
        menu.add(0,1,0,R.string.cd2);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
//    选项菜单被选中
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
//  创建上下文菜单
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,R.string.cd1);
        menu.add(0,1,0,R.string.cd2);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
//    上下文菜单被选中
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
        return super.onContextItemSelected(item);
    }
}
