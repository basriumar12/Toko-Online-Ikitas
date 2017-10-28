package id.co.blogbasbas.tokoonlineikitas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah splashscreen berjalan akan di intent ke activity utama
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },3000);//waktu tunggu
    }
    }

