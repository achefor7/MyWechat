package com.hubuandroid.mywechat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class myadpater extends RecyclerView.Adapter<myadpater.myViewHolder> {

    private OnItemClickListener onItemClickListener;
    private Context context;
    private ArrayList<GoodsEntity> goodsEntities;

    public myadpater(Context context, ArrayList<GoodsEntity> goodsEntities){
        this.context = context;
        this.goodsEntities = goodsEntities;
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.item,null);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        GoodsEntity data = goodsEntities.get(position);
        holder.mItemGoodsName.setText(data.goodsName);
        holder.mItemGoodsPrice.setText(data.goodsPrice);

    }

    @Override
    public int getItemCount() {
        return goodsEntities.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        //定义控件
        private ImageView mItemGoodsImg;
        private TextView mItemGoodsName;
        private TextView mItemGoodsPrice;
        private TextView mItemGoodsNameTitle;
        private TextView mItemGoodsPriceTitle;

        public myViewHolder( View itemView) {
            super(itemView);
            //找到控件
            mItemGoodsImg = itemView.findViewById(R.id.item_goods_img);
            mItemGoodsName = itemView.findViewById(R.id.item_goods_name);
            mItemGoodsPrice = itemView.findViewById(R.id.item_goods_price);


            //设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onItemClickListener!=null){

                        onItemClickListener.OnItemClick(v,goodsEntities.get(getLayoutPosition()));
                    }
                }
            });

        }
    }

    //设置点击事件监听器
    public interface OnItemClickListener {
        public void OnItemClick(View view, GoodsEntity data);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
