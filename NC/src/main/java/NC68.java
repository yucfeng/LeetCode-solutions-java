public class NC68 {

    /**
     * @param number int整型
     * @return int整型
     */
    public int jumpFloor(int number) {
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        return jumpFloor(number - 1) + jumpFloor(number - 2);
    }
}
