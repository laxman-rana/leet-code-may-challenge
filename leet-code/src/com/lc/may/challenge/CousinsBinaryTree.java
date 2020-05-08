package com.lc.may.challenge;

import java.util.HashMap;
import java.util.Map;

/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 */
//Definition for a binary tree node.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class CousinsBinaryTree {
	int xDepth = 0;
	int yDepth = 0;
	boolean cousins = true;

	public boolean isCousins2(TreeNode root, int x, int y) {
		TreeNode currentNode = root;
		depth(currentNode, x, y, 0);

		traverse(root, x, y);
		return xDepth == yDepth && cousins;
	}

	private void traverse(TreeNode root, int x, int y) {
		if (root == null) {
			return;
		}
		if (root.left != null && root.right != null
				&& (root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x)) {
			cousins = false;
		}
		traverse(root.left, x, y);
		traverse(root.right, x, y);
	}

	private int depth(TreeNode root, int x, int y, int depth) {
		if (root == null) {
			return depth;
		}
		if (root.val == x) {
			xDepth = depth;
		}

		if (root.val == y) {
			yDepth = depth;
		}
		depth(root.left, x, y, depth + 1);
		depth(root.right, x, y, depth + 1);

		return depth;
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		Map<TreeNode, Integer> x_map = checkDepth(root, x, null, 0);
		Map<TreeNode, Integer> y_map = checkDepth(root, y, null, 0);
		int x_level = -1;
		int y_level = -1;
		int x_parent = -1;
		int y_parent = -1;
		for (Map.Entry<TreeNode, Integer> entry : x_map.entrySet()) {
			x_level = entry.getValue();
			x_parent = entry.getKey() != null ? entry.getKey().val : 0;
		}
		for (Map.Entry<TreeNode, Integer> entry : y_map.entrySet()) {
			y_level = entry.getValue();
			y_parent = entry.getKey() != null ? entry.getKey().val : 0;
		}
		return x_level == y_level && x_parent != y_parent;
	}

	private Map<TreeNode, Integer> checkDepth(TreeNode root, int val, TreeNode node, int level) {
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
			map.put(node, level);
			return map;
		}
		Map<TreeNode, Integer> left_map = checkDepth(root.left, val, root, level + 1);
		Map<TreeNode, Integer> right_map = checkDepth(root.right, val, root, level + 1);
		return left_map != null ? left_map : right_map;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode();
	}

}
