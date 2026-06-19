

func coinChange(coins []int, amount int) int {
    cache := map[int]int {
        0 : 0,
    }


    min := rec(coins, amount,cache)

    if min >=  math.MaxInt32 {
        min = -1
    }
    return min
}

func rec(coins []int, amount int, cache map[int]int) int {
    if c, ok := cache[amount]; ok {
        return c
    }

    result :=  math.MaxInt32
    for _, c := range coins {
        if amount - c >= 0 {
            result = min(result, 1 + rec(coins, amount - c, cache))
        }
    }

    cache[amount] = result
    return result
}

func min(a,b int) int {
    if a < b {
        return a 
    }
    return b
}

