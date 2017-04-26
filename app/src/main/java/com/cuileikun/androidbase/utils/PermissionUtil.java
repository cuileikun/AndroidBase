package com.cuileikun.androidbase.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.qk.applibrary.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TangHao on 2016/12/30.
 */
public class PermissionUtil {

    public static boolean requestPermissions(Activity activity, String[] permissions) {
        return requestPermissions(activity, permissions, null, 0);
    }

    public static boolean requestPermissions(Activity activity, String[] permissions, String requestPermissionRationale) {
        return requestPermissions(activity, permissions, requestPermissionRationale, 0);
    }

    /**
     * @param activity
     * @param permissions
     * @param requestPermissionRationale
     * @param requestCode
     * @return true 表示成功进入ActivityCompat.requestPermissions()方法
     */
    public static boolean requestPermissions(Activity activity, String[] permissions, String requestPermissionRationale, int requestCode) {
        //android 6.0引入权限管理功能，当前手机版本为android6.0及以上，请求写入权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < permissions.length; i++) {
                int permissionStatus = ContextCompat.checkSelfPermission(activity, permissions[i]);
                if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                    boolean isShowRationale = ActivityCompat.shouldShowRequestPermissionRationale(activity, permissions[i]);
                    if (isShowRationale && requestPermissionRationale != null)
                        CommonUtil.sendToast(activity, requestPermissionRationale);
//                        Snackbar.make(new View(activity), requestPermissionRationale, Snackbar.LENGTH_SHORT)
//                                .show();
                    list.add(permissions[i]);
                }
            }
            if (!list.isEmpty()) {
                ActivityCompat.requestPermissions(activity, list.toArray(new String[]{}), requestCode);
                return true;
            }
        }

        return false;
    }
}
