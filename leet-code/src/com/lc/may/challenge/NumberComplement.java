package com.lc.may.challenge;

import java.math.BigInteger;

/*Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 
Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Note:

The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
*/

public class NumberComplement {

	public static int findComplement2(int num) {
		int bitLength = (int) (Math.log(num) / Math.log(2)) + 1;
		int bitMask = (1 << bitLength) - 1;
		return num ^ bitMask;
	}

	public static int findComplement3(int num) {
		int cp = num;
		int sum = 0;
		while (num > 0) {
			sum = (sum << 1) + 1;
			num >>= 1;
		}
		return sum - cp;
	}

	public static int findComplement(int num) {
		if (num <= 0) {
			return 0;
		}
		StringBuilder binary = new StringBuilder();
		while (num > 0) {
			int rem = num % 2;
			num /= 2;
			if (rem == 1) {
				binary.append(0);
			} else {
				binary.append(1);
			}

		}
		int result = 0;
		BigInteger bigInteger = new BigInteger(binary.reverse().toString());
		int power = 0;
		while (bigInteger.compareTo(BigInteger.ZERO) != 0) {
			int temp = bigInteger.mod(BigInteger.TEN).intValue();
			result += temp * Math.pow(2, power);
			bigInteger = bigInteger.divide(BigInteger.TEN);
			power++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findComplement(20161211));
		System.out.println(findComplement2(20161211));
		System.out.println(findComplement3(5));
	}

}
