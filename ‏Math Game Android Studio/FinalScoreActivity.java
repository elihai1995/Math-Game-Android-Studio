package us.game3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScoreActivity extends AppCompatActivity {
    private Button buttonBack;
    TextView TextFinalScore;

    int finalScore = GameOverActivity.finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        buttonBack = (Button)findViewById(R.id.buttonBackToTheMenu);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(FinalScoreActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        TextFinalScore = findViewById(R.id.textFinalScore);
        TextFinalScore.setText("Your final score is: " + finalScore);
    }
}
