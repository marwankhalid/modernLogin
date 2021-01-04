package com.example.modernlogin.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.modernlogin.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = connectViews(inflater,container);

        return view;
    }
    private View connectViews(LayoutInflater inflater,ViewGroup container){
        View view = inflater.inflate(R.layout.homefragment,container,false);
        return view;
    }
}
