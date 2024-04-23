package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.IteratorIF;

public class PlayListManager implements PlayListManagerIF {

    private class InnerPlayListManager {
        
        private String playListId;
        private PlayListIF playList;

        private InnerPlayListManager(String playListId, PlayListIF playList) {
            this.playListId = playListId;
            this.playList = playList;
        }
        
    };

    private ListIF<InnerPlayListManager> playListCollection;
    

    public PlayListManager() {
        playListCollection = new List<>();
    }

    @Override
    public boolean contains(String playListID) {
        IteratorIF<InnerPlayListManager> it = playListCollection.iterator();
        boolean found = false;
        while (it.hasNext() && !found) {
            found = playListID.equals(it.getNext().playListId);
        }
        return found;
    }

    @Override
    public void createPlayList(String playListID) {
        PlayListIF playList = new PlayList();
        InnerPlayListManager newPlayList = new InnerPlayListManager(playListID,playList);
        if (!contains(playListID)) {
            playListCollection.insert(playListCollection.size()+1, newPlayList);
        }
        
    }

    @Override
    public ListIF<String> getIDs() {

        ListIF<String> stringList = new List<>();
        IteratorIF<InnerPlayListManager> it = playListCollection.iterator();
        int i =1;
        while (it.hasNext()) {
            stringList.insert(i, it.getNext().playListId);
            i++;
        }      
        return stringList;
    }

    @Override
    public PlayListIF getPlayList(String playListID) {
        IteratorIF<InnerPlayListManager> it = playListCollection.iterator();
        
        while (it.hasNext()) {
            InnerPlayListManager current = it.getNext(); // Almacenar el elemento actual en una variable temporal.
            if (playListID.equals(current.playListId)) {
                return current.playList; // Devolver inmediatamente si se encuentra una coincidencia.
            }
        }
    
        return new PlayList();  // Devolver lista vacia si no se encuentra ninguna coincidencia.
    }
    

    @Override
    public void removePlayList(String playListID) {
        /* 
        for (int i = 1; i <=playListCollection.size(); i++) {
            if (playListCollection.get(i).playListId.equals(playListID)) {
                playListCollection.remove(i);
                break;
            }
        }
        */
        IteratorIF<InnerPlayListManager> it = playListCollection.iterator();
        int index = 1;
        boolean found = false;
        while (it.hasNext() && !found) {
            InnerPlayListManager current = it.getNext(); 
            if (playListID.equals(current.playListId)) {
                playListCollection.remove(index);
                found=true; // No hay repeticiones
            }
            index++;
        }
        
    }

}
