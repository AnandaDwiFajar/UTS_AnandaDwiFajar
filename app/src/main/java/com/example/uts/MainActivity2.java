package com.example.uts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nama_tempat = getIntent().getStringExtra("nama_tempat");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String lokasi = getIntent().getStringExtra("lokasi");
        int gambar = getIntent().getIntExtra("gambar", 0);

        TextView nameTextView = findViewById(R.id.namaTempat);
        TextView deskTextView = findViewById(R.id.deskripsi);
        TextView lokTextView = findViewById(R.id.lokasi);
        ImageView gambarImageView = findViewById(R.id.imageView2);
        Button kembaliButton = findViewById(R.id.kembali);

        nameTextView.setText(nama_tempat);
        deskTextView.setText(deskripsi);
        lokTextView.setText(lokasi);
        gambarImageView.setImageResource(gambar);

        Toast.makeText(this, "Anda sedang melihat detail " + nama_tempat + ".", Toast.LENGTH_SHORT).show();

        kembaliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
