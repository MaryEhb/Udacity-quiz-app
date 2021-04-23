package android.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numberOfQuestions = 7;

    //Method called when the submit button is clicked
    public void submit(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), makeText(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    //Method that make the text shown in the toast
    public String makeText() {
        int correct = correctAnswers();
        EditText studentNameElement = (EditText) findViewById(R.id.student_name);
        EditText studentClassElement = (EditText) findViewById(R.id.student_class);

        String studentName = studentNameElement.getText().toString();
        String studentClass = studentClassElement.getText().toString();
        String status;

        if (correct == numberOfQuestions) {
            status = "Well done you are an excellent student.";
        } else if (correct == 0) {
            status = "Oh! you need to study your lessons man.";
        } else {
            status = "try working on yourself more. you can do it.";
        }

        return "Name: " + studentName + "\n" +
                "Class: " + studentClass + "\n" +
                "You answered " + correct + " correct answers of total "
                + numberOfQuestions + " questions \n" +
                status + "\n" +
                "Thank you for taking the test!";
    }

    // Method that checks and return number of correct answers
    public int correctAnswers() {
        int correct = 0;

        RadioButton ans1 = (RadioButton) findViewById(R.id.ans_1);
        RadioButton ans2 = (RadioButton) findViewById(R.id.ans_2);
        RadioButton ans4 = (RadioButton) findViewById(R.id.ans_4);
        RadioButton ans5 = (RadioButton) findViewById(R.id.ans_5);
        RadioButton ans6 = (RadioButton) findViewById(R.id.ans_6);
        EditText ans7Element = (EditText) findViewById(R.id.ans_7);
        String ans7 = ans7Element.getText().toString();

        CheckBox ans31 = (CheckBox) findViewById(R.id.ans_3_1);
        CheckBox ans32 = (CheckBox) findViewById(R.id.ans_3_2);
        CheckBox ans33 = (CheckBox) findViewById(R.id.ans_3_3);
        CheckBox ans34 = (CheckBox) findViewById(R.id.ans_3_4);
        String rightAns7 = getResources().getString(R.string.ans7);


        if (ans1.isChecked()) {
            correct++;
        }

        if (ans2.isChecked()) {
            correct++;
        }

        if (ans33.isChecked() && ans32.isChecked() && !ans31.isChecked() && !ans34.isChecked()) {
            correct++;
        }

        if (ans4.isChecked()) {
            correct++;
        }

        if (ans5.isChecked()) {
            correct++;
        }

        if (ans6.isChecked()) {
            correct++;
        }

        if (ans7.equalsIgnoreCase(rightAns7)) {
            correct++;
        }

        return correct;
    }
}