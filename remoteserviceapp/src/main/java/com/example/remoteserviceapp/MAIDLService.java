package com.example.remoteserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MAIDLService extends Service {

    private void Log(String str) {
        Log.e("123", "----------" + str + "----------");
    }
    public void onCreate() {
        Log("service created");
    }
    public void onStart(Intent intent, int startId) {
        Log("service started id = " + startId);
    }
    public IBinder onBind(Intent t) {
        Log("service on bind");
        return mBinder;
    }
    public void onDestroy() {
        Log("service on destroy");
        super.onDestroy();
    }
    public boolean onUnbind(Intent intent) {
        Log("service on unbind");
        return super.onUnbind(intent);
    }
    public void onRebind(Intent intent) {
        Log("service on rebind");
        super.onRebind(intent);
    }
    PayAidlInterface.Stub mBinder = new PayAidlInterface.Stub() {
        @Override
        public int calculation(int anInt, int bnInt) throws RemoteException {
            Log(anInt + "--" + bnInt);
            return 1;
        }
    };
}
