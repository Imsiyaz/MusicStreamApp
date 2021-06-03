package com.example.musicstreamapp;

import android.content.Intent;

public class SongCollection
{
    private Songs songs[] = new Songs[3];

    public SongCollection()
    {
        Songs theWayYouLookTonight = new Songs("S1001",
                "1. The Way You Look Tonight",
                "Michael Bible",
                "https://p.scdn.co/mp3-preview/a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                4.66, R.drawable.michael_buble_collection);

        Songs billieJean = new Songs("S1002",
                "Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/14a1ddedf05a15ad0ac11ce28b40ea1a15fabd20?cid=2afe87a64b0042dabf51f37318616965",
                4.9,R.drawable.billie_jean);

        Songs one = new Songs("S1003",
                "One",
                "Ed Sheeran",
                "https://p.scdn.co/mp3-preview/daa8679253ba20620db6e1db9c88edfcf1f4069f?cid=2afe87a64b0042dabf51f37318616965",
                4.21,R.drawable.photograph);


        songs[0] = theWayYouLookTonight;
        songs[1] = billieJean;
        songs[2] = one;

    }

    public int searchSongById(String id)
    {
        for(int index=0; index < songs.length; index++)
        {
            Songs tempSongs = songs[index];
            if (tempSongs.getId().equals(id));

            return index;
        }
        return -1;
    }


}
