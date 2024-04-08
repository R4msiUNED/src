package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.QueueIF;
import es.uned.lsi.eped.DataStructures.IteratorIF;

public class PlayBackQueue implements PlayBackQueueIF {

    private QueueIF<Integer> queue;

    public PlayBackQueue() {
        this.queue = new Queue<>();
    }

    @Override
    public void addTunes(ListIF<Integer> lT) {

        IteratorIF<Integer> it = lT.iterator();
        while (it.hasNext()) {
            int id = it.getNext(); 
            queue.enqueue(id);
        }
        
    }

    @Override
    public void clear() {
        this.queue.clear();
        
    }

    @Override
    public void extractFirstTune() {
        this.queue.dequeue();
        
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
        return  idList;//idList.isEmpty() ? null : idList;

    }

    @Override
    public int getFirstTune() {
        return this.queue.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

}
