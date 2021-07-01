package com.google;

import java.util.ArrayList;
import java.util.HashMap;

/** A class used to represent a Playlist */
class VideoPlaylist implements Comparable<VideoPlaylist>{
    private final String listName;
    private HashMap<String, Video> addedVid;

    VideoPlaylist(String listName){
        this.listName=listName;
    }
    String getTitle() {
        return listName;
    }
    void addVid(String videoId,Video video){
        addedVid.put(videoId, video);
    }
    void getVideos() {
        ArrayList<Video> currentVids = new ArrayList<Video>(addedVid.values());
        System.out.println("Showing playlist:");
        for (Video video : currentVids) {
            System.out.printf("%s (%s) [", video.getTitle(), video.getVideoId());
            for (int i = 0; i < video.getTags().size(); i++) {
                System.out.printf("%s", video.getTags().get(i));
                if ((i + 1) < video.getTags().size()) System.out.printf(" ");
            }
            System.out.printf("] \n");
        }
    }

    Video getVideo(String videoId) {return addedVid.get(videoId);}
    void clear(){addedVid.clear();}
    @Override
    public int compareTo(VideoPlaylist o){
        if(listName.compareTo(o.getTitle())<0) return -1;
        else if(listName.compareTo(o.getTitle())>0)return 1;
        else return 0;
    }

}
