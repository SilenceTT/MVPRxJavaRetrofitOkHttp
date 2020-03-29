package com.example.slience.mvprxjavaretrofitokhttp.mvpbase;

import android.os.Parcelable;

/**
 * Created by PeiShanqing on 2020/3/27 21:08.
 */
public class BasicResponseBean  {

    String xcode;

    String songList;

    @Override
    public String toString() {
        return "BasicResponseBean{" +
                "xcode='" + xcode + '\'' +
                ", songList='" + songList + '\'' +
                '}';
    }

    public String getXcode() {
        return xcode;
    }

    public void setXcode(String xcode) {
        this.xcode = xcode;
    }

    public String getSongList() {
        return songList;
    }

    public void setSongList(String songList) {
        this.songList = songList;
    }
}
