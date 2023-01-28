package edu.northeastern.numad23sp_siyueli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyActivity extends AppCompatActivity {
    private TextView press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky);

        press = (TextView)findViewById(R.id.textViewPress);

        Button buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(view -> press.setText("Pressed: A"));

        Button buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(view -> press.setText("Pressed: B"));

        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(view -> press.setText("Pressed: C"));

        Button buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(view -> press.setText("Pressed: D"));

        Button buttonE = (Button) findViewById(R.id.buttonE);
        buttonE.setOnClickListener(view -> press.setText("Pressed: E"));

        Button buttonF = (Button) findViewById(R.id.buttonF);
        buttonF.setOnClickListener(view -> press.setText("Pressed: F"));
    }
}