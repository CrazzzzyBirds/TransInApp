package com.heima.transinapp.TestCallBack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.heima.transinapp.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_test_call_back)
public class TestCallBackActivity extends AppCompatActivity implements CallBack {
    @ViewInject(R.id.btn_start_service)
    Button btn_start_service;
    @ViewInject(R.id.tv_result)
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        //注册监听
        CallBackUtil.setCallBack(this);
    }

    @Event(value = {R.id.btn_start_service})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_service:
                startService(new Intent(TestCallBackActivity.this, SendService.class));
                break;

        }


    }


    /**
     * @param message 接收到的消息
     */
    @Override
    public void transMessage(String message) {

        tv_result.setText(message);

    }
}
