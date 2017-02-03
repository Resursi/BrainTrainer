package inworkster.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button startButton;
    Button playAgain;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView question;
    TextView resultTextView;
    TextView booleanTextView;
    TextView timerTextView;
    ConstraintLayout gameConstraintLayout;
    int locationOfCorrectAnswer;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int score = 0;
    int total = 0;


    public void generateQuestion(){

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        question.setText(Integer.toString(a) + " + " + Integer.toString(b));

        answers.clear();

        locationOfCorrectAnswer = rand.nextInt(4);
        int incorrectAnswer;

        for(int i = 0; i < 4; i++){

            if(i == locationOfCorrectAnswer){

                answers.add(a + b);

            }   else {

                incorrectAnswer = rand.nextInt(41);

                while (incorrectAnswer == a + b){

                    incorrectAnswer = rand.nextInt(41);

                }

                answers.add(incorrectAnswer);

            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public void playAgain(View view){

        score = 0;
        total = 0;

        timerTextView.setText("0s");
        resultTextView.setText("0/0");
        booleanTextView.setText("");
        playAgain.setVisibility(View.INVISIBLE);
        generateQuestion();


        new CountDownTimer(30100, 1000) {


            @Override
            public void onTick(long l) {

                timerTextView.setText(String.valueOf(l/1000) + "s");

            }

            @Override
            public void onFinish() {

                timerTextView.setText("0s");
                booleanTextView.setText("Your score is: " + Integer.toString(score) + "/" + Integer.toString(total));
                playAgain.setVisibility(View.VISIBLE);
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
            }
        }.start();

    }

    public void button0Pressed(View view){

        if(Integer.toString(locationOfCorrectAnswer).equals(Integer.toString(0))){

            score++;
            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Correct");

        }   else {

            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Wrong");

        }

        generateQuestion();

    }

    public void button1Pressed(View view){

        if(Integer.toString(locationOfCorrectAnswer).equals(Integer.toString(1))){

            score++;
            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Correct");

        }   else {

            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Wrong");

        }

        generateQuestion();

    }

    public void button2Pressed(View view){

        if(Integer.toString(locationOfCorrectAnswer).equals(Integer.toString(2))){

            score++;
            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Correct");

        }   else {

            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Wrong");
        }

        generateQuestion();

    }

    public void button3Pressed(View view){

        if(Integer.toString(locationOfCorrectAnswer).equals(Integer.toString(3))){

            score++;
            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Correct");

        }   else {

            total++;
            resultTextView.setText(Integer.toString(score) + "/" + Integer.toString(total));
            booleanTextView.setText("Wrong");

        }
        generateQuestion();

    }


    public void startButton(View view){

        startButton.setVisibility(View.INVISIBLE);
        gameConstraintLayout.setVisibility(ConstraintLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgain));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        question = (TextView)findViewById(R.id.questionTextView);
        resultTextView = (TextView)findViewById(R.id.scoreTextView);
        booleanTextView = (TextView)findViewById(R.id.booleanTextView);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        gameConstraintLayout = (ConstraintLayout)findViewById(R.id.gameConstraintLayout);

        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        playAgain = (Button)findViewById(R.id.playAgain);

    }

}
