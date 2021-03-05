package us.game3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.Menu;


public class GameActivity extends Activity implements View.OnClickListener{

    public static final String PREFS_NAME = "MyPrefsFile";
    int correctAnswer;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;
    TextView textObjectStrike;
    private Button buttonBack;

    public static int currentScore = 0;
    int currentLevel = 1;
    int currentStrike = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        buttonBack = (Button)findViewById(R.id.buttonBackToTheMenu);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(GameActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        textObjectPartA = findViewById(R.id.textPartA);
        textObjectPartB = findViewById(R.id.textPartB);
        textObjectScore = findViewById(R.id.textScore);
        textObjectStrike = findViewById(R.id.textStrike);
        buttonObjectChoice1 = findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = findViewById(R.id.buttonChoice3);
        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

        setQuestion();

    }//onCreate ends here

    int i = 0;
    public int numOfDigits(int n){
        if (n > 0){
            i++;
            return numOfDigits (n / 10);
        }

        return i;
    }

    @Override
    public void onClick(View view) {
        int answerGiven = 0;
        switch (view.getId()) {

            case R.id.buttonChoice1:
                //initialize a new int with the value contained in buttonObjectChoice1
                //Remember we put it there ourselves previously
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
                break;

            case R.id.buttonChoice2:
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
                break;

            case R.id.buttonChoice3:
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
                break;

        }
        if(answerGiven != correctAnswer && currentStrike == 0){
            final Intent j = new Intent(GameActivity.this, GameOverActivity.class);
            startActivity(j);
        }
        else{
            updateScoreAndLevelAndStrikes(answerGiven);
            setQuestion();
        }
    }

    void setQuestion(){
        int numberRange = 20 + (currentLevel * 4);
        Random randInt = new Random();

        int partA = randInt.nextInt(numberRange) + 9;
        partA += 10;

        int partB = randInt.nextInt(numberRange) + 9;
        partB += 10;

        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer + 10;
        int wrongAnswer2 = correctAnswer - 10;

        textObjectPartA.setText(""+partA);
        textObjectPartB.setText(""+partB);

        //set the multi choice buttons
        //A number between 0 and 2
        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout){
            case 0:
                buttonObjectChoice1.setText(""+correctAnswer);
                buttonObjectChoice2.setText(""+wrongAnswer1);
                buttonObjectChoice3.setText(""+wrongAnswer2);
                break;

            case 1:
                buttonObjectChoice2.setText(""+correctAnswer);
                buttonObjectChoice3.setText(""+wrongAnswer1);
                buttonObjectChoice1.setText(""+wrongAnswer2);
                break;

            case 2:
                buttonObjectChoice3.setText(""+correctAnswer);
                buttonObjectChoice1.setText(""+wrongAnswer1);
                buttonObjectChoice2.setText(""+wrongAnswer2);
                break;
        }
    }

    void updateScoreAndLevelAndStrikes(int answerGiven){

        if(isCorrect(answerGiven)){
            currentScore++;
            currentLevel++;
        }
        else{
            currentStrike--;
        }

        textObjectScore.setText("Score: " + currentScore);
        textObjectStrike.setText("Strikes: " + currentStrike);
    }

    boolean isCorrect(int answerGiven){
        boolean correctTrueOrFalse;
        if(answerGiven == correctAnswer){
            Toast.makeText(getApplicationContext(), R.string.currect, Toast.LENGTH_LONG).show();
            correctTrueOrFalse=true;
        }
        else{//Uh-oh!
            Toast.makeText(getApplicationContext(), R.string.wrong, Toast.LENGTH_LONG).show();
            correctTrueOrFalse=false;
        }
        return correctTrueOrFalse;
    }

}
