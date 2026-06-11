class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        int high = 0;
        for (int pile : piles) {
            sum += pile;
            high = Math.max(pile, high);
        }

        int low = sum / h;
        int k = -1;
        int succes = high;

        while (low < high) {
            k = (low + high) / 2;
            int hours = hours(piles, k);
            if (hours <= h) {
                high = k;
                succes = k;
            }
            else {
                low = k + 1;
            }
        }
        return succes;
    }

    public int hours(int[] piles, double k) {
        int hours = 0;
        for (int pile : piles)
            hours += Math.ceil(pile / k);
        return hours;
    }
}
