package com.heima.transinapp.TestCallBack;

public class CallBackUtil {

    private static CallBack mCallBack;

    public static CallBack getmCallBack() {
        return mCallBack;
    }

    /**
     * 注册回调接口
     * @param callBack 一个继承回调接口的对象
     */
    public static void setCallBack(CallBack callBack) {
        mCallBack = callBack;
    }

    /**
     * @param message 传递的信息
     */
    public static void doCallBack(String message){
        mCallBack.transMessage(message);
    }
}
