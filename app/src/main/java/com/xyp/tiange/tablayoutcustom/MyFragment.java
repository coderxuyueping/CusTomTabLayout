package com.xyp.tiange.tablayoutcustom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyFragment extends Fragment {
    private TextView tv;
    private String str="";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my,container,false);
        tv= (TextView) view.findViewById(R.id.tv);
        tv.setText(str);
        return view;
    }
    public void setText(String str){
        this.str=str;
    }
}
