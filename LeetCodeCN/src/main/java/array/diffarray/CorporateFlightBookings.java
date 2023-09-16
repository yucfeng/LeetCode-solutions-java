package array.diffarray;
// https://leetcode.cn/problems/corporate-flight-bookings/
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int nums[] = new int[n];
        Difference df = new Difference(nums);
        for (int[] booking : bookings) {
            df.increment(booking[0]-1, booking[1]-1, booking[2]);
        }
        return df.getNums();
    }
}
