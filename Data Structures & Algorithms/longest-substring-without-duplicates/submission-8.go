func lengthOfLongestSubstring(s string) int {
	if len(s) <= 1 {
		return len(s)
	}

	set := make(map[byte]bool)

	start, end := 0, 0
	long := 0
	for ; start <= end && end < len(s); end++{
		if !set[s[end]] {
			set[s[end]] = true
			long = max(long, end - start + 1)
			fmt.Println(s[start:end+1])
		} else {
			for start < end {
				if s[start] == s[end] {
					start++;
					break
				} else {
					set[s[start]] = false;
					start++;
				}
			}
			fmt.Println("\t", s[start:end+1])
		}
	}

	return long
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
