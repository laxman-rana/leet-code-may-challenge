package com.lc.may.challenge;

/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false*/
public class ValidPerfectSquare {

	private static boolean isPerfectSquare2(int num) {
		int left = 1;
		int right = num;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int res = num / mid;
			if (mid * mid == num) {
				return true;
			}
			if (res > mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	private static boolean isPerfectSquare(int num) {
		int a = 1;
		while (num > 0) {
			num = num - a;
			a += 2;
		}
		return num == 0;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(808201));
		System.out.println(isPerfectSquare2(808201));
	}

}
