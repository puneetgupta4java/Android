package com.example.puneetgupta.quiz;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Third extends AppCompatActivity {
    TextView t;
    Button b3,b4;
    TextToSpeech ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b4 =  (Button)findViewById(R.id.button4);
        b3 = (Button)findViewById(R.id.button3);
        t = (TextView)findViewById(R.id.textView3);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setSpeechRate(0.5f);
                ts.setLanguage(Locale.ENGLISH);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("score is "+MainActivity.score);
                String s = Integer.toString(MainActivity.score);
                ts.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(Third.this,MainActivity.class);
                startActivity(i4);
                finish();
            }
        });
    }
}
