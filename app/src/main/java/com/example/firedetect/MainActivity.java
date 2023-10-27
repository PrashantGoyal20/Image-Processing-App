package com.example.firedetect;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView currentImageView;
    private ImageView processedImageView;
    private Button nextButton;
    private Button processButton;
    private int currentImageIndex = 0;
    private int[] imageResources = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentImageView = findViewById(R.id.currentImageView);
        processedImageView = findViewById(R.id.processedImageView);
        nextButton = findViewById(R.id.nextButton);
        processButton = findViewById(R.id.processButton);


        showCurrentImage(currentImageIndex);

        nextButton.setOnClickListener(v -> {
            currentImageIndex = (currentImageIndex + 1) % imageResources.length;
            showCurrentImage(currentImageIndex);
        });




        processButton.setOnClickListener(v -> {
            processAndShowImage(currentImageIndex);
        });
    }

    private void showCurrentImage(int index) {
        currentImageView.setImageResource(imageResources[index]);
    }

    private void processAndShowImage(int index) {
        processedImageView.setImageResource(imageResources[index]);
    }
}
