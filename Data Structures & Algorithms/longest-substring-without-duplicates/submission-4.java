class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        Set<Character> set = new HashSet<>();

        int l = 0, r = 1;
        int max = 1;
        set.add(s.charAt(l));

        while (r < s.length()) {
            if (!set.add(s.charAt(r))) {
                max = Math.max(max, set.size());
                if (s.charAt(l) != s.charAt(r)) {
                    l = r;
                    set.clear();
                    set.add(s.charAt(l));
                }
                else {
                    l++;
                }
            }
            r++;

        }
        return Math.max(max, set.size());
        
    }
}
