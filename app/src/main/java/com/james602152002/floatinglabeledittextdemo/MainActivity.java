package com.james602152002.floatinglabeledittextdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.james602152002.floatinglabeledittext.FloatingLabelEditText;
import com.james602152002.floatinglabeledittext.validator.RegexValidator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingLabelEditText editText = findViewById(R.id.label_1);
        editText.addValidator(new RegexValidator("You input numbers", "\\d+"));
        editText.addValidator(new RegexValidator("You input letters.", "[A-Za-z]+$"));
//        editText.setHint_text_color(Color.BLUE);
//        editText.setError("error");
    }
}
