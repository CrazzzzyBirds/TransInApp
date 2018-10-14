package com.heima.transinapp.TestCallBack;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SendService extends Service {
    public SendService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        CallBackUtil.doCallBack("1");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
