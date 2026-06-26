class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;

        }
    }

    Node head;
    Node tail;
    Map<Integer, Node> hm;
    int curSize;
    int maxSize;

    public LRUCache(int capacity) {
        maxSize = capacity;
        hm = new HashMap<>();
        head =  new Node(0,0);
        tail =  new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if( !hm.containsKey(key) ) {
            return -1;
        }

        Node node  = hm.get(key);
        remove(node);
        addFirst(node);
        return node.val; 
    }
    
    public void put(int key, int value) {
        if( hm.containsKey(key) ) {
            Node node = hm.get( key );
            node.val  = value;
            hm.put(key, node);

            remove(node);
            addFirst(node);
        }
        else {
            Node node = new Node(key, value);
            //if cache at max capacity?
            if( curSize == maxSize ) {

                hm.remove( tail.prev.key );
                
                remove( tail.prev );
                addFirst( node );
                
                hm.put(key, node);
            }
            else{
                hm.put(key, node);
                curSize++;
                addFirst(node);
            }
        }
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;

        node.prev = null;
        node.next = null;

    }

    public void addFirst( Node newNode ) {
        

        Node next = head.next;
        
        head.next = newNode;
        newNode.prev = head;

        newNode.next = next;
        next.prev = newNode;
    }
}
