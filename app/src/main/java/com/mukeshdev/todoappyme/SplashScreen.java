package com.mukeshdev.todoappyme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {
    Dialog dialogTrasparent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        showProgress();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                    dismissProgress();
                    finish();
                }catch (Exception e) {

                }
            }
        };

        thread.start();
    }

    private void showProgress(){

        dialogTrasparent = new Dialog(this,android.R.style.Theme_Black);
        View view = LayoutInflater.from(this).inflate(R.layout.custom_progress,null);
        dialogTrasparent.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogTrasparent.getWindow().setBackgroundDrawableResource(R.color.Trans);
        dialogTrasparent.setContentView(view);
        dialogTrasparent.show();
    }

    private void dismissProgress(){
        dialogTrasparent.dismiss();
    }
}