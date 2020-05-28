package com.lc.may.challenge;

import java.util.HashMap;
import java.util.Map;

/*Contiguous Array
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/
public class ContiguousArray {

	public static int findMaxLength(int[] nums) {
		int max = 0, count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 1 ? 1 : -1);
			if (count == 0) {
				max = Math.max(max, i + 1);
			}
			if (map.containsKey(count)) {
				max = Math.max(max, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int nums[] = { 0, 1, 0, 0, 1, 1, 0 };
		System.out.println(findMaxLength(nums));
		
		System.out.println(3 >> 2);
	}

}
