package org.jcapps.tumblingdice;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Dice mDice;
    private Button mRollBtn;
    private TextView mResultTxt;
    private View.OnClickListener mClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDice = new Dice(6); // 6-sided dice
        mRollBtn = (Button) findViewById(R.id.btn_roll);
        mResultTxt = (TextView) findViewById(R.id.txt_result);

        mClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResultTxt.setText(mDice.rollToString());
            }
        };
        mRollBtn.setOnClickListener(mClickListener);

    }
}
