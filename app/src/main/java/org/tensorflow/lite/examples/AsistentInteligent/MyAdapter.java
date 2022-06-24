package org.tensorflow.lite.examples.AsistentInteligent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<MarkerModel> list;


    public MyAdapter(Context context, ArrayList<MarkerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.marcaj_recycleview_casuta,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MarkerModel marker = list.get(position);

        String newKey = marker.getMarkerKey();
        holder.MarkerName.setText(marker.getMarkerName());
        holder.MarkerInfo.setText(marker.getMarkerInfo());
        holder.BtnEdit.setOnClickListener(v->
        {
            PopupMenu popupMenu = new PopupMenu(context , holder.BtnEdit);
            popupMenu.inflate(R.menu.option_menu);

            popupMenu.setOnMenuItemClickListener(item->
            {
                switch (item.getItemId())
                {
                    case R.id.menu_edit:
                        Toast.makeText(context,"key 2: "+ newKey,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context ,MarkerEdit.class);
                        intent.putExtra("EDIT",marker.getMarkerKey());
                        //context.startActivity(intent);
                        Toast.makeText(context, "key: "+marker.getMarkerKey(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_remove:
                        DatabaseReference reff = FirebaseDatabase.getInstance().getReference()
                                .child("Marker").child(newKey);
                        reff.removeValue();
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,getItemCount());
                        notifyDataSetChanged();

                }
                return false;
            });
            popupMenu.show();
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView MarkerName;
        TextView MarkerInfo;
        TextView BtnEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            MarkerName = itemView.findViewById(R.id.sMarkerName);
            MarkerInfo = itemView.findViewById(R.id.sMarkerInfo);
            BtnEdit = itemView.findViewById(R.id.btnEdit);

        }
    }

}