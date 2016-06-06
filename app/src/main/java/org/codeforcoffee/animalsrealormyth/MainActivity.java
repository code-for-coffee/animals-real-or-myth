package org.codeforcoffee.animalsrealormyth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Animal[] mAnimals;
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
