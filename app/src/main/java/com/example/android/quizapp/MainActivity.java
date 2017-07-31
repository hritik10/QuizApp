package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.q1_a;
import static com.example.android.quizapp.R.id.q2_b;
import static com.example.android.quizapp.R.id.q3_c;
import static com.example.android.quizapp.R.id.q4_d;
import static com.example.android.quizapp.R.id.q5_b;


public class MainActivity extends AppCompatActivity {

    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * answers[] has solution of all the questioos
     */
    public void solution() {
        int answers[] = new int[5];
        answers[0] = q1_a;
        answers[1] = q2_b;
        answers[2] = q3_c;
        answers[3] = q4_d;
        answers[4] = q5_b;
        int i;
        for (i = 0; i < 5; i++) {
            RadioButton radio = (RadioButton) findViewById(answers[i]);
            if (radio.isChecked()) {
                correct++;
            }
        }
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q6_a);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q6_b);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q6_c);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q6_d);
        if ((checkBox1.isChecked()) && (checkBox2.isChecked()) && (!checkBox3.isChecked()) && (!checkBox4.isChecked()))
            correct++;
        EditText ans = (EditText) findViewById(R.id.answer7);
        String answer_7 = ans.getText().toString().toUpperCase();
        if (answer_7.equals("NEW DELHI")) {
            correct++;
        }
    }

    /**
     * display the quiz result
     */
    public void submit(View view) {
        solution();
        EditText name = (EditText) findViewById(R.id.name);
        String cust_name = name.getText().toString();
        String message;
        if (correct == 7) {
            message = "Congrats,All the answers are correct\n" + cust_name + ",Your Score is " + correct;
        } else {
            message = cust_name + ",Your Score is " + correct;
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        correct = 0;
    }
}