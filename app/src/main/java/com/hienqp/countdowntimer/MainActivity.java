package com.hienqp.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBarDOWNLOAD;
    Button buttonDOWNLOAD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarDOWNLOAD = (ProgressBar) findViewById(R.id.progressBar_TAIXUONG);
        buttonDOWNLOAD = (Button) findViewById(R.id.button_TAIXUONG);

        buttonDOWNLOAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 10000 = 10 giây : tổng thời gian CountDown (đếm ngược)
                // 1000 = 1 giây : thời gian lặp lại 1 hành động nào đó trong onTick()
                CountDownTimer countDownTimer = new CountDownTimer(10000, 500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int currentProgress = progressBarDOWNLOAD.getProgress();
                        if (currentProgress >= progressBarDOWNLOAD.getMax()) {
                            currentProgress = 0;
                        }
                        progressBarDOWNLOAD.setProgress(currentProgress + 10);
                    }

                    @Override
                    public void onFinish() {
                        // tiếp tục chạy start() lại chính nó
                        this.start();

//                        Toast.makeText(MainActivity.this, "Hết Giờ", Toast.LENGTH_SHORT).show();
                    }
                    // lưu ý nhớ gọi start()
                }.start();
            }
        });
    }
}