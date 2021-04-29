class Solution {
    public int removeDuplicates(int[] nums) {
        int placeToInsert = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                continue;
            } else {
                nums[placeToInsert] = nums[i];
                placeToInsert++;
                count++;
            }
        }
        return count;
    }
}
