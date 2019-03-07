package com.e.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext=findViewById(R.id.edittext);
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("com.e.myapplication",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",edittext.getText().toString().trim());
        editor.putBoolean("bool",true);
        editor.apply();
    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("com.e.myapplication",MODE_PRIVATE);
        String s1=sharedPreferences.getString("name","user");
        Boolean remember = sharedPreferences.getBoolean("bool",false);
        Toast.makeText(this, "bool:" + remember, Toast.LENGTH_SHORT).show();
        edittext.setText(s1);
    }
}