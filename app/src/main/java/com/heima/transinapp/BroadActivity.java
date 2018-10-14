package com.heima.transinapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_broad)
public class BroadActivity extends AppCompatActivity {
    @ViewInject(R.id.et_input)
    EditText et_input;
    @ViewInject(R.id.btn_input)
    Button btn_input;
    @ViewInject(R.id.tv_result)
    TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        registerBroad();
    }

    @Event(value = {R.id.btn_input})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_input:
                setMessage();
                break;
        }
    }

    public class MyStaticBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "ACTION":
                    String message = intent.getStringExtra("ID");
                    tv_result.setText(message);
                    break;
            }
        }
    }

    /**
     * 注册广播接收器
     */
    private void registerBroad() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("ACTION");
        MyStaticBroadcastReceiver myStaticBroadcastReceiver = new MyStaticBroadcastReceiver();
        registerReceiver(myStaticBroadcastReceiver, filter);
    }


    /**
     * 发送消息
     */
    private void setMessage() {
        Intent intent = new Intent();
        intent.setAction("ACTION");
        intent.putExtra("ID", et_input.getText().toString());
        sendBroadcast(intent);
    }

}
