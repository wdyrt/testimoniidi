package com.bd.testimoniidi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddReview extends AppCompatActivity {
    ImageView kembali;
    EditText nama, ulasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button submit;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_review);

        submit = findViewById(R.id.submit);
        kembali = findViewById(R.id.back_arrow);

        nama = (EditText) findViewById(R.id.text_box_nama);
        ulasan = (EditText) findViewById(R.id.text_box_ulasan);

        Intent i = new Intent();
        if (i.hasExtra("1234")){
            String judul = i.getExtras().getString("1234");
            nama.setText(judul);
            String deskripsi = i.getExtras().getString("123");
            ulasan.setText(deskripsi);
        }

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PageReview.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                v.getContext().startActivity(i);
            }
        });
    }
    public void submit(View v){
        String title = nama.getText().toString();
        String deskripsi = ulasan.getText().toString();
        Intent i = new Intent();
        i.putExtra("judul", title);
        i.putExtra("deskripsi", deskripsi);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}