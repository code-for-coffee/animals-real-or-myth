package org.jcapps.statebirds;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Question[] mQuestion = new Question[8];
    private TextView mTxtState;
    private TextView mTxtBird;
    private TextView mTxtDescription;
    private Button mBtnTrue;
    private Button mBtnFalse;
    private TextView mTxtCorrect;
    private TextView mTxtIncorrect;

    private int questionIndex = 0;
    private int correct;
    private int incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion[0] = new Question("Illinois", "Cardinal", "The northern cardinal, a mid-sized songbird, generally has a body length of 7.9 to 9.3 inches, has a wingspan ranging from 9.8 to 12.2 inches, and weighs between 1.19 and 2.29 ounces, with an average weight of 1.58 ounces.", true);
        mQuestion[1] = new Question("Minnesota", "Common Loon", "The Loon, as this interesting species of Diver is generally called in the United States, is a strong, active, and vigilant bird.", true);
        mQuestion[2] = new Question("New Mexico", "Roadrunner", "Officially adopted March 16, 1949. It was adopted under the name 'Chaparral Bird'. In Spanish, it is called 'El Correcaminos'.", true);
        mQuestion[3] = new Question("Georgia", "Blue Hen Chicken", "The Blue Hen Chicken, is a domestic bird (chicken) and therefore has no place in Audubon's Birds of America, which is comprised exclusively of wild birds native to North America.", false);
        mQuestion[4] = new Question("Utah", "Common American Gull", "The Gull that has been bred in Labrador, or still farther north, can reach the Gulf of Mexico without being seriously incommoded by the storms that now and then rage along the Atlantic coast.", true);
        mQuestion[5] = new Question("Virginia", "Hermit Thrush", "All the nests of the Hermit Thrush which I have found were in every instance placed lower on the branches of trees than those of the Wood Thrush, seldom above seven or eight feet from the ground", false);
        mQuestion[6] = new Question("Oklahoma", "Scissor-tail Flycatcher", "Tail longer than the body; upper part of the head, cheeks, and hind neck ash-grey; back brownish-grey, rump dusky; anterior wing-coverts scarlet, quills brownish-black, tail-feathers deep black, the three outer on each side rose-coloured to near the end; lower parts white before, rose-coloured behind.", true);
        mQuestion[7] = new Question("California", "Yellohammer", "The yellowhammer is a medium-sized bird measuring 11 to 14 inches in height and 17 to 21 inches in wingspan. Typical adult weight ranges from 3 to 6 ounces. ", false);

        mTxtState = (TextView) findViewById(R.id.txt_state);
        mTxtBird = (TextView) findViewById(R.id.txt_bird);
        mTxtDescription = (TextView) findViewById(R.id.txt_description);
        mTxtCorrect = (TextView) findViewById(R.id.txt_correct);
        mTxtIncorrect = (TextView) findViewById(R.id.txt_incorrect);

        addListenerOnTrueBtn();
        addListenerOnFalseBtn();

    }
    // Ref.:https://examples.javacodegeeks.com/android/core/ui/button/android-button-example/
    public void addListenerOnTrueBtn() {
        mBtnTrue = (Button) findViewById(R.id.btn_true);
        mBtnTrue.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                switch (v.getId()) {
                    case R.id.btn_true:
                        //Check user response compared to answer of question.
                        submitAnswer(true, mQuestion[questionIndex].isAnswer);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    // Ref.:https://examples.javacodegeeks.com/android/core/ui/button/android-button-example/
    public void addListenerOnFalseBtn() {
        mBtnFalse = (Button) findViewById(R.id.btn_false);
        mBtnFalse.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                switch (v.getId()) {
                    case R.id.btn_false:
                        //Check user response compared to answer of question.
                        submitAnswer(false, mQuestion[questionIndex].isAnswer);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void submitAnswer(boolean useranswer, boolean isAns) {
        if (questionIndex < mQuestion.length) {

            if ((useranswer) && (isAns)) {
                // correct answer
                correct++;
            } else if ((!useranswer) && (isAns)) {
                // incorrect answer
                incorrect++;
            } else if ((useranswer) && (!isAns)) {
                // incorrect answer
                incorrect++;
            } else if ((!useranswer) && (!isAns)) {
                // correct answer
                correct++;
            }

            mTxtCorrect.setText("Correct: " + Integer.toString(correct));
            mTxtIncorrect.setText("Incorrect: " + Integer.toString(incorrect));

            getNextQuestion();
        }
    }

    private void getNextQuestion() {
        // It grabs the next question in the array by first incrementing the index, before displaying the
        // question.
        if (questionIndex < (mQuestion.length-1)) {
            questionIndex++;
            showQuestionTxt(mQuestion[questionIndex]);
        }
        else {
            // This executes after the last question has been answered.  It blanks out the state and bird fields
            // and displays a "Game Over" text in bold.  It also, turns off the click listeners on the true/false
            // buttons and makes them invisible.
            mTxtState.setText("");
            mTxtBird.setText("");
            // Ref.:http://stackoverflow.com/questions/4792260/how-do-you-change-text-to-bold-in-android
            mTxtDescription.setTypeface(null, Typeface.BOLD);
            mTxtDescription.setText("Game Over");
            // Ref.:http://stackoverflow.com/questions/5195321/remove-an-onclick-listener
            mBtnTrue.setOnClickListener(null);
            mBtnFalse.setOnClickListener(null);
            // Ref.:http://stackoverflow.com/questions/4127725/how-can-i-remove-a-button-or-make-it-invisible-in-android
            mBtnTrue.setVisibility(View.INVISIBLE);
            mBtnFalse.setVisibility(View.INVISIBLE);
            // Switch background image.
            // Ref. :http://stackoverflow.com/questions/11115158/change-activity-background-from-code
            RelativeLayout mBackground=(RelativeLayout) findViewById(R.id.layout_main);
            mBackground.setBackgroundResource(R.drawable.fnafbird);
            return;
        }
    }

    private void showQuestionTxt(Question question) {
        mTxtState.setText(question.getmState());
        mTxtBird.setText(question.getmBird());
        mTxtDescription.setText(question.getmDescription());

    }

}
