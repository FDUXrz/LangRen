package com.example.administrator.langren;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class RoomActivity extends Activity {
    private TextView textViewTitle;
    private TextView textViewTotal;
    private CheckBox mCheckBox;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private CheckBox mCheckBox4;
    private EditText mEditText5;
    private EditText mEditText6;
    private int num = 0;
    private int lang = 0;
    private int ren = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        textViewTitle = (TextView)findViewById(R.id.textView2);
        textViewTitle.setText("Welcome to LangRen");

        mCheckBox = (CheckBox)findViewById(R.id.checkBox);
        mCheckBox2 = (CheckBox)findViewById(R.id.checkBox2);
        mCheckBox3 = (CheckBox)findViewById(R.id.checkBox3);
        mCheckBox4 = (CheckBox)findViewById(R.id.checkBox4);
        mEditText5 = (EditText)findViewById(R.id.editText5);
        mEditText6 = (EditText)findViewById(R.id.editText6);
        mCheckBox.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mCheckBox2.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mCheckBox3.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mCheckBox4.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mEditText5.addTextChangedListener(mTextWatcher);
        mEditText6.addTextChangedListener(mTextWatcher);
        num = (mCheckBox.isChecked()?1:0) + (mCheckBox2.isChecked()?1:0) + (mCheckBox3.isChecked()?1:0) + (mCheckBox4.isChecked()?1:0);

        textViewTotal = (TextView)findViewById(R.id.textView9);
        textViewTotal.setText("共有" +num+ "名玩家");
    }
    private TextWatcher mTextWatcher = new TextWatcher() {

        private int temp;
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if(s.toString().equals("")){
                temp = 0;
            }
            else{
                temp = Integer.parseInt(s.toString());
            }
            num-=temp;
        }
        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().equals("")){
                temp = 0;
            }
            else{
                temp = Integer.parseInt(s.toString());
            }
            num+=temp;
            textViewTotal.setText("共有" +num+ "名玩家");
        }
    };

    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // TODO Auto-generated method stub
            if(isChecked){
                num++;
            }else{
                num--;
            }
            textViewTotal.setText("共有" +num+ "名玩家");
        }
    };

}
