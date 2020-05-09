package com.lc.may.challenge;

/*
Check If It Is a Straight Line
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
Check if these points make a straight line in the XY plane.

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.*/
public class CheckStraightLine {

	// Formula = (y1 - y0) * (x2 - x1) == (x1 - x0) * (y2 - y1)
	public static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 2) {
			return true;
		}
		int y_diff = Math.abs(coordinates[1][1] - coordinates[0][1]);
		int x_diff = Math.abs(coordinates[1][0] - coordinates[0][0]);
		for (int i = 1; i < coordinates.length - 1; i++) {
			int current_ydiff = Math.abs(coordinates[i + 1][1] - coordinates[i][1]);
			int current_xdiff = Math.abs(coordinates[i + 1][0] - coordinates[i][0]);
			if (y_diff * current_xdiff != x_diff * current_ydiff) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int coordinates[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		System.out.println(checkStraightLine(coordinates));
	}

}
