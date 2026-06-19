func climbStairs(n int) int {
    steps := make(map[int]int)
	steps[n] = 1;
	steps[n+1] = 0;

	return rec2(0, n, steps)
}

func rec2(i int, n int, steps map[int]int) int {
	if s, ok := steps[i]; ok {
		return s
	}

	steps[i] = rec2(i +1, n, steps) + rec2(i + 2, n, steps)
	return steps[i];
}