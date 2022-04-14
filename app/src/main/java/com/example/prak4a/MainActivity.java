package com.example.prak4a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phoneNumber;
    private EditText websiteUri;
    private EditText locationUri;
    private EditText textShare;

    Button buttonWebsite;
    Button buttonLocation;
    Button buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.edtPhoneNumber);
        websiteUri = findViewById(R.id.edtWebUri);
        locationUri = findViewById(R.id.edtLocationUri);
        textShare = findViewById(R.id.edtShareText);

        buttonWebsite = findViewById(R.id.btnWebUri);
        buttonWebsite.setOnClickListener(this);
        buttonLocation = findViewById(R.id.btnLocationUri);
        buttonLocation.setOnClickListener(this);
        buttonText = findViewById(R.id.btnShareText);
        buttonText.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPhoneNumber:
                if (phoneNumber.getText().toString()==null || phoneNumber.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(), "Kolom Tidak Boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber.getText().toString()));
                    startActivity(dialPhone);
                }
                break;
            case R.id.btnWebUri:
                if (websiteUri.getText().toString()==null || websiteUri.getText().toString().trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Kolom Tidak Boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    String url = websiteUri.getText().toString();
                    if (!url.startsWith("http://") && !url.startsWith("http://")) {
                        url = "http://" + url;
                        Intent openWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(openWebsite);
                        break;
                    }
                }

            case R.id.btnLocationUri:
                if (locationUri.getText().toString()==null || locationUri.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(),"Kolom Tidak Boleh kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent openLocationuri = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + locationUri.getText().toString()));
                    startActivity(openLocationuri);
                    openLocationuri = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=" +
                                    locationUri.getText().toString()));
                    startActivity(openLocationuri);

                }
                break;
            case R.id.btnShareText:
                if (textShare.getText().toString()==null || textShare.getText().toString().trim().equals("")){
                    Toast.makeText(getBaseContext(),"Kolom Tidak Boleh kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    ShareCompat.IntentBuilder.from(this).setType("text/plan").setChooserTitle("Membuka : ").setText(textShare.getText().toString()).startChooser();
                }
                break;
        }
    }
}





