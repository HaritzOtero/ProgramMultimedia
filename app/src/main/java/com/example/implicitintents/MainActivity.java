package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editLocation,editShare,editOpen;
    private Button btnLocation,btnShare,btnOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLocation = findViewById(R.id.editTextLocation);
        editOpen = findViewById(R.id.editTextWebsite);
        editShare = findViewById(R.id.editTextShare);
        btnLocation = findViewById(R.id.buttonLocation);
        btnOpen = findViewById(R.id.buttonOpen);
        btnShare = findViewById(R.id.buttonShare);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClick();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareClick();
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationClick();
            }
        });
    }

    public void openClick(){
        Uri link = Uri.parse(editOpen.getText().toString()) ;
        Intent i = new Intent(Intent.ACTION_VIEW,link);
        startActivity(i);
    }

    public void shareClick(){
        String txt = editShare.getText().toString();
        String mimeType = "text/plain";
        new ShareCompat.IntentBuilder(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_testua)
                .setText(txt)
                .startChooser();

    }

    public void locationClick(){
        String loc = editLocation.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(intent);

    }
}