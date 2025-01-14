class TimeMap {
    private Map<String, TreeMap<Integer, String>> m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)){ return ""; }

        TreeMap<Integer, String> currMap =  m.get(key);
        Map.Entry<Integer, String> entry = currMap.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */