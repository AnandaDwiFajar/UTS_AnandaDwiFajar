package com.example.uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TW_RecyclerViewAdapter extends RecyclerView.Adapter<TW_RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private Context context;

    public ArrayList<TempatWisataModel> TempatWisataModel;
    private ArrayList<TempatWisataModel> TempatWisataModelFull;

    public TW_RecyclerViewAdapter(Context context, ArrayList<TempatWisataModel> TempatWisataModel,
                                  RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.TempatWisataModel = new ArrayList<>(TempatWisataModel);
        this.TempatWisataModelFull = new ArrayList<>(TempatWisataModel);
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public TW_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TW_RecyclerViewAdapter.MyViewHolder holder, int position) {
        TempatWisataModel currentItem = TempatWisataModel.get(position);
        holder.namaTempat.setText(currentItem.getNamaTempat());
        holder.deskripsiSingkat.setText(currentItem.getDeskripsiSingkat());
        holder.lokasi.setText(currentItem.getLokasi());
        holder.imageView.setImageResource(currentItem.getImage());
    }

    @Override
    public int getItemCount() {
        return TempatWisataModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView namaTempat, deskripsiSingkat, lokasi;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            namaTempat = itemView.findViewById(R.id.textView);
            deskripsiSingkat = itemView.findViewById(R.id.textView2);
            lokasi = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }

    public void updateList(ArrayList<TempatWisataModel> newList) {
        TempatWisataModel = newList;
        notifyDataSetChanged();
    }

    public void filter(String text) {
        ArrayList<TempatWisataModel> filteredList = new ArrayList<>();
        if (text.isEmpty()) {
            filteredList.addAll(TempatWisataModelFull);
        } else {
            for (TempatWisataModel item : TempatWisataModelFull) {
                if (item.getNamaTempat().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }
        }
        updateList(filteredList);
    }
}
