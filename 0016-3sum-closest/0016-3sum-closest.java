class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int curr = nums[i] + nums[left] + nums[right];

                if (Math.abs(curr - target) < Math.abs(closest - target)) {
                    closest = curr;
                }

                if (curr == target) {
                    return curr;
                } else if (curr < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closest;
    }
}
