package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
//        ConsoleHelper.writeMessage("calling processVideos method");
        final List<Advertisement> videos = AdvertisementStorage.getInstance().list();
        if(videos.isEmpty()) {
            throw new NoVideoAvailableException();
        } else {

        }
    }


}
