package com.bd.testimoniidi;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bd.testimoniidi.Adapter.AdapterReview;
import com.bd.testimoniidi.model.RecyclerData;

import java.util.ArrayList;

public class PageReview extends AppCompatActivity {
    ArrayList<RecyclerData> ulasan;
    AdapterReview adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_review);

        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Dashboard.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        ulasan = new ArrayList<RecyclerData>();
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        adapter = new AdapterReview(ulasan);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.tambah_ulasan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddReview.class);
                startActivityForResult(i, getResources().getInteger(R.integer.INTENT_TAMBAH));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == getResources().getInteger(R.integer.INTENT_TAMBAH)){
            if (resultCode == Activity.RESULT_OK){
                RecyclerData item = new RecyclerData();
                item.setNama(data.getStringExtra("judul"));
                item.setUlasan(data.getStringExtra("deskripsi"));
                ulasan.add(item);
                adapter.notifyDataSetChanged();
            }
        }
    }
}