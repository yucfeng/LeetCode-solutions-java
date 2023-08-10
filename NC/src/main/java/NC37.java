import java.util.ArrayList;

public class NC37 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     **/
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 0 || intervals.size() == 1) return intervals;
        // sort
        intervals.sort((i1, i2) -> i1.start - i2.start);

        ArrayList<Interval> ans = new ArrayList<>();
        int i = 0;
        Interval last = intervals.get(0);
        ans.add(intervals.get(0));
        for (; i < intervals.size(); i++) {
            if (last.end >= intervals.get(i).start) {
                ans.remove(last);
                last = new Interval(last.start, Math.max(intervals.get(i).end, last.end));
            } else {
                ans.add(new Interval(last.start, last.end));
                last = intervals.get(i);
            }
        }
        ans.add(last);
        return ans;
    }
}


class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

