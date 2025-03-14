class LRUCache {

    // the logic is: whenever a key is used, move the node that key represents to the front; the one at the end is the one that is least recent used
    private Map<Integer, DLinkedNode> map;
    private int capacity;
    private DLinkedNode head, tail;

    class DLinkedNode{
        public int key;
        public int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node){
        //add right after the head
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode node = this.tail.prev;
        this.removeNode(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);

        if(node == null) return -1;

        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        //check if the key exists
        DLinkedNode node = map.get(key);

        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            map.put(key, newNode);

            this.addNode(newNode);

            if(this.map.size() > this.capacity){
                DLinkedNode deletedNode = this.popTail();
                this.map.remove(deletedNode.key);
            }
        }else{
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */