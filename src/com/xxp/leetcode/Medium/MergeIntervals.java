package com.xxp.leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * We assume there are m intervals(marked by i1, ..., im) can be merged into a new interval I1, and I2 is next to I1 including n previous intervals(im+1, ..., im+n).
I1.start = Min(I1.start, ... , Im.start), I1.end = Max(I1.end, ... , Im.end)
I2.start = Min(Im+1.start, ... , Im+n.start), I2.end = Max(Im+1.end, ... , Im+n.end)
I2.start > I1.end.
I1 consists of m smaller starts and ends. (for any ik in I1, ik.start < I2.start)
if starts[i+1] > ends[i], we just find I2.start is starts[i+1] and I1.end is ends[i]. j is index of next start.
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals){
		int size = intervals.size();
		int[] start = new int[size];
		int[] end = new int[size];
		for(int i=0; i<size; i++) {
			start[i] = intervals.get(i).start;
			end[i] = intervals.get(i).end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		List<Interval> res = new LinkedList<>();
		for(int i=0, j=0; i<size; i++) {
			if(i==size-1 || start[i+1]>end[i]) {
				res.add(new Interval(start[j], end[i]));
				j = i+1;
			}
		}
		return res;
	}
}
