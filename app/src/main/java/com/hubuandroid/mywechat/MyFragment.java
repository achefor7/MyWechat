package com.hubuandroid.mywechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;

import android.widget.Toast;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Random;

/*
*
 * A simple {@link Fragment} subclass.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
*/
public class MyFragment extends Fragment {

/*    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;*/

    private RecyclerView recyclerView; //定义ReclerView控件
    private View view;//定义view来设置fragment中的layout
    private ArrayList<GoodsEntity> goodsEntities = new ArrayList<GoodsEntity>();
    private myadpater myadpater;


    public MyFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    /*public static MyFragment newInstance(String param1, String param2) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.tab04, container, false);
        view = inflater.inflate(R.layout.tab01,container,false);
        initRecyclerView();
        initData();
        return view;
    }


    @SuppressLint("WrongConstant")
    private void initRecyclerView() {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        myadpater = new myadpater(getActivity(),goodsEntities);
        recyclerView.setAdapter(myadpater);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        myadpater.setOnItemClickListener(new myadpater.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, GoodsEntity data) {
                Toast.makeText(getActivity(),"有货", Toast.LENGTH_SHORT).show();
            }
	        });
}

    //
	    private void initData(){
            for (int i=0;i<20;i++){
                Random r = new Random();
                GoodsEntity goodsEntity = new GoodsEntity();
                goodsEntity.setGoodsName("product"+i);
                goodsEntity.setGoodsPrice(String.valueOf(r.nextInt(100)));
                goodsEntities.add(goodsEntity);
             }
         }
}