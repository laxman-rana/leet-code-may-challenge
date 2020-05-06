package com.lc.may.challenge;

import java.util.HashMap;
import java.util.Map;

/*Given an array of size n, find the majority element. The majority element is the element that appears more than [n/2]times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2*/
public class MajorityElement {

	public static int majorityElement2(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		return majorityElement(nums, 0);
	}

	private static int majorityElement(int[] nums, int start) {
		int count = 1;
		int num = nums[start];
		for (int i = start + 1; i < nums.length; i++) {
			if (num == nums[i])
				count++;
			else
				count--;
			if (count == 0)
				return majorityElement(nums, i + 1);
		}
		return num;
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				int count = map.get(nums[i]) + 1;
				if (count > nums.length / 2) {
					return nums[i];
				}
				map.put(nums[i], count);
			}
		}
		int max = 0;
		int result = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				result = entry.getKey();
				max = entry.getValue();
			}
		}
		return result;
	}

	public static int majorityElement3(int[] nums) {
		int leader = nums[0], leader_count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == leader)
				leader_count++;
			else {
				leader_count--;
				if (leader_count == 0) {
					if (i < nums.length - 1) {
						leader = nums[i + 1];
						leader_count = 1;
						i++;
					}
				}
			}
		}
		return leader;

	}

	public static void main(String[] args) {
		int[] nums = { 3,3,4 };
		System.out.println(majorityElement(nums));
		System.out.println(majorityElement2(nums));
		System.out.println(majorityElement3(nums));
	}

}
