package com.lc.may.challenge;

/*Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.*/
public class ConstructBSTPreorderTraversal {

	public static TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = null;
		for (int val : preorder) {
			root = buildBSTFromPreOrder(root, val);
		}
		return root;
	}

	private static TreeNode buildBSTFromPreOrder(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else if (root.val > val) {
			root.left = buildBSTFromPreOrder(root.left, val);
		} else {
			root.right = buildBSTFromPreOrder(root.right, val);
		}
		return root;
	}

	public static void main(String[] args) {

	}

}
