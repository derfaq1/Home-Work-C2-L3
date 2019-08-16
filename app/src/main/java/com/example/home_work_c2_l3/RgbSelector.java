package com.example.home_work_c2_l3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class RgbSelector extends AppCompatActivity {
    SeekBar seekBarR;
    SeekBar seekBarG;
    SeekBar seekBarB;
    TextView textViewR;
    TextView textViewG;
    TextView textViewB;
    LinearLayout previewBg;
    String seekBarValueR;
    String seekBarValueG;
    String seekBarValueB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgb_selector);

         seekBarR = findViewById(R.id.seekBarR);
         seekBarG = findViewById(R.id.seekBarG);
         seekBarB = findViewById(R.id.seekBarB);
         textViewR = findViewById(R.id.textViewR);
         textViewG = findViewById(R.id.textViewG);
         textViewB = findViewById(R.id.textViewB);
         previewBg = findViewById(R.id.previewBg);


         previewBg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent mainActivity = new Intent();
                 mainActivity.putExtra("colorR", seekBarR.getProgress());
                 mainActivity.putExtra("colorG", seekBarG.getProgress());
                 mainActivity.putExtra("colorB", seekBarB.getProgress());
                 setResult(RESULT_OK, mainActivity);
                 finish();

             }
         });



        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValueR = String.valueOf(seekBarR.getProgress());
                textViewR.setText("Значение R: "+seekBarValueR);
                setPreviewBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValueG = String.valueOf(seekBarG.getProgress());
                textViewG.setText("Значение G: "+seekBarValueG);
                setPreviewBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValueB = String.valueOf(seekBarB.getProgress());
                textViewB.setText("Значение B: "+seekBarValueB);
                setPreviewBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }




    private void setPreviewBackground() {
        int redValue, greenValue, blueValue;
        redValue = seekBarR.getProgress();
        greenValue = seekBarG.getProgress();
        blueValue = seekBarB.getProgress();
        previewBg.setBackgroundColor(0xff000000 + redValue * 0x10000 + greenValue * 0x100
                + blueValue);
    }


}
