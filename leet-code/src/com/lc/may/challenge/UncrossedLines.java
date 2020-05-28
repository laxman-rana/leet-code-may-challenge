package com.lc.may.challenge;

public class UncrossedLines {

	public static int maxUncrossedLines(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];

		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = B.length - 1; j >= 0; j--) {
				dp[i][j] = (A[i] == B[j] ? dp[i + 1][j + 1] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]));
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		// int A[] = { 1, 4, 2 };
		// int B[] = { 1, 2, 4 };
		int A[] = { 2, 5, 1, 2, 5 };
		int B[] = { 10, 5, 2, 1, 5, 2 };
		System.out.println(maxUncrossedLines(A, B));
	}

}
