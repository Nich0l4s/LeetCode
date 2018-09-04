package com.xxp.leetcode.Hard;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		Employee[] e = new Employee[quality.length];
		for(int i=0; i<e.length; i++) {
			e[i] = new Employee(quality[i], wage[i]);
		}
		Arrays.sort(e);
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int sumq = 0;
		double cost = 1e9;
		for(Employee ee : e) {
			sumq += ee.quality;
			queue.offer(-ee.quality);
			if(queue.size() > K) {
				sumq += queue.poll();
			}
			if(queue.size() == K) {
				cost = Math.min(cost, sumq* ee.ratio());
			}
		}
		return cost;
	}
}
class Employee implements Comparable<Employee>{
    public int quality;
    public int wage;
    public Employee(int quality, int wage){
    	this.quality = quality;
    	this.wage = wage;
    }
    public double ratio() {
    	return (double)wage/quality;
    }
	@Override
	public int compareTo(Employee e) {
		return Double.compare(ratio(), e.ratio());
	}
}