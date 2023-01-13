package edu.northeastern.numad23sp_siyueli;

import androidx.appcompat.app.AppCompatActivity;

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
        aboutMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display toast about personal info
                Toast.makeText(getApplicationContext(), "Zoe Li: zoli@gmail.com", Toast.LENGTH_LONG).show();
            }
        });
    }
}