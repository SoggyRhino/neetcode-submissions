class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row;
        int left = 0;
        int right = matrix.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            row = matrix[mid];

            if (row[0] <= target && row[row.length - 1] >= target) {
                left = 0;
                right = row.length - 1;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (row[mid] == target)
                        return true;
                    else if (row[mid] < target) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
            }
            else if (row[0] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}