package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.ProductLeftAdapter;
import com.example.adapter.ProductRightAdapter;
import com.example.entity.Product;
import com.example.xc.MainActivity;
import com.example.xc.R;


import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

    public static List<List<Product>> list=new ArrayList<>();  //定义存放右边列表所有选项数据的集合
    public static RecyclerView rightrv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.products_fragment,container,false);          //关联布局文件
        initRecyclerView(view);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        MainActivity.initProductBtnColor();
    }

    private void initRecyclerView(View view){
        RecyclerView leftrv=view.findViewById(R.id.leftRecycler);       //获得左边列表控件对象
        //设置为上下结构的LinearLayout布局
        leftrv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //小吃分类名
        String[] classname={"北京小吃","茂名小吃","上海小吃","美式甜点","广州小吃"};
        //调用左边列表适配器类
        ProductLeftAdapter leftAdapter=new ProductLeftAdapter(getActivity(),classname);

        leftrv.setAdapter(leftAdapter);                             //把适配器设置给左边列表控件

        //定义5组小吃图片
        int[] nfimage={R.mipmap.nf1,R.mipmap.nf2,R.mipmap.nf3,R.mipmap.nf4,R.mipmap.nf5,R.mipmap.nf6,
                R.mipmap.nf7,R.mipmap.nf8,R.mipmap.nf9,R.mipmap.nf10,R.mipmap.nf11};
        int[] bfimage={R.mipmap.bf1,R.mipmap.bf2,R.mipmap.bf3,R.mipmap.bf4,R.mipmap.bf5,R.mipmap.bf6,
                R.mipmap.bf7,R.mipmap.bf8,R.mipmap.bf9,R.mipmap.bf10,R.mipmap.bf11};
        int[] ycimage={R.mipmap.yc1,R.mipmap.yc2,R.mipmap.yc3,R.mipmap.yc4,R.mipmap.yc5,R.mipmap.yc6,
                R.mipmap.yc7,R.mipmap.yc8,R.mipmap.yc9,R.mipmap.yc10};
        int[] yzimage={R.mipmap.yz1,R.mipmap.yz2,R.mipmap.yz3,R.mipmap.yz4,R.mipmap.yz5,R.mipmap.yz6,
                R.mipmap.yz7,R.mipmap.yz8,R.mipmap.yz9,R.mipmap.yz10,R.mipmap.yz11,};
        int[] omimage={R.mipmap.om1,R.mipmap.om2,R.mipmap.om3,R.mipmap.om4,R.mipmap.om5,
                R.mipmap.om6,R.mipmap.om7,R.mipmap.om8,R.mipmap.om9,R.mipmap.om10,};
//定义5组小吃名称
        String[] nfname={"脆皮鸭","肉沫豆腐","豌豆黄","驴打滚","点心拼盘","炸什么卷",
                "炸酱面","北京烤鸭","爆肚","红糖糍粑","豆汁"};
        String[] bfname={"茂名捞粉","菜包籺","艾糍粑","簸箕炊","化州牛杂","菜包粿","白切鸡",
                "炸豆干","炸生蚝","炸角","沙堡粉"};
        String[] ycname={"小笼包","芝麻饼","红烧排骨","你猜","生煎包","红豆糍粑",
                "炸豆干干","葱油老面","酱油面筋","干炒鹅卵石"};
        String[] yzname={"三个蛋糕","一坨奶油","甜甜圈","巧克力奶油","布丁草","士力架蛋糕",
                "鸡蛋仔蛋糕","缤纷甜甜圈","冰淇淋雪球","三毛蛋糕","芒果派"};
        String[] omname={"烧卖紫菜双拼","虎皮凤爪","马蹄糕","你条粉肠","叉烧包","药膳鸡",
                "椒盐多春鱼","你相信光吗","干炒牛河","捞仔面"};
        //定义5组小吃价格
        String[] nfprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] bfprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] ycprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5"};
        String[] yzprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] omprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5"};

        //获取南方小吃分类数据，并添加的集合里。
        List<Product>  listright1=getList(nfimage, nfname, nfprice);
        list.add(listright1);
        //获取北方小吃分类数据，并添加的集合里。
        List<Product>  listright2=getList(bfimage, bfname, bfprice);
        list.add(listright2);
        //获取原创小吃分类数据，并添加的集合里。
        List<Product>  listright3=getList(ycimage, ycname, ycprice);
        list.add(listright3);
        //获取亚洲小吃分类数据，并添加的集合里。
        List<Product>  listright4=getList(yzimage, yzname, yzprice);
        list.add(listright4);
        //获取欧美小吃分类数据，并添加的集合里。
        List<Product>  listright5=getList(omimage, omname, omprice);
        list.add(listright5);

        rightrv=view.findViewById(R.id.rightRecycler);               //获得右边列表控件对象
        //设置为上下结构的LinearLayout布局
        rightrv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //调用右边列表适配器类
        ProductRightAdapter rightAdapter=new ProductRightAdapter(getActivity(),listright1);

        rightrv.setAdapter(rightAdapter);                          //把适配器设置给右边列表控件

    }

    /**
     * 本方法用于生成右边列表选项数据集合
     * @param iamges 传入一组小吃图片
     * @param names 传入一组小吃名称
     * @param prices 传入一组小吃价格
     * @return 返回一个分类的所有小吃数据集合
     */
    public List<Product> getList(int[] iamges, String[] names, String[] prices){
        List<Product> listright=new ArrayList<>();                 //存放右边列表所有数据
        Product product;                                      //用于存放一个选项数据
        for(int i=0;i<iamges.length;i++){
            product=new Product();
            product.setImage(iamges[i]);
            product.setName(names[i]);
            product.setPrice(prices[i]);
            listright.add(product);
        }
        return listright;
    }

}
