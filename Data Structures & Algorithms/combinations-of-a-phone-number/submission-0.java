class Solution {

    public static final Map<Integer, List<String>> digitMap = Map.ofEntries(
        Map.entry(2,List.of("a","b","c")),
        Map.entry(3,List.of("d","e","f")),
        Map.entry(4,List.of("g","h","i")),
        Map.entry(5,List.of("j","k","l")),
        Map.entry(6,List.of("m","n","o")),
        Map.entry(7,List.of("p","q","r","s")),
        Map.entry(8,List.of("t","u","v")),
        Map.entry(9,List.of("w","x","y","z"))
        );



    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if (digits.isEmpty())
            return list;

        rec(digits, "", 0, list);
        return list;
    }

    public void rec(String digits, String cur, int i, List<String> res){
        if (i == digits.length()){
            res.add(cur);
            return;
        }

        int d = digits.charAt(i) - '0';

        for (String s: digitMap.get(d)){
            rec(digits, cur + s, i +1, res);
        }

    }
}
