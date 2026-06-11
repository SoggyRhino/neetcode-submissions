class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String s: strs)
            result+= s.length() + "|" + s;  
        return result;

    }

    public List<String> decode(String str) {
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < str.length(); ) {
            String length = "";
            for (int j = i; i < str.length(); j++) {
                char c = str.charAt(i++);
                if (c >= '0' && c <= '9')
                    length += c;
                else
                    break;
            }

            int size = Integer.parseInt(length);
            results.add(str.substring(i, i + size));
            i += size;
        }
        return results;
    }
}
