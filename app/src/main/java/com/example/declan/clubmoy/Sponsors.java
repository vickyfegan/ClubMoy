package com.example.declan.clubmoy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Sponsors extends AppCompatActivity {

    ImageView macavoySponsor, seanSponsor, moymSponsor, moyaSponsor, lynasSponsor, westlandSponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        macavoySponsor = (ImageView)findViewById(R.id.macavoySponsor);
        seanSponsor = (ImageView)findViewById(R.id.seanSponsor);
        moymSponsor = (ImageView)findViewById(R.id.moymSponsor);
        moyaSponsor = (ImageView)findViewById(R.id.moyaSponsor);
        lynasSponsor = (ImageView)findViewById(R.id.lynasSponsor);
        westlandSponsor = (ImageView)findViewById(R.id.westlandSponsor);

        macavoySponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.mcavoygroup.com"));
                startActivity(intent);
            }
        });

        seanSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://seancavanaghandco.com"));
                startActivity(intent);
            }
        });

        moymSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.moywaymotors.co.uk"));
                startActivity(intent);
            }
        });

        moyaSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.moyautoservices.com"));
                startActivity(intent);
            }
        });

        lynasSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://lynasfoodservice.com"));
                startActivity(intent);
            }
        });

        westlandSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.gardenhealth.com"));
                startActivity(intent);
            }
        });




    }
}

