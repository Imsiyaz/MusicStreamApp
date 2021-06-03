package com.example.musicstreamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    SongCollection songCollection = new SongCollection();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendDataToActivity(int index){
        Intent intent = new Intent(this, PlaySongActivity.class);
        intent.putExtra( "index", index);
        startActivity(intent);
    }

    public void handleSelection(View myView)
    {
        String resourceId = getResources().getResourceEntryName(myView.getId());//gets id of image button
        int currentArrayIndex = songCollection.searchSongById(resourceId);//gets array index from SongCollection
        Log.d("Temasek" , "The id of the pressed ImageButton is : " + resourceId);
        Log.e( "Temasek",resourceId);
    }


}