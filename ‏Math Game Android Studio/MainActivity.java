package us.game3;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.view.View.OnClickListener;
        import android.view.Menu;

/**
 Android Studio Math Game Program ReadMe
 ======================================

 Assignment 4.
 Hagay Cohen ID 201305679, hagaico100@gmail.com
 Elihai Ben Avraham ID 206056400, elihai1995@gmail.com
 Second year
 Computer Science Department- Ashqelon College
 ================================================

 Assignment:
 Improving and working on an existing program on Android Studio.
 The program is a game app. when the user clicks the PLAY button the game begins, when he clicks the FINAL SCORE button he can see his final score at the game, and when he clicks the QUIT button he exits the app. the game consists of multiple questions in math, and each question has 3 possible answers. the user starts the game with 5 strikes. if he answers correctly, he accumulates a point and moves on to the next question. if he is wrong, he is still going to the next question, but instead of accumulating a point he gains strike. the game ends when the user is wrong in a situation of 0 strikes, so he goes to the "game over" screen, and there he sees the score he achieved in the game.

 Main goals:
 Use our knowledge in Android Studio programming.

 Perform improvements according to the requirements and according to our ideas.

 Write a ReadMe that explains how the program works.

 Package:
 Game3.

 Java Classes:
 MainActivity.
 GameActivity.
 GameOverActivity.
 FinalScoreActivity.

 XML files:
 activity_main.
 activity_game.
 activity_game_over.
 activity_final_score.

 Classes Explanation:

 This program has four activities, which all of them has a background of Chinese dragons.
 The first activity is called MainActivity, which is the main screen of the program. this screen has a title, a special picture of the Android man in red and yellow, and three buttons: PLAY, FINAL SCORE and QUIT. both the PLAY and FINAL SCORE buttons bring you to other two activities.
 The second activity is called GameActivity, which comes when you press the PLAY button that leads you to the game itself, there you has 5 strikes at the beginning of the game, and there is a multiplication exercise and three buttons of answer options. if you click on the correct answer, then you move on to the next exercise and your score grows by one. if you click on a wrong answer, you are still going to the next question, but instead of accumulating a point your strikes number drops by 1. if you click on a wrong answer in a situation of 0 strikes, you go to other activity. there is also a BACK TO THE MENU button, that brings you back to the MainActivity screen.
 The third activity is called GameOverActivity, which comes when you click on a wrong answer in GameActivity screen in a situation of 0 strikes. this screen has a "Game Over" title, a line that shows your final score in the game and two buttons. the first button is PLAY AGAIN button, which brings you back to GameActivity screen and there you start a new game. the second button is BACK TO THE MENU button, that brings you back to the MainActivity screen.
 The fourth activity is called FinalScoreActivity, which comes when you press the FINAL SCORE this screen has a "Final Score" title, a line that shows your final score in the game a BACK TO THE MENU button, that brings you back to the MainActivity screen.
 Each activity has an appropriate xml file containing the graphics and settings of the buttons.
 Each java file has a method called onCreate that is created once an activity is created where all the links that the activity needs to work.
 Each click button has a function called onClick that is passed by pressing the button to the appropriate activity to which we want it to go.

 Running the program:

 When the program starts the user sees the main screen and three buttons.
 the first button is the PLAY button. when clicked, it moves it to the game itself. the game consists of multiple questions in math, and each question has 3 possible answers. the user starts the game with 5 strikes. when he clicks the correct answer, the message "That's the right answer! Well done!" appears and the score increases by 1, and when he makes a mistake, the message "Sorry, but that's a wrong answer." appears, the strikes decreases by 1.
 The second button is the FINAL SCORES button, which when clicked, will display a screen with the final score of the last game and the button BACK TO THE MENU screen.
 The third button is the QUIT button when he wants to exit the game he clicks on it.
 All the process of running the program have been done only on "Genymotion" emulator, and in the "drawable" folder are attached images that show the activities of the game in the "Genymotion" emulator.


 Sources:
 https://developer.android.com/studio
 https://en.wikipedia.org/wiki/Android_Studio
 https://www.instructables.com/id/How-To-Create-An-Android-App-With-Android-Studio/
 https://www.genymotion.com/
 buttons https://developer.android.com/reference/android/widget/Button
 layouts https://developer.android.com/guide/topics/ui/declaring-layout
 Activities https://developer.android.com/reference/android/app/Activity

 */

public class MainActivity extends Activity   {
    private Button buttonPlay,buttonFinalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPlay = (Button)findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                GameActivity.currentScore = 0;
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });
        buttonFinalScore = (Button)findViewById(R.id.buttonFinalScore);
        buttonFinalScore.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FinalScoreActivity.class);
                startActivity(i);
            }
        });

    }
    public void clickExit(View v){
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        startActivity(i);
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}






