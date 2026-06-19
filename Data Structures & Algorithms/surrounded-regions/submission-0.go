type pos struct {
	i int 
	j int
}


func solve(board [][]byte) {
    for i := range len(board) {
		for j := range len(board[0]) {
			if board[i][j] == 'O' {
				update := make(map[pos]bool)
				if dfs(i,j,board, update) {
					for pos, _ := range update {
						board[pos.i][pos.j] = byte('X')
					}
				}
			}
		}
	}
}

func dfs (i, j int, board [][]byte, update map[pos]bool ) (bool) {
	if _, ok := update[pos{i,j}]; ok {
		return true;
	}
	
	if i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) {
		return false
	}

	if board[i][j] == 'X' {
		return true;
	} else {
		update[pos{i,j}] = true
	}

	return dfs(i+1,j,board, update) && dfs(i-1,j,board, update) && dfs(i,j+1,board, update) && dfs(i,j-1,board, update)


}
