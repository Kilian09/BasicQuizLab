package com.example.basicquizlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    private Button trueButton, falseButton, cheatButton, nextButton;
    private TextView questionTextView, replyText;

    private String[] questionArray;
    private int[] replyArray;
    private int questionIndex = 0;

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
        replyText = findViewById(R.id.replyTextView);
    }

    private void initResources() {
        questionArray = getResources().getStringArray(R.array.question_array);
        replyArray = getResources().getIntArray(R.array.reply_array);
    }

    private void initLayoutContent() {

        trueButton.setText(R.string.true_button_text);
        falseButton.setText(R.string.false_button_text);
        cheatButton.setText(R.string.cheat_button_text);
        nextButton.setText(R.string.next_button_text);

        setQuestionAndAnswerText();

        disableNextButton();

    }


    public void onClickButton(View view) {
        switch (view.getId()) {
            case R.id.trueButton:
                onClickTrueButton(view);
                break;
            case R.id.falseButton:
                onClickFalseButton(view);
                break;
            case R.id.nextButton:
                onClickNextButton(view);
                break;
            case R.id.cheatButton:
                onClickCheatButton(view);
                break;
        }
    }

    public void onClickTrueButton(View view) {
        if (replyArray[questionIndex] == 1) {
            //correct
            replyText.setText(R.string.correct_text);
        } else {
            //incorret
            replyText.setText(R.string.incorrect_text);
        }

        disableTopButtons();

        enableNextButton();
    }

    public void onClickFalseButton(View view) {
        if (replyArray[questionIndex] == 0) {
            //correct
            replyText.setText(R.string.correct_text);
        } else {
            //incorret
            replyText.setText(R.string.incorrect_text);
        }

        disableTopButtons();

        enableNextButton();
    }

    public void onClickNextButton(View view) {
        questionIndex++;

        restart();

        setQuestionAndAnswerText();

        disableNextButton();

        enableTopButtons();
    }

    // Implementar boton cheat
    public void onClickCheatButton(View view) {
        Intent intent = new Intent(this,CheatActivity.class);
        startActivity(intent);
    }

    private void setQuestionAndAnswerText() {
        questionTextView.setText(questionArray[questionIndex]);
        replyText.setText(R.string.empty_text);
    }

    // reinicia el indice de la pregunta cuando es igual a la longitud del array
    private void restart() {
        if (questionIndex == questionArray.length) {
            questionIndex = 0;
        }
    }

    // habilita los botones true y false
    private void enableTopButtons() {
        trueButton.setEnabled(true);
        falseButton.setEnabled(true);
    }

    // deshabilita los botones true y false
    private void disableTopButtons() {
        trueButton.setEnabled(false);
        falseButton.setEnabled(false);
    }

    // habilita el boton de next
    private void enableNextButton() {
        nextButton.setEnabled(true);
    }

    // deshabilita el boton de next
    private void disableNextButton() {
        nextButton.setEnabled(false);
    }
}
