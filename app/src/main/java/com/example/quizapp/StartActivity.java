package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StartActivity extends AppCompatActivity {

    private Button button;
    private Button abawt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        button = (Button) findViewById(R.id.button);
        abawt = (Button) findViewById(R.id.abawt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLessonActivity();
            }
        });
        abawt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutActivity();
            }
        });
    }

    public void openLessonActivity() {
        Intent intent = new Intent(this, LessonActivity.class);
        startActivity(intent);
    }

    public void startQuiz(View view) {

        int quizCategory = 0;   // All

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("QUIZ_CATEGORY", quizCategory);
        startActivity(intent);

    }

    public void openAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
