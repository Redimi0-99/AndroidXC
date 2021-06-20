package com.example.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.adapter.NewAdapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.xc.MainActivity;
import com.example.xc.R;

import androidx.fragment.app.Fragment;
public class NewFragment extends  Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.new_fragment,container,false);          //关联布局文件
        initRecyclerView(view);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        MainActivity.initHomeBtnColor();
    }
    private void initRecyclerView(View view){
        RecyclerView  rv=view.findViewById(R.id.newRecycler);       //获得RecyclerView控件对象                                                                              														   //设置为StaggeredGridLayout流式布局
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));                                                                              														   //定义新品小吃图片数组
        int[] image={R.mipmap.bf11,R.mipmap.bf3,R.mipmap.om1,R.mipmap.om7,R.mipmap.yc1,
                R.mipmap.nf10,R.mipmap.nf8};                                                                              														   //定义新品小吃说明数组
        String[] text={"沙煲粉","艾糍粑","烧卖糯米鸡双拼","多春鱼",
                "时尚甜品","芝麻红糖包","北京烤鸭"};

        NewAdapter adapter=new NewAdapter(getActivity(),image,text); //调用适配器

        rv.setAdapter(adapter);                             //设置适配器到RecyclerView

    }

}
