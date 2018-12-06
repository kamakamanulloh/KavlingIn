package com.putri.skripsi.kavlingin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.putri.skripsi.kavlingin.Activity.DetailActivity;
import com.putri.skripsi.kavlingin.Activity.LoginActivity;
import com.putri.skripsi.kavlingin.Activity.MainActivity;
import com.putri.skripsi.kavlingin.helper.PermissionHelper;

public class SplashActivity extends AppCompatActivity {
    PermissionHelper permissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
         permissionHelper = new PermissionHelper(this);

//        checkAndRequestPermissions();
    }

//    private boolean checkAndRequestPermissions() {
//        permissionHelper.permissionListener(new PermissionHelper.PermissionListener() {
//            @Override
//            public void onPermissionCheckDone() {
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        permissionHelper.checkAndRequestPermissions();
//
//        return true;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        permissionHelper.onRequestCallBack(requestCode, permissions, grantResults);
//    }
}
