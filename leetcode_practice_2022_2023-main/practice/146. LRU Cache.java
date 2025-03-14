class LRUCache {

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node){
        node.prev= head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveNode(DLinkedNode node){
        //we bring the recently used node to the front
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }

    private Map<Integer, DLinkedNode> cache;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = tail;
        this.tail.prev= head;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            DLinkedNode node = this.cache.get(key);
            moveNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if(this.cache.containsKey(key)){
            DLinkedNode node = this.cache.get(key);
            node.value = value;
            moveNode(node); // move the recently used node to the front
        }else{
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            //check capacity  
            int size = this.cache.size();
            if(size >= this.capacity){
                DLinkedNode deletedNode = popTail();
                this.cache.remove(deletedNode.key);
            }
            this.cache.put(key, newNode);
            addNode(newNode);
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */