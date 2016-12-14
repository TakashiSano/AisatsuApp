package jp.teachacademy.takashi.sano.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    int hourOfDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View V) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    String string = new String(hourOfDay + ":" + minute);
                    mTextView.setText(string);
                    if(2<=hourOfDay && hourOfDay<10){
                        mTextView.setText("おはよう");
                    } else if (10<=hourOfDay && hourOfDay<18){
                        mTextView.setText("こんにちは");
                    } else if (18<=hourOfDay && hourOfDay<24){
                        mTextView.setText("こんばんわ");
                    } else if (0<=hourOfDay && hourOfDay<=1){
                        mTextView.setText("こんばんわ");
                    }
                }
            },
            13,
            0,
            true);
        timePickerDialog.show();
    }
}