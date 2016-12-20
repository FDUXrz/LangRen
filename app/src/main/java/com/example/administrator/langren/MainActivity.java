package com.example.administrator.langren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button startButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById((R.id.button));
        exitButton = (Button)findViewById((R.id.button2));

        startButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c){
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c){
                finish();
            }
        });
    }
}
