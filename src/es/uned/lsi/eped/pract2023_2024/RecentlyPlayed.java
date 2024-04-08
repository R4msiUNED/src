package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.QueueIF;
import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;

public class RecentlyPlayed implements RecentlyPlayedIF {

    private QueueIF<Integer> queue;
    private int maxRecentlyPlayed;

    public RecentlyPlayed(int maxRecentlyPlayed) {
        this.queue = new Queue<>();
        this.maxRecentlyPlayed=maxRecentlyPlayed;
    }

    @Override
    public void addTune(int tuneID) {
        queue.enqueue(tuneID);
        if (queue.size()>maxRecentlyPlayed) {
            queue.dequeue();
        }
        
    }

    @Override
    public ListIF<Integer> getContent() {

        ListIF<Integer> idList = new List<>();
        IteratorIF<Integer> it = queue.iterator();
        int index = 1;
        while (it.hasNext()) {

            Integer id = it.getNext();
            idList.insert(index,id);
            index++;
            
        }
        return  sortList(idList);//idList.isEmpty() ? null : idList;

    }

    private ListIF<Integer> sortList(ListIF<Integer> l) {
        if(l.size()<=1) {return l;}
        ListIF<Integer> oppoList = new List<>();
        int index = 1;
        for (int i=l.size();i>=1;i--) {
            oppoList.insert(index, l.get(i));
            index++;
        }
        return oppoList;
    }
    

}
