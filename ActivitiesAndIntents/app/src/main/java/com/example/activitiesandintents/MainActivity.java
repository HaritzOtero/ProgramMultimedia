package com.example.activitiesandintents;

import static android.telephony.SmsManager.RESULT_CANCELLED;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = ;
    private EditText MessageEditText;
    public static final int TEXT_REQUEST=1;
    private TextView ReplyHeadTextView;
    private TextView ReplytextView;
    public Button btnSend;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnSend = findViewById(R.id.btnSend);

    }

    ActivityResultLauncher<Intent> startForResoult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

        @Override
        public void onActivityResult(ActivityResult result) {
            if(result!=null && result.getResultCode()==RESULT_OK){
                if(result.getData()!=null && result.getData().getStringExtra(SecondActivity.EXTRA_REPLY)!=null){
                    String reply = result.getData().getStringExtra(SecondActivity.EXTRA_REPLY);
                    ReplyHeadTextView.setVisibility(View.VISIBLE);
                    ReplytextView.setText(reply);
                    ReplytextView.setVisibility(View.VISIBLE);
                }
                if(result!=null && result.getResultCode()==RESULT_CANCELLED){
                    Log.d(LOG_TAG, "Bigarren Ativity-a canceleld.");
                }
            }
        }

    }



}