package org.codeforcoffee.animalsrealormyth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Animal[] mAnimals = new Animal[5];
    private TextView mTxtName;
    private TextView mTxtDescription;
    private TextView mTxtLocation;
    private TextView mTxtAttempts;
    private TextView mTxtScore;
    private Button mBtnTrue;
    private Button mBtnFalse;
    private Toast mToast;

    private int currentQuestion = 0;
    private int score;
    private int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAnimals[0] = new Animal("Kakapo", "An endangered species; known as the flightless bird that is too friendly", "New Zealand", false);
        mAnimals[1] = new Animal("Unicorn", "A rare sight to behold; the horse with a horn!", "South America", true);
        mAnimals[2] = new Animal("Bottle nose dolphin", "The cutest, chubbiest dolphin ever; now thought to be extinct", "China", false);
        mAnimals[3] = new Animal("Loch Ness Monster", "A pleiasaur leftover from eons long gone", "Ireland", true);
        mAnimals[4] = new Animal("Coral Snake", "Rumoured to eat nothing but coral, the coral snake continuously bites a victim.", "Coastal US", false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTrue = (Button) findViewById(R.id.btn_true);
        mBtnFalse = (Button) findViewById(R.id.btn_true);
        mTxtName = (TextView) findViewById(R.id.animal_name);
        mTxtLocation = (TextView) findViewById(R.id.animal_home);
        mTxtDescription = (TextView) findViewById(R.id.animal_desc);
        mTxtScore = (TextView) findViewById(R.id.txt_score);
        mTxtAttempts = (TextView) findViewById(R.id.txt_user_attempts);

    }
}
