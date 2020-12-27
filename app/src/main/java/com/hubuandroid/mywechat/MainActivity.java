package com.hubuandroid.mywechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

//import android.support.v4.app.FragmentManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mTabchat;
    private LinearLayout mTabshopping;
    private LinearLayout mTabcollections;
    private LinearLayout mTabmy;

    private ImageButton mImagechat;
    private ImageButton mImageshopping;
    private ImageButton mImagecollections;
    private ImageButton mImagemy;

    private Fragment mTab01 = new ChatFragment();
    private Fragment mTab02 = new ShoppingFragment();
    private Fragment mTab03 = new CollectionsFragment();
    private Fragment mTab04 = new MyFragment();


    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉界面title
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();
        selectFragment(0);
    }

    private void initFragment(){
    //fragmentManager = getFragmentManager();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content,mTab01);
        transaction.add(R.id.content,mTab02);
        transaction.add(R.id.content,mTab03);
        transaction.add(R.id.content,mTab04);
        transaction.commit();
    }


    private void initView(){
        mTabchat = (LinearLayout) findViewById(R.id.id_tab_chat);
        mTabshopping = (LinearLayout) findViewById(R.id.id_tab_shopping);
        mTabcollections = (LinearLayout) findViewById(R.id.id_tab_collections);
        mTabmy = (LinearLayout) findViewById(R.id.id_tab_my);

        mImagechat = (ImageButton) findViewById(R.id.id_tab_chat_img);
        mImageshopping = (ImageButton) findViewById(R.id.id_tab_shopping_img);
        mImagecollections = (ImageButton) findViewById(R.id.id_tab_collections_img);
        mImagemy = (ImageButton) findViewById(R.id.id_tab_my_img);
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    private void selectFragment(int i){//i是一个选择器，用于选择显示哪个界面
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);//首先隐藏所有页面

        switch (i){
            case 0:
                transaction.show(mTab01);
                mImagechat.setImageResource(R.drawable.tab_chat_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImageshopping.setImageResource(R.drawable.tab_shopping_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImagecollections.setImageResource(R.drawable.tab_collections_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImagemy.setImageResource(R.drawable.tab_my_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        //Log.d("onClick","1");
        resetImg();
        switch (view.getId()){
            case R.id.id_tab_chat:
                selectFragment(0);
                break;
            case R.id.id_tab_shopping:
                selectFragment(1);
                break;
            case R.id.id_tab_collections:
                selectFragment(2);
                break;
            case R.id.id_tab_my:
                selectFragment(3);
                break;
            default:
                break;
        }
    }

    @SuppressLint("ResourceAsColor")
    private void resetImg(){
        mImagechat.setImageResource(R.drawable.tab_chat_normal);
        mImageshopping.setImageResource(R.drawable.tab_shopping_normal);
        mImagecollections.setImageResource(R.drawable.tab_collections_normal);
        mImagemy.setImageResource(R.drawable.tab_my_normal);
    }
    //仅仅对bottom的四个linerlayout监听
    private void initEvent(){
        mTabchat.setOnClickListener(this);
        mTabshopping.setOnClickListener(this);
        mTabcollections.setOnClickListener(this);
        mTabmy.setOnClickListener(this);    }
}
