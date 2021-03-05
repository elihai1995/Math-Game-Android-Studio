package us.game3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
    private Button buttonBack, buttonPlayAgain;
    TextView TextFinalScore;

    public static int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        finalScore = GameActivity.currentScore;
        buttonPlayAgain = (Button)findViewById(R.id.buttonPlayAgain);
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view2) {
                Intent i = new Intent(GameOverActivity.this, GameActivity.class);
                startActivity(i);
            }
        });
        buttonBack = (Button)findViewById(R.id.buttonBackToTheMenu);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent j = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(j);
            }
        });
        TextFinalScore = findViewById(R.id.textFinalScore);
        TextFinalScore.setText("Final Score: " + finalScore);
        GameActivity.currentScore = 0;
    }
}
