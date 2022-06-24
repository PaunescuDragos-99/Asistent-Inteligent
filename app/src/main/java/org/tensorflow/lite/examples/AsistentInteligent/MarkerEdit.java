package org.tensorflow.lite.examples.AsistentInteligent;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MarkerEdit extends AppCompatActivity {

    EditText editMarkerName;
    EditText editMarkerInfo;
    Button btnEdit;
    String Key;
    String display_MarkerName = null;
    String display_MarkerInfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marker_edit);
        editMarkerName = findViewById(R.id.editMarkerNameText);
        editMarkerInfo = findViewById(R.id.editMarkerInfoText);
        btnEdit = findViewById(R.id.editBtn);



        Intent intent = getIntent();
        Key = intent.getStringExtra("EDIT");

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Marker").child(Key);
        HashMap map = new HashMap ();



        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("markerName",editMarkerName.getText().toString().trim());
                map.put("markerInfo",editMarkerInfo.getText().toString().trim());
                String markerNametxt = String.valueOf(editMarkerName.getText());
                reff.updateChildren(map);
                Toast.makeText(MarkerEdit.this,
                        "Marker name:"+ markerNametxt,
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MarkerEdit.this, ListaMarcajeActivity.class);
                startActivity(intent2);
            }
        });
    }
}