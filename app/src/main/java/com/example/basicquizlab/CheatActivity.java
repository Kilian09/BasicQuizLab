package com.example.basicquizlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    private Button noButton, yesButton;
    private TextView sureText, cheatReplyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        initComponents();

        initLayoutContent();
    }

    private void initComponents() {
        noButton = findViewById(R.id.noButton);
        yesButton = findViewById(R.id.yesButton);

        sureText = findViewById(R.id.sureTextView);
        cheatReplyText = findViewById(R.id.cheatReplyTextView);
    }

    private void initLayoutContent() {

        noButton.setText(R.string.no_button_text);
        yesButton.setText(R.string.yes_button_text);

        sureText.setText(R.string.sure_text);
        cheatReplyText.setText(R.string.empty_text);
    }


    public void onClickCheatButtons(View view) {
        switch (view.getId()) {
            case R.id.noButton:
                onClickNoButton(view);
                break;
            case R.id.yesButton:
                onClickYesButton(view);
                break;
        }
    }

    public void onClickNoButton(View view) {

    }

    public void onClickYesButton(View view) {

    }
}
