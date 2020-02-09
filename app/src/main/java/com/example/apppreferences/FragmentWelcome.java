package com.example.apppreferences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentWelcome extends Fragment {

    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    public static FragmentWelcome newInstance(String name, String email) {
        FragmentWelcome fragmentWelcome = new FragmentWelcome();

        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        bundle.putString(KEY_EMAIL, email);

        fragmentWelcome.setArguments(bundle);

        return fragmentWelcome;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_success, container, false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            String name = bundle.getString(KEY_NAME);
            String email = bundle.getString(KEY_EMAIL);

            TextView textView = view.findViewById(R.id.textView);
            textView.setText("Welcome, " + name + "! Your email is " + email + ".");
        }


        return view;
    }
}
