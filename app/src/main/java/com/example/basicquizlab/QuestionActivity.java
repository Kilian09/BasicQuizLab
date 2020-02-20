package com.example.basicquizlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    private TextView questionTextView;
    private TextView answerTextView;
    private Button trueButton;
    private Button falseButton;
    private Button cheatButton;
    private Button nextButton;

    private int questionIndex = 0;

    private String[] questionArray;

    private int[] answerArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        initLayoutComponents();
        initResources();
        initLayoutContent();
    }

    private void initLayoutComponents() {

        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        cheatButton = findViewById(R.id.cheatButton);
        nextButton = findViewById(R.id.nextButton);

        questionTextView = findViewById(R.id.questionTextView);
        answerTextView = findViewById(R.id.answerTextView);
    }

    private void initResources() {
        questionArray = getResources().getStringArray(R.array.question_text_array);
        answerArray = getResources().getIntArray(R.array.answer_text_array);
    }

    private void initLayoutContent() {

        trueButton.setText(R.string.true_button_text);
        falseButton.setText(R.string.false_button_text);
        cheatButton.setText(R.string.cheat_button_text);
        nextButton.setText(R.string.next_button_text);

        questionTextView.setText(questionArray[questionIndex]);
        answerTextView.setText(R.string.empty_text);
    }

    public void onClickTrueButton(View view) {
        if (answerArray[questionIndex] == 1) {
            //correct
            answerTextView.setText(R.string.correct_text);
        } else {
            //incorret
            answerTextView.setText(R.string.incorrect_text);
        }
    }

    public void onClickFalseButton(View view) {
        if (answerArray[questionIndex] == 0) {
            //correct
            answerTextView.setText(R.string.correct_text);
        } else {
            //incorret
            answerTextView.setText(R.string.incorrect_text);
        }
    }

    public void onClickCheatButton(View view) {

    }

    public void onClickNextButton(View view) {
        questionIndex++;

        if (questionIndex == questionArray.length) {
            questionIndex = 0;
        }
    }

}
