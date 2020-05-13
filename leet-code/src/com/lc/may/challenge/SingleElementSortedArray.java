package com.lc.may.challenge;

/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.*/
public class SingleElementSortedArray {

	public static int singleNonDuplicate(int[] nums) {
		int step = 0;
		int two_step = 1;
		while (two_step < nums.length) {
			if (nums[step] != nums[two_step]) {
				return nums[step];
			}
			step = step + 2;
			two_step = two_step + 2;

		}
		return nums[step];
	}

	public static void main(String[] args) {
		int nums[] = { 3, 3, 7, 7, 10, 11, 11 };
		System.out.println(singleNonDuplicate(nums));
	}

}
