class LRUCache {
    
    class ListNode{
        ListNode prev;
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> hm;
    int maxSize;
    
    public LRUCache(int capacity) {
     hm = new HashMap<>(capacity);
     this.maxSize = capacity;
     this.head = null;
     this.tail = null;
     
    }
    
    public int get(int key) {
        if( hm.containsKey(key) ) {
            int ans = hm.get(key).val;
            
            ListNode node =hm.get(key);
            removeNode(node);
            addFirst(node);

            return ans;
        }
        else 
            return -1;
            
    }
    
    public void put(int key, int value) {
        ListNode newNode = new ListNode(key, value);

        if( hm.containsKey(key) ) {
            ListNode node = hm.get( key );
            removeNode( node );
        }
        else if( hm.size() == maxSize ) {
                hm.remove(tail.key);
                removeNode( tail );
                
        }
        
        addFirst(newNode);
        hm.put( key, newNode );
    }



    //helper functions
    void addFirst(ListNode node) {
        node.prev = null;
        if( this.head == null ) {
            this.head = node;
            this.tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    void removeNode( ListNode node ) {
        
        if( head == tail ) {
            head = null;
            tail = null;
        }
        else if(node == head) {
            head = head.next;
            head.prev = null;
        }
        //if it is tail
        else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;

    }

    
}
