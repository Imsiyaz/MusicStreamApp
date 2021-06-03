package com.example.musicstreamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class PlaySongActivity extends AppCompatActivity {

    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private Button btnPlayPause = null;
    private SongCollection songCollection = new SongCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        btnPlayPause = findViewById(R.id.btnPlayPause);
        Bundle songData = this.getIntent().getExtras();

        currentIndex = songData.getInt("index");
        Log.d("temasek", "Retrieved position is: " + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);

    }


    public void displaySongBasedOnIndex(int selectedIndex)
        {
            Songs song = songCollection.getCurrentSong(selectedIndex);
            title = song.getTitle();
            artiste = song.getArtiste();
            fileLink = song.getFileLink();
            drawable = song.getDrawable();

            TextView txtTitle = findViewById(R.id.txtSongTitle);
            txtTitle.setText(title);

            TextView txtArtiste = findViewById(R.id.txtArtist);
            txtArtiste.setText(artiste);

            ImageView iCoverArt = findViewById(R.id.imgCoverArt);
            iCoverArt.setImageResource(drawable);

        }

    public void playSong(String songUrl)
    {
        try{
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            gracefullyStopWhenMusicEnds();

            btnPlayPause.setText("PAUSE");
            setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void playOrPauseMusic(View view)
    {
        if (player.isPlaying())
        {
            player.pause();
            btnPlayPause.setText("PLAY");
        }

        else
        {
            player.start();
            btnPlayPause.setText("PAUSE");
        }

    }

    private void gracefullyStopWhenMusicEnds()
    {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                Toast.makeText(getBaseContext(), "The song had ended and the onCompleteListener is activated\n" +
                "The button text is changed to 'PLAY'", Toast.LENGTH_LONG).show();
                btnPlayPause.setText("PLAY");
            }
        } ); }


}