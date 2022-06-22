package com.hskdeveloper.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    TextToSpeech tts;
    EditText answer;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = findViewById(R.id.answer);
        submit = findViewById(R.id.submit);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            tts= new TextToSpeech(MainActivity.this, status -> {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setSpeechRate(0.8f);
                    tts.speak("whats 2 multiply by 2?", TextToSpeech.QUEUE_ADD, null);}

            }); //speak after 1000ms
        }, 0);
        submit.setOnClickListener(v -> {
            String getAnswer = answer.getText().toString();
            int finalAnswer = Integer.parseInt(getAnswer);


            if (finalAnswer==4){
                tts= new TextToSpeech(MainActivity.this, status -> {
                    if (status == TextToSpeech.SUCCESS) {
                        tts.setSpeechRate(0.8f);
                        tts.speak("Correct", TextToSpeech.QUEUE_ADD, null);}

                });

            }
            else {
                tts= new TextToSpeech(MainActivity.this, status -> {
                    if (status == TextToSpeech.SUCCESS) {
                        tts.setSpeechRate(0.8f);
                        tts.speak("incorrect", TextToSpeech.QUEUE_ADD, null);}

                });

            }

        });
    }

    public void readText(View view) {
        String getTag = view.getTag().toString();
        tts= new TextToSpeech(MainActivity.this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setSpeechRate(0.8f);
                tts.speak(getTag, TextToSpeech.QUEUE_ADD, null);}

        });
    }
}