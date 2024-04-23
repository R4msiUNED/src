package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.IteratorIF;

public class PlayList implements PlayListIF {

    private ListIF<Integer> playList;

    public PlayList() {
        playList = new List<>();
    }

    @Override
    public void addListOfTunes(ListIF<Integer> lT) {
        
        int start = playList.size()+1; 

        IteratorIF<Integer> it = lT.iterator();
        while (it.hasNext()) 
        {
            playList.insert(start, it.getNext());
            start++;
        }
        
    }

    @Override
    public ListIF<Integer> getPlayList() {
        return playList;
    }

    @Override
    /* 
    public void removeTune(int tuneID) {
        // utilizaría iterator ya que el size puede cambiar con remove.
        int value;
        System.out.println(playList.size());
        for (int i = 1; i<=playList.size(); i++) {
            System.out.println(i);
            value=playList.get(i);
            if(value==tuneID){
                playList.remove(i);
            }
        }
        
        
    }*/

public void removeTune(int tuneID) {
    // Itera de atrás hacia adelante para evitar problemas al remover elementos.
    /* 
    for (int i = playList.size(); i >= 1; i--) {
        if (playList.get(i) == tuneID) {
            playList.remove(i);
        }
    }
    */
    IteratorIF<Integer> it = playList.iterator();
    int index = 1;
    while (it.hasNext()) {
        Integer current = it.getNext(); 
        if (current==tuneID) {
            playList.remove(index);
        } else {
            index++;
        }
    }
}

     

}
