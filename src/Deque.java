import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double sided queue where Items can be added and removed from both sides
 * @author ogbeoziomajnr@yahoo.com
 * @param <Item>  Any Java object to be added to the queue
 */
public class Deque<Item> implements Iterable<Item> {
   
   private  Node first; // the first node 
   private Node last; // the last node
   private int n = 0; // the size of the deque
    
   public Deque(){
    // Initialize the first and last node of the deque as null when the Deque is created
    first = null; 
    last  = null;
   }
   
   /**
    * Is the queue empty?
    * @return true for an empty queue and false for a non empty queue
    */
   public boolean isEmpty() {
    return n == 0; // the queue is empty when the size is 0
   }
   
   /**
    * Get the size of the queue
    * @return The size of the queue
    */
   public int size() {
       return n;
   }
   
   /**
    * Add an item to the front of the queue
    * @param item the item to be added to the front of the queue 
    */
   public void addFirst(Item item)  {
        // first make sure the item to be added is not null
        if (item == null) {
            throw new NullPointerException();
        }
        // ignore the boiler plate for now
        if (n == 0) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        last = first;
        n++;  
        }
        
        else {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        oldfirst.prev = first;
        n++;  
        }    
   }
   
   public void addLast(Item item) {
       // add the item to the end
       if (item == null) {
            throw new NullPointerException();
        }
        if (n == 0) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev = oldlast;
        first = last;
        n++;  
        }
        
        else {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev = oldlast;
        oldlast.next = last;
        n++;    
        }
   }
   
   public Item removeFirst() {
       // remove and return the item from the front
       if (isEmpty()) throw new NoSuchElementException();
       
       if (n == 1) {
        Item item = first.item;        // save item to return
        first = null;   // delete first node
        last = null;    // delete the last node
        n--;
        return item;
       }
     
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
       return item;
   }
   
   public Item removeLast() {
       // remove and return the item from the end
      if (isEmpty()) throw new NoSuchElementException();
       
       if (n == 1) {
        Item item = last.item;  // save item to return
        first = null;   // delete first node
        last = null;    // delete the last node
        n--;
        return item;
       }
     
        Item item = last.item;        // save item to return
        last = last.prev;            // delete first node
        n--;
       return item;
   }
   
   @Override
   public Iterator<Item> iterator() {
       // return an iterator over items in order from front to end
       return new DequeIterator();
   }
   public static void main(String[] args) {
           // unit testing
    }
   
    private class DequeIterator implements Iterator<Item> {

        Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
        if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
}
