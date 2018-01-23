package com.james602152002.floatinglabeledittextdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.james602152002.floatinglabeledittext.FloatingLabelEditText;
import com.james602152002.floatinglabeledittext.validator.RegexValidator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingLabelEditText label_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label_1 = findViewById(R.id.label_1);
        label_1.addValidator(new RegexValidator("long error hint", "\\d+"));
        label_1.addValidator(new RegexValidator("You input letters.", "[A-Za-z]+$"));
        AppCompatButton button = findViewById(R.id.submit);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        label_1.setError("submit error");
    }
}
