package edu.northeastern.numad23sp_siyueli;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FindPrimeNumberActivity extends AppCompatActivity {

    private static final String TAG = "FindPrimeActivity";

    private TextView currentNumTextView;
    private TextView latestPrimeTextView;
    private Handler textHandler = new Handler();
    private Button findPrimeButton;
    private Button terminateSearchButton;
    private boolean endSearch = true;
    private int currentNum = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);
        currentNumTextView = (TextView) findViewById(R.id.current_num_text);
        latestPrimeTextView = (TextView) findViewById(R.id.latest_prime_text);

        findPrimeButton = (Button) findViewById(R.id.start_search_button);
        terminateSearchButton = (Button) findViewById(R.id.terminate_search_button);

        findPrimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endSearch = false;
                currentNumTextView.setText(currentNum);
                latestPrimeTextView.setText("");
                ChildThread childThread = new ChildThread();
                new Thread(childThread).start();
            }
        });

        terminateSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endSearch = true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!endSearch) {
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

    protected class ChildThread implements Runnable {
        int originalNum = 3;
        @Override
        public void run() {
            while (!endSearch) {
                textHandler.post(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        if (isPrime(originalNum)) {
                            latestPrimeTextView.setText(Integer.toString(originalNum));
                        } else {
                            currentNumTextView.setText(Integer.toString(originalNum));
                        }
                    }
                });
                originalNum++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}