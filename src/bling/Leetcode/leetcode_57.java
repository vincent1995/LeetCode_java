package bling.Leetcode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class leetcode_57 {
    public static void main(String[] args){
        leetcode_57 sol = new leetcode_57();
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(3,5));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,20));

        Interval newInterval = new Interval(21,22);
        List<Interval> answer = sol.insert(intervals,newInterval);
        util.println(answer);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        // edge case
        if(n == 0){
            intervals.add(newInterval);
        }
        else{
            // find place to insert new interval
            int i = 0;
            while(i < n && intervals.get(i).end < newInterval.start) i++;

            // check intervals and delete & merge if necessary
            // should insert in ith place
            if( i == n)
                // insert in last position, no check required.
                intervals.add(newInterval);
            else{
                // insert at 0 to n-1 position, check required.
                while(true){
                    // overlap, need merge
                    if(intervals.size() > i && newInterval.end >= intervals.get(i).start){
                        newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
                        newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                        intervals.remove(i);
                    }
                    else{
                        break;
                    }
                }
                // insert
                intervals.add(i,newInterval);
            }
        }
        return intervals;
    }
}

class Interval implements Serializable {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        String s = "["+String.valueOf(start) + "," + String.valueOf(end) +"]";
        return s;
    }
}