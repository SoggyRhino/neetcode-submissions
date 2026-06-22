func longestPalindrome(s string) string {
	res, resLen := 0, 0

	for i := range len(s) {
		if start, l := pal(s, i, i+1); l > resLen {
			res, resLen = start, l
		}
		if start, l := pal(s, i-1, i+1); l + 1 > resLen {
			res, resLen = start, l + 1
		}
	}

	return s[res:res+resLen]
}


func pal(s string, l, r int) (int,int) {
	length := 0
	for l >= 0 && r < len(s) && s[l] == s[r] {
		length+=2
		l--;
		r++;
	}
	fmt.Print(l, r, length)
	fmt.Println()
	return l+1, length;
}
