package ThisPractice;

import java.util.*;
import java.util.Map.Entry;


class TreeNode1 extends TreeNode{

	TreeNode1 left, right;
	public TreeNode1(int data) {
		super(data);
	}
	int hd;
	
	
}

public class BottomViewOfTree {

	public static void bottomViewOfTreeRec(TreeNode1 root, Map<Integer, TreeNode1> levelNodeMap, int level) {
		int height = height(root);

		System.out.println();
		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i, 0, levelNodeMap);
			System.out.println();
		}

	}

	public static int height(TreeNode1 root) {
		if (root == null)
			return 0;
		return (Math.max(height(root.left), height(root.right)) + 1);

	}

	public static void printGivenLevel(TreeNode1 root, int verticalLevel, int horizontalLevel,
			Map<Integer, TreeNode1> map) {

		if (root == null)
			return;
		if (verticalLevel == 1) {
			System.out.print(root.data + ",");
			map.put(horizontalLevel, root);

		}

		printGivenLevel(root.left, verticalLevel - 1, horizontalLevel - 1, map);
		printGivenLevel(root.right, verticalLevel - 1, horizontalLevel + 1, map);

	}

	public static void printLevelOrder(TreeNode1 root,Map<Integer,TreeNode1> mp) {
		Queue<TreeNode1> q = new LinkedList<>();
		if (root == null)
			return;
		q.add(root);
		int countSize;

		while (q.size() > 0) {
			countSize = q.size();
			while (countSize > 0) {
				TreeNode1 temp = q.poll();	
				System.out.print(temp.data + ",");
				if (temp.left != null)
				{	temp.left.hd=temp.hd-1;
					mp.put(temp.left.hd, temp.left);
					q.add(temp.left);
				}
				if (temp.right != null)
					{
					temp.right.hd=temp.hd+1;
					mp.put(temp.right.hd, temp.right);
					q.add(temp.right);
					}
				
				countSize--;
			}
			System.out.print("\n");
		}

	}

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(20);

		root.left = new TreeNode1(8);
		root.left.left = new TreeNode1(5);

		root.left.right = new TreeNode1(3);
		root.left.right.left = new TreeNode1(10);
		root.left.right.right = new TreeNode1(14);

		root.right = new TreeNode1(22);
		 root.right.left=new TreeNode1(4);
		root.right.right = new TreeNode1(25);

		TreePractice obj = new TreePractice();
		
		System.out.println("In order traversal");
		obj.inOrderTraversal(root);
		System.out.println("In order traversal-End");
		
		Map<Integer, TreeNode1> levelNodeMap = new HashMap<>();
		System.out.println("bottomViewOfTreeRec");
		bottomViewOfTreeRec(root, levelNodeMap, 0);
		System.out.println("bottomViewOfTreeRec-End");

		System.out.println("");
		for (Entry<Integer, TreeNode1> entrySet : levelNodeMap.entrySet()) {
			System.out.println(entrySet.getKey() + ">>>" + entrySet.getValue().data);
		}
		
		Map<Integer,TreeNode1> mp=new TreeMap<>();
		System.out.println("Level order:----");
		printLevelOrder(root,mp);
		
		
		System.out.println("Again bottom View");
		for (Entry<Integer, TreeNode1> entrySet : mp.entrySet()) {
			System.out.println(entrySet.getKey() + ">>>" + entrySet.getValue().data);
		}
		
		
		

	}
}
