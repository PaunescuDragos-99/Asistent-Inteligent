package org.tensorflow.lite.examples.AsistentInteligent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void DetectorActivity(View view) {
        Intent intent = new Intent(this, DetectorActivity.class);
        startActivity(intent);
    }
    public void HartiActivity(View view) {
        Intent intent = new Intent(this, HartiActivity.class);
        startActivity(intent);
    }

}
