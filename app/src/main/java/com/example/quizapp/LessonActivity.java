package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonActivity extends AppCompatActivity {

    private Button m_ponens;
    private Button m_tollens;
    private Button hypothetical_s;
    private Button dysjunctive_s;
    private Button addition;
    private Button simplification;
    private Button resolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        m_ponens = (Button) findViewById(R.id.m_ponens);
        m_tollens = (Button) findViewById(R.id.m_tollens);
        hypothetical_s = (Button) findViewById(R.id.hypothetical_s);
        dysjunctive_s = (Button) findViewById(R.id.dysjunctive_s);
        addition = (Button) findViewById(R.id.addition);
        simplification = (Button) findViewById(R.id.simplification);
        resolution = (Button) findViewById(R.id.resolution);

        m_ponens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleActivity();
            }
        });

        m_tollens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleActivity2();
            }
        });

        hypothetical_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleActivity3();
            }
        });

        dysjunctive_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleActivity4();
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleActivity5();
            }
        });

        simplification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleActivity6();
            }
        });

        resolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleActivity7();
            }
        });
    }

    public void openRuleActivity() {
        Intent intent = new Intent(this, RuleActivity.class);
        startActivity(intent);
    }

    public void openRuleActivity2() {
        Intent intent = new Intent(this, RuleActivity2.class);
        startActivity(intent);
    }

    public void openRuleActivity3() {
        Intent intent = new Intent(this, RuleActivity3.class);
        startActivity(intent);
    }

    public void  openRuleActivity4() {
        Intent intent = new Intent(this, RuleActivity4.class);
        startActivity(intent);
    }

    public void openRuleActivity5() {
        Intent intent = new Intent(this, RuleActivity5.class);
        startActivity(intent);
    }

    public void openRuleActivity6() {
        Intent intent = new Intent(this, RuleActivity6.class);
        startActivity(intent);
    }

    public void openRuleActivity7() {
        Intent intent = new Intent(this, RuleActivity7.class);
        startActivity(intent);
    }

}
