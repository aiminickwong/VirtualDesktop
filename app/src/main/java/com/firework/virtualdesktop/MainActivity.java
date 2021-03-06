package com.firework.virtualdesktop;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView ipText;
    private TextView portText;
    private TextView passwordText;
    private TextView resultView;
    private Button settingBtn;
    private Button connectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the data from the client textview
        ipText = (TextView)findViewById(R.id.ipText);
        portText = (TextView)findViewById(R.id.VMPortText);
        passwordText = (TextView)findViewById(R.id.passwordText);
        resultView = (TextView)findViewById(R.id.resultView);
        resultView.setTextColor(Color.RED);
        settingBtn = (Button)findViewById(R.id.SettingBtn);
        connectBtn = (Button)findViewById(R.id.ConnectBtn);

        //btn click listener
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip = ipText.getText().toString();
                String port = portText.getText().toString();
                String password = passwordText.getText().toString();

                if(StartSpice(ip, port, password)) {
                    toCanvas();
                }
            }
        });
    }

    private boolean StartSpice(String ip, String port, String password) {

    }

    private void toCanvas() {
        Intent intent = new Intent(this, SpiceCanvasActivity.class);
        startActivity(intent);
    }
}
