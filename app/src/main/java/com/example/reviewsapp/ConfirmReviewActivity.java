package com.example.reviewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmReviewActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_EMPLOYEE = "employee";
    public static final String EXTRA_RATING = "rating";
    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_review);

        Intent intent = getIntent();
        String text = "";
        String name = intent.getStringExtra(EXTRA_NAME);
        if(!name.isEmpty()) {
            text += "Имя: " + name + "\r\n";
        }

        String employee = intent.getStringExtra(EXTRA_EMPLOYEE);
        if(!employee.isEmpty()) {
            text += "Сотрудник: " + employee + "\r\n";
        }

        float rating = intent.getFloatExtra(EXTRA_RATING, 0);
        if(rating != 0) {
            text += "Рейтинг:" + rating + "\r\n";
        }

        String message = intent.getStringExtra(EXTRA_MESSAGE);
        if(!message.isEmpty()) {
            text += "Сообщение:\r\n" + message;
        }

        TextView textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText(text);
    }

    public void onConfirm(View view) {
        Intent intent = new Intent(this, FillReviewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        finish();
        startActivity(intent);
    }
}