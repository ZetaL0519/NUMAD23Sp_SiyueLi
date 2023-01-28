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
        aboutMeBtn.setOnClickListener(view -> {
            // Display toast about personal info
            Toast.makeText(getApplicationContext(), "Zoe Li: zoli@gmail.com", Toast.LENGTH_LONG).show();
        });

        // Click Clicky Activity
        Button ClickyBtn = (Button) findViewById(R.id.ClickyButton);
        ClickyBtn.setOnClickListener(view -> {
            openClickyClicky();
        });
    }

    public void openClickyClicky() {
        Intent intent = new Intent(this, ClickyActivity.class);
        startActivity(intent);
    }
}