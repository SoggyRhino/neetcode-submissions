func rob(nums []int) int {
	cache := make(map[int]int)
	cache[len(nums)] = 0;
	cache[len(nums) +1] = 0;

	c1 := nums[0] + rec(2, nums, cache, true)
	
	
	cache = make(map[int]int)
	cache[len(nums)] = 0;
	cache[len(nums) +1] = 0;
	
	c2 := rec(1, nums, cache, false)

	return max(c1,c2)

}

func rec(i int, nums []int, cache map[int]int, first bool) int {
	if c, ok := cache[i];  ok {
		return c
	}

	if i == len(nums) -1 && first {
		return 0;
	}

	cache[i] = max(nums[i] + rec(i+2, nums, cache, first), rec(i+1, nums, cache,first))

	return cache[i]
}


func max(a, b int) int {
	if a > b {
		return a 
	}	
	return b
}