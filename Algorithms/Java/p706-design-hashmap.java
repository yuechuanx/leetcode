class MyHashMap {

    final ListNode[] buckets = new ListNode[10000];
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if (buckets[i] == null) 
            buckets[i] = new ListNode(-1, -1);
        
        ListNode prev = find(buckets[i], key);
        // condition 1: prev point the last node of buckets[i]
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        // condition 2: if key exists, update the value;
        else prev.next.val = value;

        
    }
    

    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        if (buckets[i] == null) 
            return -1;
        ListNode node = find(buckets[i], key);
        return node.next == null ? -1 : node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null) return;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;     // important!!!
    }
    
    int idx(int key ) {
        return Integer.hashCode(key) % buckets.length;
    }
    
    ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        
        return prev;
    }
}


class ListNode {
    int key, val;
    ListNode next;
    
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */