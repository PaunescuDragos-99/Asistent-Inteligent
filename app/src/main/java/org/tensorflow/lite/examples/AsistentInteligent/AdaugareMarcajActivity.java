package org.tensorflow.lite.examples.AsistentInteligent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdaugareMarcajActivity extends AppCompatActivity {

    EditText txtMarkerName, txtMarkerInfo;
    Button btnSave;
    DatabaseReference reff;
    MarkerModel marker = new MarkerModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcaj_nou);
        txtMarkerName=findViewById(R.id.txtMarkerName);
        txtMarkerInfo=findViewById(R.id.txtMarkerInfo);
        btnSave=findViewById(R.id.btnSave);
        marker = new MarkerModel();
        reff = FirebaseDatabase.getInstance().getReference().child("Marker");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker.setMarkerName(txtMarkerName.getText().toString().trim());
                marker.setMarkerInfo(txtMarkerInfo.getText().toString().trim());

                reff.push().setValue(marker);
                Toast.makeText(AdaugareMarcajActivity.this, "Okey",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void NewMarkerActivity(View view) {
        Intent intent = new Intent(this, ListaMarcajeActivity.class);
        startActivity(intent);
    }

}