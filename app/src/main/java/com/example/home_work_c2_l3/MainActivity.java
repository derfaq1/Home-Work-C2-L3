package com.example.home_work_c2_l3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private static final int COLOR_REQUEST_CODE = 1;
    FrameLayout frame;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.mainFrameLayout);
        button = findViewById(R.id.rgbSelectorActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RgbSelector.class);
                startActivityForResult(intent, COLOR_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode){
            case COLOR_REQUEST_CODE:
                if(resultCode != RESULT_OK){
                    return;
                } else{
                    int colorR = data.getIntExtra("colorR",0);
                    int colorG = data.getIntExtra("colorG",0);
                    int colorB = data.getIntExtra("colorB",0);
                    frame.setBackgroundColor(0xff000000 + colorR * 0x10000 + colorG * 0x100
                            + colorB);
                    button.setText("Сменить еще раз");
                }
        }


    }

}
