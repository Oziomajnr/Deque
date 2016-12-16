import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double sided queue where Items can be added and removed from both sides
 * This is a linked list implementation, each item is represented as a node object.
 * Each node holds a reference to two other nodes which are the previous and next nodes
 * If there is no previous or next node then the reference is null.
 * This data structure supports iterators but does not currently support nested iterators
 * Suggestions on improving this data structure should be sent to the author with the email address below 
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
    * @param item The item to be added to the front of the queue 
    */
   public void addFirst(Item item)  {
        // first make sure the item to be added is not null
         if (item == null) {
            throw new NullPointerException();
        }
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (n == 0) {
        last = first;
        n++;  
        }
        else {
        oldfirst.prev = first;
        n++;  
        } 
   }
   
   /**
    * Add item to the back of the queue
    * @param item The item to be added to the back of the queue
    */
   public void addLast(Item item) {
       // add the item to the end
       if (item == null) {
            throw new NullPointerException();
        }
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev = oldlast;
        if (n == 0) {
        first = last;
        n++;  
        }
        else {
        oldlast.next = last;
        n++;    
        }
   }
   
   /**
    * Remove an item from the front of the queue
    * @return The item to be removed from the front of the queue
    */
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
   /**
    * Remove an item from the back of the queue
    * @return The item to be removed 
    */
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
   
   /**
    * Create an iterator  iterate through all the 
    * @return An iterator for iterating through all the items
    */
   @Override
   public Iterator<Item> iterator() {
       // return an iterator over items in order from front to end
       return new DequeIterator();
   }
   
   /**
    * Created for unit testing  of the class
    * @param args command line argument
    */
   public static void main(String[] args) {
           // unit testing
    }
   
   /**
    * The iterator class 
    */
    private class DequeIterator implements Iterator<Item> {

        Node current = first;
        /**
         * Does the queue still have any item to return?
         * @return true if there is an item to return and false of there is no more item in the queue
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Return the next item in the queue if the queue has a next item
         * @return The next item in the queue
         */
        @Override
        public Item next() {
        if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
        
        /**
         * Unsupported, this operation is not supported 
         * @throws UnsupportedOperationException 
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * The class that defines a node in the liked list
     */
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
}
