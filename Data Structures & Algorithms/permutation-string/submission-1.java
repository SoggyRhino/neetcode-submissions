class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();


        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);

        
        
        for (int j =0; j <= s2.length()-s1.length(); j++){
            Map<Character, Integer> map2 = new HashMap<>();
            
            for (int k = 0; k < s1.length(); k++){
                map2.put(s2.charAt(j + k), map2.getOrDefault(s2.charAt(j + k),0)+1);
            }

            System.out.println(map);
            System.out.println(map2);
                        System.out.println();


            if (map.equals(map2))
                return true;


        }




        return false;
    }
}
