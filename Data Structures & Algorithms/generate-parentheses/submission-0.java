class Solution {
    public List<String> generateParenthesis(int n) {
        var list = new ArrayList<String>();
        rec("", n, 0, 0, list);
        return list;
    }

    public void rec(String current, int n, int open, int close, List<String> list){
        if (current.length() == 2 * n){
            list.add(current);
            return;
        }

        if (open <= n - 1){
            rec(current +"(", n, open + 1, close, list);
        }

        if (open > close){
            rec(current + ")", n, open, close + 1, list);
        }
    }
}
