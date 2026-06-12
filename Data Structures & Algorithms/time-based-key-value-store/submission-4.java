class TimeMap {

    private final Map<String, List<Integer>> times = new HashMap<>();
    private final Map<String, List<String>> emotions = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        times.compute(key, (k,v) -> {
            v = v == null ? new ArrayList<>() : v;
            v.add(timestamp);
            return v;
        });

        emotions.compute(key, (k,v) -> {
            v = v == null ? new ArrayList<>() : v;
            v.add(value);
            return v;
        });
    }
    
    public String get(String key, int timestamp) {
        var list = times.get(key);
        if (list == null) return "";

        //if (list.size() ==1) return this.emotions.get(key).get(0);

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
