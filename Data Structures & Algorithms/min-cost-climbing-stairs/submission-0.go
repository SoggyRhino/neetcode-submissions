func minCostClimbingStairs(cost []int) int {
	cache :=  make(map[int]int)
    return min(rec(0, cost, cache), rec(1, cost, cache))
}

func rec(i int, cost []int, cache map[int]int) int {
	if c, ok := cache[i]; ok {
		return c;
	}

	if i >= len(cost) {
		return 0;
	}
	
	cache[i] = cost[i] + min(rec(i +1, cost, cache), rec(i +2, cost, cache))
	return cache[i]
}

func min(a,b int) int {
	if a < b {
		return a
	}
	return b
}
