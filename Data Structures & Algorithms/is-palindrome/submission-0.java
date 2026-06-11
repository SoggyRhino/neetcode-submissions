class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char ci = s.charAt(i);
            if ((!((ci >= 'A' && ci <= 'Z') || (ci >= 'a' && ci <= 'z') || (ci >= '0'
                    && ci <= '9')))) {
                i++;
                continue;
            }
            char cj = s.charAt(j);
            if ((!((cj >= 'A' && cj <= 'Z') || (cj >= 'a' && cj <= 'z') || (cj >= '0'
                    && cj <= '9')))) {
                j--;
                continue;
            }

            if (ci >= 'A' && ci <= 'Z')
                ci+= 32;
            if (cj >= 'A' && cj <= 'Z') {
                cj+= 32;
            }
            
            System.out.println('A' -'a');
            if (ci != cj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}
