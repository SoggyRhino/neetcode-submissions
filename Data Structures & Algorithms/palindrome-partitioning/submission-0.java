class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res =new ArrayList<>();
        rec(new ArrayList<>(), s, res );
        return res;
    }

    public void rec(List<String> found, String remaining, List<List<String>> results){
        if (remaining.isEmpty())
            results.add(found);
        
        for (int i = 1; i <= remaining.length(); i++){
            if (isPal(remaining.substring(0,i))){
                List<String> cur = new ArrayList<>(found);
                cur.add(remaining.substring(0,i));
                rec(cur,remaining.substring(i), results);
            }

        }

    }

    public boolean isPal(String s){
        int left = 0, right = s.length()-1;

        //System.out.printf("testing %s\n",s);
        while (left <= s.length() /2){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}
