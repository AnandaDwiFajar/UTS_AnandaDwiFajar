package com.example.uts;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<TempatWisataModel> TempatWisataList = new ArrayList<>();
    TW_RecyclerViewAdapter adapter;

    int[] GambarWisata = {R.drawable.pulau_komodo, R.drawable.candi_borobudur, R.drawable.danau_toba,
            R.drawable.pantai_kuta, R.drawable.taman_laut_bunaken, R.drawable.raja_ampat, R.drawable.gunung_bromo,
            R.drawable.tana_toraja, R.drawable.kawah_ijen, R.drawable.pulau_seribu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("Cari tempat");

        setUpTempatWisataModel();

        adapter = new TW_RecyclerViewAdapter(this, TempatWisataList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
        searchView.setOnClickListener(v -> searchView.setIconified(false));
    }

    private void setUpTempatWisataModel() {
        String[] NamaTempat = getResources().getStringArray(R.array.nama_tempat);
        String[] DeskripsiSingkat = getResources().getStringArray(R.array.deskripsi_singkat);
        String[] Lokasi = getResources().getStringArray(R.array.lokasi);
        String[] Deskripsi = getResources().getStringArray(R.array.deskripsi);

        for (int i = 0; i < NamaTempat.length; i++) {
            TempatWisataList.add(new TempatWisataModel(NamaTempat[i],
                    DeskripsiSingkat[i], Lokasi[i], Deskripsi[i], GambarWisata[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        TempatWisataModel clickedItem = adapter.TempatWisataModel.get(position);

        intent.putExtra("nama_tempat", clickedItem.getNamaTempat());
        intent.putExtra("deskripsi", clickedItem.getDeskripsi());
        intent.putExtra("lokasi", clickedItem.getLokasi());
        intent.putExtra("gambar", clickedItem.getImage());

        startActivity(intent);
    }


}
