public class JumpGame {
    //
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) return true;
        int max = 0;
        int index = max;
        while (max < len - 1) {
            max = Math.max(max, index + nums[index]);
            if (max >= len - 1) return true;

            if (max <= index) return false;
            else index++;
        }
        return false;
    }

    public static void main(String[] a) {
        int[] nums = {3,0,8,2,0,0,1};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }
}
