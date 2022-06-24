package org.tensorflow.lite.examples.AsistentInteligent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ListaMarcajeActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.homeworkandroid.extra.MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;


    private static final String TAG = "MainMarkers";
    RecyclerView recyclerView;
    ArrayList<MarkerModel> markerList;
    String Key;

    DatabaseReference reff;
    DatabaseReference reff2;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_marcaj);

        recyclerView = findViewById(R.id.markerList);
        reff = FirebaseDatabase.getInstance().getReference("Marker");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        markerList = new ArrayList<>();
        adapter = new MyAdapter(this, markerList);
        recyclerView.setAdapter(adapter);


        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MarkerModel marker = dataSnapshot.getValue(MarkerModel.class);


                    markerList.add(marker);
                    reff2 = FirebaseDatabase.getInstance().getReference().child("Marker").push();
                    String key = reff2.getKey();
                    //Toast.makeText(ListaMarcajeActivity.this, "Key"+key, Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void HartiActivity(View view) {
        Intent intent = new Intent(this, HartiActivity.class);
        startActivity(intent);
    }
    public void AdaugareMarcajActivity(View view) {
        Intent intent = new Intent(this, AdaugareMarcajActivity.class);
        startActivity(intent);
    }


}
