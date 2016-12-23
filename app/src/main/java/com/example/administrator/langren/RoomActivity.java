package com.example.administrator.langren;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class RoomActivity extends Activity {
    private TextView textViewTitle;
    private TextView textViewTotal;
    private SeekBar sb;
    private int num = 0;
    private int lang = 0;
    private int ren = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        textViewTitle = (TextView)findViewById(R.id.textView2);
        textViewTitle.setText("Welcome to LangRen");
        sb = (SeekBar)findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(sbListener);


        textViewTotal = (TextView)findViewById(R.id.textView9);
        textViewTotal.setText("共有" +7+ "名玩家");
    }
    private SeekBar.OnSeekBarChangeListener sbListener = new SeekBar.OnSeekBarChangeListener(){
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            num = progress + 7;
            textViewTotal.setText("共有" +num+ "名玩家");
        }
        @Override
        //开始拖动的时候调用
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        //停止拖动的时候调用
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

}
