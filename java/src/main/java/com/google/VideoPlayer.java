package com.google;

import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  private final List<Video> Videos;

  private ArrayList<VideoPlaylist> Playlists = new ArrayList<>();

  private boolean playingVideo = false;
  private Video curVid;
  private boolean paused = false;



  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    Videos = videoLibrary.getVideos();
    Collections.sort(Videos);
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    for (Video video : Videos) {
      System.out.printf("%s (%s) [", video.getTitle(), video.getVideoId());
      for (int i=0; i<video.getTags().size();i++){
        System.out.printf("%s",video.getTags().get(i));
        if((i+1)<video.getTags().size()) System.out.printf(" ");
      }
      System.out.printf("] \n");
    }
  }

  public void playVideo(String videoId) {
    if (videoLibrary.getVideo(videoId)!=null) {
      if(playingVideo){
        System.out.println("Stopping video: "+ curVid.getTitle());
        playingVideo = false;
      }
      curVid = videoLibrary.getVideo(videoId);
      System.out.println("Playing video: " + curVid.getTitle());
      paused = false;
      playingVideo = true;

    }
    else System.out.println("Cannot play video: Video does not exist");


  }

  public void stopVideo() {
    if(playingVideo){
      System.out.println("Stopping video: "+ curVid.getTitle());
      playingVideo = false;
    }
    else System.out.println("Cannot stop video: No video is currently playing");
  }

  public void playRandomVideo() {
    Random rand = new Random();
    int n = rand.nextInt(videoLibrary.getVideos().size());
    this.playVideo(videoLibrary.getVideos().get(n).getVideoId());
  }

  public void pauseVideo() {
    if(!playingVideo)System.out.println("Cannot pause video: No video is currently playing");
    else if(!paused){
      System.out.println("Pausing video: "+ curVid.getTitle());
      paused = true;
    }
    else System.out.println("Video already paused: "+curVid.getTitle());
  }

  public void continueVideo() {
    if (!playingVideo) System.out.println("Cannot continue video: No video is currently playing");
    else if(paused) {
      System.out.println("Continuing video: "+curVid.getTitle());
    }
    else System.out.println("Cannot continue video: Video is not paused");
  }

  public void showPlaying() {
    if(!playingVideo){
      System.out.println("No video is currently playing");
    }
    else{
      System.out.printf("Currently playing: %s (%s) [", curVid.getTitle(), curVid.getVideoId());
      for (int i=0; i<curVid.getTags().size();i++){
        System.out.printf("%s",curVid.getTags().get(i));
        if((i+1)<curVid.getTags().size()) System.out.printf(" ");
      }
      System.out.printf("]");
      if(paused) System.out.printf(" - PAUSED");
      System.out.println("\n");
    }

  }

  public void createPlaylist(String playlistName) {
    if (playlistName.contains(" ")) {
      System.out.println("Invalid playlist name, it must not contain spaces");
    }
    boolean nameCheck = true;
    for(int i=0;i<Playlists.size();i++) {
      if(Playlists.get(i).getTitle().equalsIgnoreCase(playlistName)){
        System.out.println("Cannot create playlist: A playlist with the same name already exists");
        nameCheck = false;
        break;
      }
    }
    if (nameCheck){
      Playlists.add(new VideoPlaylist(playlistName));
      System.out.println("Successfully created new playlist: "+playlistName);
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    if(Playlists.size() == 0){
      System.out.println("No playlists exist yet");
    }
    else{
      int i = 0;

      for (VideoPlaylist check : Playlists) {
        if(check.getTitle().equals(playlistName)) break;
        else System.out.println("Cannot add video to another_playlist: Playlist does not exist");;
      }
      for(Video video : Videos){
        if(video.getVideoId().equals(videoId)){

        }
      }
    }
  }

  public void showAllPlaylists() {
    if(Playlists.size() == 0){
      System.out.println("No playlists exist yet");
    }
    else {
      System.out.println("Showing all playlists:");
      Collections.sort(Playlists);
      for (VideoPlaylist show : Playlists) {
        System.out.println(show.getTitle());
      }
    }
  }

  public void showPlaylist(String playlistName) {
    boolean videos = false;
    for (VideoPlaylist check : Playlists){
      if(check.equals(playlistName)){
        check.getVideos();
        videos = true;
        break;
      }
    }
    if(!videos){
      System.out.println("Showing playlist: "+playlistName);
      System.out.println("No videos here yet");
    }
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    for (VideoPlaylist check : Playlists) {
      if(check.getTitle().equals(playlistName)) check.clear();
      else System.out.println("Cannot clear playlist "+check.getTitle()+ ": Playlist does not exist");
    }
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}