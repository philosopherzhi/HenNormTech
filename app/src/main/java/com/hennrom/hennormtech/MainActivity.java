package com.hennrom.hennormtech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.hennrom.hennormtech.Fragment.BookFragment;
import com.hennrom.hennormtech.Fragment.MainFragment;
import com.hennrom.hennormtech.Fragment.StudentFragment;
import com.hennrom.hennormtech.Fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected LinearLayout menuBook;
    protected LinearLayout menuStudent;
    protected LinearLayout menuUser;
    protected LinearLayout menuMain;
    protected MainFragment mainFragment=new MainFragment();//PPT
    protected BookFragment bookFragment=new BookFragment();//Book
    protected StudentFragment studentFragment=new StudentFragment();//Student
    protected UserFragment userFragment=new UserFragment();//User
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        //获取管理类
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_content,mainFragment)
                .add(R.id.container_content,bookFragment).hide(bookFragment)
                .add(R.id.container_content,studentFragment).hide(studentFragment)
                .add(R.id.container_content,userFragment).hide(userFragment)
        .commit();
    }


    /**
     * 初始化视图
     */
    public void initView(){
        menuBook=this.findViewById(R.id.menu_book);
        menuMain=this.findViewById(R.id.menu_PPT);
        menuStudent=this.findViewById(R.id.menu_student);
        menuUser=this.findViewById(R.id.menu_user);
        //注册监听器
        menuBook.setOnClickListener(this);
        menuMain.setOnClickListener(this);
        menuStudent.setOnClickListener(this);
        menuUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_book:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .show(bookFragment)
                        .hide(studentFragment)
                        .hide(userFragment)
                        .commit();
                break;
            case R.id.menu_PPT:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mainFragment)
                        .hide(bookFragment)
                        .hide(studentFragment)
                        .hide(userFragment)
                        .commit();
                break;
            case R.id.menu_student:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .hide(bookFragment)
                        .show(studentFragment)
                        .hide(userFragment)
                        .commit();
                break;
            case R.id.menu_user:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .hide(bookFragment)
                        .hide(studentFragment)
                        .show(userFragment)
                        .commit();
                break;
        }
    }
}
