package com.example.administrator.langren;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import static android.content.ContentValues.TAG;

public class HallActivity extends Activity {


    private TextView textView;
    private Button createButtom;
    private Button enterButtom;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        String name = getIntent().getStringExtra("name");
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Welcome "+ name +":\nPlease input the room number or create a new room:");

        createButtom = (Button)findViewById(R.id.button4);
        createButtom.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c){
                String name = getIntent().getStringExtra("name");
                String hostIp = getIP();
                Intent intent = new Intent(HallActivity.this, RoomActivity.class);
                int rmNumber = Integer.parseInt(hostIp.substring(hostIp.lastIndexOf('.')+1));
                intent.putExtra("name", name);
                intent.putExtra("rmNumber", rmNumber);
                intent.putExtra("ip", hostIp);
                startActivity(intent);
            }
        });
        editText = (EditText)findViewById(R.id.editText);



        enterButtom = (Button)findViewById(R.id.button5);
        enterButtom.setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                if (!s.toString().equals(""))
                    enterButtom.setEnabled(true);
                else
                    enterButtom.setEnabled(false);
            }
        });

        enterButtom.setOnClickListener(new View.OnClickListener(){
            public void onClick(View c){
                String name = getIntent().getStringExtra("name");
                String hostIp = getIP();
                Intent intent = new Intent(HallActivity.this, RoomActivity.class);

                String reNumberText = editText.getText().toString();
                int rmNumber = Integer.parseInt(reNumberText);
                intent.putExtra("name", name);
                intent.putExtra("rmNumber", rmNumber);
                intent.putExtra("ip", hostIp);
                startActivity(intent);
            }
        });



    }

    String getIP(){
        String hostIp = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();

                        break;
                    }
                }
            }
        } catch (SocketException e) {
            Log.i("yao", "SocketException");
            e.printStackTrace();
        }
        Log.i(TAG, hostIp);
        return hostIp;
    }

}
