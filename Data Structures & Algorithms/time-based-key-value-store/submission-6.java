class TimeMap {

    private final Map<String, List<Integer>> times = new HashMap<>();
    private final Map<String, List<String>> emotions = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        times.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        emotions.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        var list = times.get(key);
        if (list == null) return "";

        int low = 0, high = list.size()-1;
        String res = "";
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (list.get(mid) <= timestamp) {
                res = emotions.get(key).get(mid);
                low = mid + 1;
            } else {
                high = mid-1;
            } 
        }

        return res;
    }

}
