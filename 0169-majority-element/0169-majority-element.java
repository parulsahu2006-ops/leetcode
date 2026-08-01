class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;

        if (n < 1 || n > 5 * 10000) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] < -1000000000 || nums[i] > 1000000000) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}