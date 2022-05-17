package problemSet_1;

// https://leetcode.com/problems/house-robber/submissions/
public class HouseRobber {
    public int rob(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        if(nums.length == 1) return ans[0];
        ans[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(ans[i-1], ans[i-2] + nums[i]);
        }
        return ans[nums.length-1];
    }
}
