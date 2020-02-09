package com.example.apppreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentLogin.OnSaveListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewSharedPreferences newSharedPreferences = new NewSharedPreferences(this);

        if (newSharedPreferences.getName() == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentLogin()).commit();
        } else {
            FragmentWelcome fragmentWelcome =  FragmentWelcome.newInstance(newSharedPreferences.getName(), newSharedPreferences.getEmail());

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentWelcome).commit();
        }
    }

    @Override
    public void onSave() {
        NewSharedPreferences newSharedPreferences = new NewSharedPreferences(this);

        FragmentWelcome fragmentWelcome =  FragmentWelcome.newInstance(newSharedPreferences.getName(), newSharedPreferences.getEmail());

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragmentWelcome).commit();


    }
}
