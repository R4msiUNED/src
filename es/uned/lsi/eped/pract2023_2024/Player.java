package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Player implements PlayerIF{

    private TuneCollectionIF tuneCollection;
    private PlayListManagerIF playListManager;
    private PlayBackQueueIF playBackQueue;
    private RecentlyPlayedIF recentlyPlayed;

    public Player(TuneCollection tuneCollection, int maxRecentlyPlayed) {
        this.tuneCollection = tuneCollection;
        this.playListManager = new PlayListManager();
        this.playBackQueue = new PlayBackQueue();
        this.recentlyPlayed = new RecentlyPlayed(maxRecentlyPlayed);
    }

    @Override
    public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
        playBackQueue.addTunes(lT);
        
    }

    @Override
    public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT) {
        playListManager.getPlayList(playListID).addListOfTunes(lT);
        
    }

    @Override
    public void addPlayListToPlayBackQueue(String playListID) {
        playBackQueue.addTunes(playListManager.getPlayList(playListID).getPlayList());;
        
    }

    @Override
    public void addSearchToPlayBackQueue(String t, String a, String g, String al, int min_y, int max_y, int min_d,
            int max_d) {

        playBackQueue.addTunes(query(t, a, g, al, min_y, max_y, min_d, max_d));
        
    }

    @Override
    public void addSearchToPlayList(String playListID, String t, String a, String g, String al, int min_y, int max_y,
            int min_d, int max_d) {
        playListManager.getPlayList(playListID).addListOfTunes(query(t, a, g, al, min_y, max_y, min_d, max_d)); 
        
    }

    private ListIF<Integer> query(String t, String a, String g, String al, int min_y, int max_y,
    int min_d, int max_d) {
        QueryIF q = new Query(t, a, g, al, min_y, max_y, min_d, max_d);
        /* 
        System.out.println(q.getGenre());
        System.out.println(tuneCollection.getTune(0).match(q));
        System.out.println(tuneCollection.size());
        System.out.println(tuneCollection.getTune(18));
        */
        ListIF<Integer> tunesToAdd = new List<>();
        for (int id = 0; id<tuneCollection.size(); id++) {
            TuneIF tune = tuneCollection.getTune(id);
            if (tune.match(q)) {
                tunesToAdd.insert(tunesToAdd.size()+1, id);
            }
        }
        return tunesToAdd;
    }

    @Override
    public void clearPlayBackQueue() {
        playBackQueue.clear();
    }

    @Override
    public void createPlayList(String playListID) {
        playListManager.createPlayList(playListID);
        
    }

    @Override
    public ListIF<Integer> getPlayBackQueue() {
        return playBackQueue.getContent();
    }

    @Override
    public ListIF<Integer> getPlayListContent(String playListID) {
        return playListManager.getPlayList(playListID).getPlayList();
    }

    @Override
    public ListIF<String> getPlayListIDs() {
        return playListManager.getIDs();
    }

    @Override
    public ListIF<Integer> getRecentlyPlayed() {
        return recentlyPlayed.getContent();
    }

    @Override
    public void play() {
        if(!playBackQueue.isEmpty()) {
            recentlyPlayed.addTune( playBackQueue.getFirstTune() );
            playBackQueue.extractFirstTune();
        }
        
    }

    @Override
    public void removePlayList(String playListID) {
        playListManager.removePlayList(playListID);
        
    }

    @Override
    public void removeTuneFromPlayList(String playListID, int tuneID) {
        playListManager.getPlayList(playListID).removeTune(tuneID);
        
    }

}
