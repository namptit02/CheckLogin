package com.example.checklogin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private TextView fullNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fullNameTextView = findViewById(R.id.fullNameTextView);

        // Lấy FullName từ Intent và hiển thị
        String fullName = getIntent().getStringExtra("fullname");
        fullNameTextView.setText("Welcome, " + fullName);
    }
}