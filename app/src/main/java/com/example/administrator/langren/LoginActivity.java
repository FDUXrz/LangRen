package com.example.administrator.langren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class LoginActivity extends Activity {
    private Button confirmButtom;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        confirmButtom = (Button)findViewById(R.id.button3);
        confirmButtom.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c){
                editText = (EditText)findViewById(R.id.editText3);
                String name = editText.getText().toString();
                Intent intent = new Intent(LoginActivity.this, HallActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
}
