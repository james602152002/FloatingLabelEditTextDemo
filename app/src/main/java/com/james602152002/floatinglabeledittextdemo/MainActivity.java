package com.james602152002.floatinglabeledittextdemo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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
        SpannableString span = new SpannableString("label 1 with star *");
        span.setSpan(new ForegroundColorSpan(Color.RED), span.length() -1, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        label_1.setLabel(span);
        label_1.addValidator(new RegexValidator("long error hint......................................................................end", "\\d+"));
        label_1.addValidator(new RegexValidator("You input letters.", "[A-Za-z]+$"));
        label_1.customizeClearBtn(Typeface.createFromAsset(getAssets(), "iconfont.ttf"), "&#xe86d;", Color.GREEN, dp2px(10));
        AppCompatButton button = findViewById(R.id.submit);
        button.setOnClickListener(this);

        //png bitmap clear button label
        FloatingLabelEditText label2 = findViewById(R.id.label_2);
        label2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        label2.addValidator(
                new RegexValidator("long error message long error message long error message long error message long error message ",
                        "\\d+"));

        //png bitmap clear button label
        FloatingLabelEditText label3 = findViewById(R.id.label_3);
        label3.customizeClearBtn(R.drawable.umeng_socialize_qq_on, dp2px(12));

        //vector drawable clear button label
        FloatingLabelEditText label4 = findViewById(R.id.label_4);
        label4.customizeClearBtn(R.drawable.ic_wifi_black_24dp, dp2px(12));
    }

    private int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * getResources().getDisplayMetrics().density);
    }

    @Override
    public void onClick(View v) {
        label_1.setError("submit error");
    }
}
