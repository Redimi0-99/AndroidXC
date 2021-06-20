package com.example.adapter;
    /*
    导包*/
import  android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.ProductsFragment;
import com.example.xc.R;

import android.view.LayoutInflater;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class ProductLeftAdapter extends RecyclerView.Adapter<ProductLeftAdapter.ViewHolder> {

    private FragmentActivity activity;
    private String[] text;
    private List<ViewHolder> items= new ArrayList<>();
    /*
    * @param activity 传入Activity对象
    * @param text 传入小吃分类
    * */
    public ProductLeftAdapter( FragmentActivity activity,String[] text){
        this.activity=activity;
        this.text=text;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.productleft_item,parent,false);
        ViewHolder holder=new ViewHolder(view);                 //调用内部类ViewHolder
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        items.add(holder);                                   //添加选项对象到集合
        holder.tv.setText(text[position]);                        //设置选项小吃分类名
        //设置默认时的选项颜色
        if(position==0){                                     //默认选中的选项颜色
            holder.tv.setTextColor(Color.rgb(84,136,142));
            holder.tv.setBackgroundColor(Color.rgb(223,247,250));
        }else {                                             //默认没有选中的选项颜色
            holder.tv.setTextColor(Color.rgb(148,148,148));
            holder.tv.setBackgroundColor(Color.rgb(252,253,253));
        }
        //点击选项时的操作
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //没有被点击的选项颜色
                for (int i=0;i<items.size();i++){
                    items.get(i).tv.setTextColor(Color.rgb(148,148,148));
                    items.get(i).tv.setBackgroundColor(Color.rgb(252,253,253));
                }
                //被点击的选项颜色
                holder.tv.setTextColor(Color.rgb(84,136,142));
                holder.tv.setBackgroundColor(Color.rgb(223,247,250));
                ProductsFragment.rightrv.setAdapter(new ProductRightAdapter(activity,ProductsFragment.list.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tv=itemView.findViewById(R.id.leftText);
        }
    }
}
