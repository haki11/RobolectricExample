package com.test.robolectric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvField);

        Button button1 = findViewById(R.id.btnUpdateText);
        button1.setOnClickListener(v -> {
            textView.setText("Testing Android Rocks!");
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
           Intent intent = new Intent(this, MainActivity2.class);
           intent.putExtra("key", "value");
              startActivity(intent);
        });
    }
}