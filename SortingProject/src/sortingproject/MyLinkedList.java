package sortingproject;

/**
 * @version Final
 * @author Kollen Gruizenga and Travis Wahl
 * 
 * this class creates LinkedList object containing a list of int's
 */
class MyLinkedList {

    public Node head;
    
    /**
     * creates an empty list
     */
    public MyLinkedList(){
        head = null;
    }
    
    /**
     * Adds value to the start of the list
     * @param value 
     */
    public void add(int value) {
        if (head == null){
            head = new Node(value);
        } else {
            Node newNode = new Node(value, head);
            head = newNode;
        }
    }
    
    public void addAfter(int value, int index){
        Node cur = head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        Node newNode = new Node(value, cur.next);
        cur.next = newNode;
    }
    
    /**
     * removes the first occurrence of item from the list.
     * @param item 
     */
    public void remove(int item){
        Node current = head;
        if(head == null) return;
        if(head.value == item) head = head.next;
        while (current.next != null && current.next.value != item){
            current = current.next;
        }
        if(current.next == null) return;
        current.next = current.next.next;
    }

    /**
     * Removes the first value in the list
     */
    public void remove(){
        if(head != null) head = head.next;
    }
    
    /**
     * Empties the list
     */
    public void empty(){
        head = null;
    }
    
    /**
     * Returns the location of the first occurrence of the value in the list.
     * Returns 0 if it is the first item.
     * @param value 
     */
    public int indexOf(int value){
        int index = 0;
        Node current = head;
        
        while (current.next != null && current.next.value != value){
            current = current.next;
            index++;
        }
        if(current.next == null) return index;
        return index++;
    }
    
    public int getValue(int index) {
        Node current = head;
        int value = -1;
        for (int i=0; i<= index; i++) {
            if (i == index) {
                value = current.value;
            }
            current = current.next;
        }
        return value;
    }
    
    public void swap(int a, int b) {
        Node aNode = head;
        Node bNode = head;
        for (int i = 0; i < a; i++) {
            aNode = aNode.next;
        }
        for (int i = 0; i < b; i++) {
            bNode = bNode.next;
        }
        int temp = aNode.value;
        aNode.value = bNode.value;
        bNode.value = temp;
    }
        
     /**
     * This is the method called when a MyLinkList is passed to System.out
     * It determines what is printed
     * @return 
     */
    @Override
    public String toString(){
        String toPrint = "[ ";
        Node cur = head;
        while(cur != null){
            toPrint += cur.value + " ";
            cur = cur.next;
        }
        toPrint += "]";
        return toPrint;
    }
    
    /**
     * This is a Node class to be used in your linked list.
     */
    public static class Node {
        public Node next;
        public int value;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
        public Node(int value, Node next){
            this.next = next;
            this.value = value;
        } 
    }
    
}
