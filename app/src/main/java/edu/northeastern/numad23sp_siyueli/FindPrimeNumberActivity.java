package edu.northeastern.numad23sp_siyueli;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FindPrimeNumberActivity extends AppCompatActivity {
    private volatile boolean isSearching = false;
    private volatile int currentNumber = 3;
    private int latestPrimeFound = 0;

    private Button findPrimesButton;
    private Button terminateSearchButton;
    private CheckBox pacifierSwitch;
    private TextView currentNumberTextView;
    private TextView latestPrimeTextView;
    private Handler textHandler = new Handler();

    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);

        findPrimesButton = findViewById(R.id.FindPrimeNumberButton);
        terminateSearchButton = findViewById(R.id.TerminateButton);
        pacifierSwitch = findViewById(R.id.pacifierSwitch);
        currentNumberTextView = findViewById(R.id.currentNumberTextView);
        latestPrimeTextView = findViewById(R.id.latestPrimeTextView);

        findPrimesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSearching) {
                    currentNumber = 3;
                    currentNumberTextView.setText(currentNumber);
                    latestPrimeTextView.setText("");
                    Thread searchThread = new Thread(new PrimeNumberSearchRunnable());
                    searchThread.start();
                }
            }
        });

        terminateSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSearching) {
                    isSearching = false;
                }
            }
        });

        if (savedInstanceState != null) {
            currentNumber = savedInstanceState.getInt("currentNum");
            latestPrimeFound = savedInstanceState.getInt("latestPrime");
            pacifierSwitch.setChecked(savedInstanceState.getBoolean("pacifierSwitch"));
        }
    }

    private class PrimeNumberSearchRunnable implements Runnable {


        @Override
        public void run() {
            while(isSearching) {
                textHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (isPrime(currentNumber)) {
                            latestPrimeFound = currentNumber;
                            latestPrimeTextView.setText(latestPrimeFound);
                        } else {
                            currentNumberTextView.setText(Integer.toString(currentNumber));
                        }
                    }
                });
                currentNumber++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (isSearching) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to terminate the search?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setCancelable(false);
            AlertDialog alert = builder.create();
            alert.show();
        }
        else {
            super.onBackPressed();
        }
    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
