package com.example.modernlogin.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.modernlogin.Home.HomeActivity;
import com.example.modernlogin.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginTabFragment extends Fragment {

    private Button login;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = connectViews(inflater,container);

        tapOnLoginBtn();

        return root;
    }

    private ViewGroup connectViews(LayoutInflater inflater,ViewGroup container){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);
        login = root.findViewById(R.id.loginBtn);
        return root;
    }

    private void tapOnLoginBtn(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
            }
        });
    }

}
