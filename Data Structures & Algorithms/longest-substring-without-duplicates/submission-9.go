func lengthOfLongestSubstring(s string) int {
	set := make([]bool, 128, 128)

	start, end := 0, 0
	long := 0
	for ; start <= end && end < len(s); end++{
		if !set[s[end]] {
			set[s[end]] = true
			long = max(long, end - start + 1)
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
