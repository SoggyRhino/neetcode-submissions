class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,Integer> map = new HashMap<>();
        List<List<String>> strings = new ArrayList<>();


        for (String s: strs){
            int[] array = new int[26];

            for (int i = 0; i < s.length(); i++)
                array[s.charAt(i)- 'a']++;

            String key = "";

            for (int i : array)
                key += String.format("%03d",i);

            if (map.containsKey(key)){
                int i = map.get(key);
                strings.get(i).add(s);
            } else {
                map.put(key, strings.size());
                List<String> list = new ArrayList<>();
                list.add(s);
                strings.add(list);
            }

        }

        return strings;
    }
}
