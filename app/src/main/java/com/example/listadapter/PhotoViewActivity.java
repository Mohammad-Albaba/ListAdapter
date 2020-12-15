package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class PhotoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        int imageRes = getIntent().getIntExtra("image_res" , -1);
        ImageView imageView = findViewById(R.id.image_view_photo);
        imageView.setImageResource(imageRes);
    }
}