class LRUCache {
    private ArrayList<int[]> map;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.map = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        for(int i=0;i<map.size();i++){
            if(map.get(i)[0] == key){
                int[] tmp = map.remove(i);
                map.add(tmp);
                return tmp[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i=0;i<map.size();i++){
            if(map.get(i)[0] == key){
                int[] tmp = map.remove(i);
                tmp[1] = value;
                map.add(tmp);
                return;
            }
        }

        if(capacity == map.size()){ map.remove(0); }
        map.add(new int[]{ key, value });
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */