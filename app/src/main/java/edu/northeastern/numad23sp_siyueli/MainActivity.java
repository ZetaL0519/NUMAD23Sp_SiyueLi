package edu.northeastern.numad23sp_siyueli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutMeBtn = (Button) findViewById(R.id.AboutMeButton);
        aboutMeBtn.setOnClickListener(view -> openAboutMe());

        // Click Clicky Activity
        Button ClickyBtn = (Button) findViewById(R.id.ClickyButton);
        ClickyBtn.setOnClickListener(view -> openClickyClicky());

        Button LinkControllerBtn = (Button) findViewById(R.id.LinkControllerButton);
        LinkControllerBtn.setOnClickListener(view -> openLinkController());

        Button FindPrimeNumberBtn = (Button) findViewById(R.id.FindPrimeNumberButton);
        FindPrimeNumberBtn.setOnClickListener(view -> openFindPrimeNumber());
    }

    public void openClickyClicky() {
        Intent intent = new Intent(this, ClickyActivity.class);
        startActivity(intent);
    }

    public void openAboutMe() {
        Intent intent = new Intent(this, AboutMeActivity.class);
        startActivity(intent);
    }

    public void openLinkController() {
        Intent intent = new Intent(this, LinkControllerActivity.class);
        startActivity(intent);
    }

    public void openFindPrimeNumber() {
        Intent intent = new Intent(this, FindPrimeNumberActivity.class);
        startActivity(intent);
    }

}