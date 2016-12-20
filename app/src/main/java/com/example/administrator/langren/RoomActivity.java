package com.example.administrator.langren;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RoomActivity extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        String name = getIntent().getStringExtra("name");
        int rmNumber = getIntent().getIntExtra("rmNumber", 0);
        String ip = getIntent().getStringExtra("ip");
        textView = (TextView)findViewById(R.id.textView2);
        textView.setText("Welcome to Room "+ rmNumber);
    }
}
