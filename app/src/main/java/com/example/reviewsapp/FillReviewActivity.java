package com.example.reviewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class FillReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_review);
    }

    public void onCheckBoxIncognitoChanged(View view) {
        CheckBox checkBoxIncognito = (CheckBox) view;
        EditText editTextName = findViewById(R.id.editTextName);
        editTextName.setVisibility( checkBoxIncognito.isChecked() ? View.INVISIBLE : View.VISIBLE );

        int dipMarginTop = checkBoxIncognito.isChecked() ? 4 : 52;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int pxMarginTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,  dipMarginTop, metrics);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) checkBoxIncognito.getLayoutParams();
        params.setMargins(params.leftMargin, pxMarginTop, params.rightMargin, params.bottomMargin);
        checkBoxIncognito.requestLayout();
    }

    public void onSubmit(View view) {
        EditText editTextName = findViewById(R.id.editTextName);
        CheckBox checkBoxIncognito = findViewById(R.id.checkBoxIncognito);
        Spinner spinnerEmployee = findViewById(R.id.spinnerEmployee);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        EditText editTextMessage = findViewById(R.id.editTextMessage);

        Intent intent = new Intent(this, ConfirmReviewActivity.class);
        intent.putExtra(ConfirmReviewActivity.EXTRA_NAME, checkBoxIncognito.isChecked() ? "" : editTextName.getText().toString());
        if(spinnerEmployee.getSelectedItem() != null) {
            intent.putExtra(ConfirmReviewActivity.EXTRA_EMPLOYEE, spinnerEmployee.getSelectedItem().toString());
        }
        intent.putExtra(ConfirmReviewActivity.EXTRA_RATING, ratingBar.getRating());
        intent.putExtra(ConfirmReviewActivity.EXTRA_MESSAGE, editTextMessage.getText().toString());

        startActivity(intent);
    }
}