package com.example.android.localetext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // Default quantity is 1.
    private int mInputQuantity = 1;

    // TODO: Get the number format for this locale.

    // Fixed price in U.S. dollars and cents: ten cents.
    private double mPrice = 0.10;

    // Exchange rates for France (FR) and Israel (IW).
    double mFrExchangeRate = 0.93; // 0.93 euros = $1.
    double mIwExchangeRate = 3.61; // 3.61 new shekels = $1.

    // TODO: Get locale's currency.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHelp();
            }
        });

        final Date myDate = new Date();
        // Add 5 days in milliseconds to create the expiration date.
        final long expirationDate = myDate.getTime() + TimeUnit.DAYS.toMillis(5);
        // Set the expiration date as the date to display.
        myDate.setTime(expirationDate);

        // TODO: Format the date for the locale.

        // TODO: Apply the exchange rate and calculate the price.

        // TODO: Show the price string.

        final EditText enteredQuantity = (EditText) findViewById(R.id.quantity);
        enteredQuantity.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // String myFormattedTotal;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // Close the keyboard.
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService
                            (Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    // Check if view v is empty.
                    if (v.toString().equals("")) {
                        // Don't format, leave alone.
                    } else {

                        // TODO: Parse string in view v to a number.

                        // TODO: Convert to string using locale's number format.

                        // TODO: Homework: Calculate the total amount from price and quantity.

                        // TODO: Homework: Use currency format for France (FR) or Israel (IL).

                        // TODO: Homework: Show the total amount string.

                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void showHelp() {
        Intent helpIntent = new Intent(this, HelpActivity.class);
        startActivity(helpIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((EditText) findViewById(R.id.quantity)).getText().clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_help:
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                return true;
            case R.id.action_language:
                Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(languageIntent);
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }
}
