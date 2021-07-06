package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Question", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"x, x → y   What is the conclusion?",     "y", "x", "z", "~y"},
            {"If I feel good, then I will study. I will study.",     "Modus Ponens", "Addition", "Modus Tollens", "Resolution"},
            {"If I feel good, then I will study. I will not study.",     "Modus Tollens", "Modus Ponens", "Hypothetical Syllogism", "Disjunctive Syllogism"},
            {"¬q, p → q   What is the conclusion?",     "~p", "p", "q", "~q"},
            {"If we had faster than light travel, we would travel to other star systems. If we could travel to other star systems, we would meet aliens. Therefore, if we had faster than light travel, we would meet aliens.",     "Hypothetical Syllogism", "Modus Ponens", "Modus Tollens", "Disjunctive Syllogism"},
            {"r → s, s → t   What is the conclusion?",     "r -> t", "t", "t -> u", "~r -> ~t"},
            {"The accused is either innocent, or he is lying. He is not lying. Therefore, he is innocent.",     "Disjunctive Syllogism", "Hypothetical Syllogism", "Modus Ponens", "Modus Tollens"},
            {"I will study Discrete Structures or I will study Number Theory. I will not study Number Theory. Therefore,: ",     "I will not study Number thoery", "I will study Number Theory", "I will study Data Structures", "I will not study Data Structures"},
            {"At the state park, you can get free admission if you are a student or a senior. You are a student. Therefore, you satisfy the condition of being a student or a senior.",     "Addition", "Simplification", "Resolution", "Hypothetical Syllogism"},
            {"p   What is the conclusion?",     "p v q", "~p", "q", "~q"},
            {"You applied for a scholarship. You mention on your resume that you have good grades. and a collection of baseball cards. The selection committee makes a note that you good grades.",     "Simplification", "Hypothetical Syllogism", "Disjunctive Syllogism", "Addition"},
            {"q v r   What is the conclusion?",     "q", "r", "r v q", "r ^ s"},
            {"If it is rainy, the pool will be closed. It is rainy. Therefore, the pool is closed.",    "Modus Ponens", "Modus Tollens", "Hypothetical Syllogism", "Disjunctive Syllogism"},
            {"It is cloudy and drizzling now. Therefore, it is cloudy now.",    "Simplification", "Addition", "Resolution", "Conjunction"},
            {"(p ^ q) v r, r → s   What is the conclusion?",    "p v s", "p v r", "q v s", "q v r"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        // Receive quizCategory from StartActivity.
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);

        Log.v("CATEGORY_TAG", quizCategory + "");

        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            // Add tmpArray to quizArray,
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        // Update quizCountLabel.
        countLabel.setText("#" + quizCount);

        // Generate random number between 0 and 14 (quizArray's size - 1).
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format:
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        //Remove "???" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // Correct!
            alertTitle = "Correct!";
            rightAnswerCount++;

        } else {
            // Wrong...
            alertTitle = "Wrong...";
        }

        // Create Dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    // Show Result.
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
}
