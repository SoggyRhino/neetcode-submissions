func numDecodings(s string) int {
    cache := map[int]int{len(s):1}

	return rec(s, 0, cache)
}

func rec(s string, i int, cache map[int]int) int{
	if c, ok := cache[i]; ok {
		return c;
	}

	if s[i] == '0' {
        return 0
    }

	res := rec(s, i + 1, cache)
	if i + 1 < len(s) {
		if s[i] == '1' || (s[i] == '2' && s[i+1] < '7') {
			res += rec(s, i + 2, cache)
		}
	}
	cache[i] = res
	return cache[i]
}


