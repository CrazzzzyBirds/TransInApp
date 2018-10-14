package com.heima.transinapp;

import android.content.SharedPreferences;
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

@ContentView(R.layout.activity_share_pre)
public class SharePreActivity extends AppCompatActivity {
    @ViewInject(R.id.et_input)
    EditText et_input;
    @ViewInject(R.id.btn_input)
    Button btn_input;
    @ViewInject(R.id.btn_get)
    Button btn_get;
    @ViewInject(R.id.tv_result)
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = {R.id.btn_get, R.id.btn_input})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_input:
                setMessage();
                break;
            case R.id.btn_get:
                getMessage();
                break;
        }
    }


    /**
     * 保存信息
     */
    private void setMessage() {
        SharedPreferences sp = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("id", et_input.getText().toString());
        editor.commit();
    }

    /**
     * 获取信息
     */
    private void getMessage() {
        SharedPreferences sp = this.getPreferences(MODE_PRIVATE);
        String id = sp.getString("id", "error");
        tv_result.setText(id);
    }

}
