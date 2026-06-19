func rob(nums []int) int {

	cache := make(map[int]int)
	cache[len(nums)] = 0;
	cache[len(nums) +1] = 0;
	return max(rec(0, nums, cache), rec(1, nums, cache))
}

func rec(i int, nums []int, cache map[int]int) int {
	if c, ok := cache[i];  ok {
		return c
	}

	cache[i] = max(nums[i] + rec(i+2, nums, cache), rec(i+1, nums, cache))

	return cache[i]
}


func max(a, b int) int {
	if a > b {
		return a 
	}	
	return b
}