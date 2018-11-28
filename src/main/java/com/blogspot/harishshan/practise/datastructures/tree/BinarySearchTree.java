package com.blogspot.harishshan.practise.datastructures.tree;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
							50
							/\

						 
			25								75
			/\								/\


	12				37				63				87
	/\				/\				/\				/\


6		18		31		42		57		70		80		92
**/
public class BinarySearchTree {
	public static void main(String arg[]) {
		Node root = new Node(500);
		long current= System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			insert(root, (int) (Math.random()*100000));
		}
		long end = System.currentTimeMillis();
		inorder(root);
		System.out.println(end-current);
		/*
		insert(root, 50);
		insert(root, 25);
		insert(root, 75);
		insert(root, 12);
		insert(root, 37);
		insert(root, 63);
		insert(root, 87);
		insert(root, 6);
		insert(root, 18);
		insert(root, 31);
		insert(root, 42);
		insert(root, 57);
		insert(root, 70);
		insert(root, 80);
		insert(root, 92);
		//insert(root, 5);
		connectNextRightByRecursive(root);
		inorder(root);
		System.out.println("-->"+search(root, 12));
		System.out.println("Height:"+height(root));
		printLevelOrder(root);
		System.out.println("Min:"+minDepth(root));
		System.out.println("MaxSum:"+ findMaxSum(root, 0));
		preorder(root);
		System.out.println("IsFullBST:"+isFullBST(root));
		printBottomView(root);
		System.out.println("TopView:");
		printTopView(root);
		removeShortPathNodes(root, 1, 4);
		System.out.println("A");
		inorder(root);
		System.out.println("LCA of 6,37 is"+ lca(root, 6, 37));
		Node subtree = root.left.left;
		System.out.println("Is SubTree:"+isSubTree(root, subtree));*/
	}
	public static void insert(Node _root, int _data) {
		insertByWhile(_root, _data);
	}
	public static Node insertByRecursive(Node _root, int _data) {
		if(_root == null)
			return new Node(_data);
		if(_data < _root.data)
			_root.left = insertByRecursive(_root.left, _data);
		else if(_data > _root.data)
			_root.right = insertByRecursive(_root.right, _data);
		return _root;
	}
	public static void insertByWhile(Node _root, int _data) {
		Node previousNode = _root;
		String leftOrRight = "";
		while(_root!=null) {
			previousNode = null;
			leftOrRight = null;
			if(_data < _root.data) {
				previousNode = _root;
				_root = _root.left;
				leftOrRight = "L";
			} else if(_data > _root.data) {
				previousNode = _root;
				_root = _root.right;
				leftOrRight = "R";
			} else if(_data == _root.data){
				break;
			}
		}
		if(_root == null) {
			Node newNode = new Node(_data);
			if(leftOrRight.equals("L")) {
				previousNode.left = newNode;
			}else if(leftOrRight.equals("R")) {
				previousNode.right = newNode;
			}			
		}		
	}
	
	public static void inorder(Node _root){
		if(_root != null) {
			inorder(_root.left);
			System.out.println(_root.data +"-->"+ _root.nextRight);
			inorder(_root.right);
		}
	}
	public static void preorder(Node _root) {
		if(_root==null)
			 return;
		System.out.println(_root.data);
		preorder(_root.left);		
		preorder(_root.right);
	}
	public static void postorder(Node _root) {
		if(_root==null)
			 return;
		postorder(_root.left);		
		postorder(_root.right);
		System.out.println(_root.data);
	}
	public static Node search(Node _root, int _data) {
		if(_root == null || _root.data == _data)
			return _root;
		if(_root.data < _data) 
			return search(_root.right, _data);
		return search(_root.left, _data);
	}
	//To set the nextRight property of the tree
	public static void connectNextRightByRecursive(Node _root) {
		if(_root==null)
			return;
		if(_root.left !=null)
			_root.left.nextRight = _root.right;
		if(_root.right !=null)
			_root.right.nextRight = (_root.nextRight!=null)? _root.nextRight.left : null;
		connectNextRightByRecursive(_root.left);
		connectNextRightByRecursive(_root.right);
	}
	public static int height(Node _root) {
		if(_root == null)
			return 0;
		int lheight = height(_root.left);
		int rheight = height(_root.right);
		if(lheight > rheight)
			return lheight+1;
		return rheight+1;
	}
	public static int minDepth(Node _root) {
		if(_root == null)
			return 0;
		if(_root.left == null || _root.right == null)
			return 1;
		if(_root.left==null)
			return minDepth(_root.right)+1;
		if(_root.right==null)
			return minDepth(_root.left)+1;
		return Math.min(minDepth(_root.left),minDepth(_root.right))+1;
	}
	public static void printLevelOrder(Node _root) {
		int h = height(_root);
		for(int i=1; i<=h; i++)
			printGivenLevel(_root, i);
	}
	public static void printGivenLevel(Node _root, int level) {
		if(_root == null)
			return;
		if(level == 1)
			System.out.println(_root.data);
		else if(level>1) {
			printGivenLevel(_root.left, level-1);
			printGivenLevel(_root.right, level-1);
		}
	}
	public static int findMaxSum(Node _root, int _result) {
		if(_root == null)
			return 0;
		int l = findMaxSum(_root.left, _result);
		int r = findMaxSum(_root.right, _result);
		int max = Math.max(Math.max(l,r)+_root.data, _root.data);
		return max;
	}
	public static boolean isFullBST(Node _root) {
		if(_root == null)
			return true;
		if(_root.left == null && _root.right == null)
			return true;
		if(_root.left!=null && _root.right!=null)
			return (isFullBST(_root.left) && isFullBST(_root.right));
		return false;
	}
	public static void printBottomView(Node _root) {
		if(_root ==null)
			return;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		int hd = 0;
		_root.hd = hd;
		queue.add(_root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			hd = temp.hd;
			map.put(hd, temp.data);
			if(temp.left !=null) {
				temp.left.hd = hd-1;
				queue.add(temp.left);
			}
			if(temp.right !=null) {
				temp.right.hd = hd+1;
				queue.add(temp.right);
			}
		}
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}
	public static void printTopView(Node _root) {
		if (_root == null)
			return;
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<QueueItem> Q = new LinkedList<QueueItem>();
        Q.add(new QueueItem(_root, 0));
        while (!Q.isEmpty()) {
        	QueueItem qi = Q.remove();
            int hd = qi.hd;
            Node n = qi.node;
            if (!set.contains(hd)) {
                set.add(hd);
                System.out.print(n.data + " ");
            }
            if (n.left != null)
                Q.add(new QueueItem(n.left, hd-1));
            if (n.right != null)
                Q.add(new QueueItem(n.right, hd+1));
        }
	}
	public static Node removeShortPathNodes(Node node, int level, int k) {
        if (node == null)
            return null;
        node.left = removeShortPathNodes(node.left, level + 1, k);
        node.right = removeShortPathNodes(node.right, level + 1, k);
        if (node.left == null && node.right == null && level < k)
            return null;
        return node;
    }
	public static Node lca(Node _root, int n1, int n2) {
		if(_root == null)
			return null;
		if(_root.data > n1 && _root.data > n2)
			return lca(_root.left, n1, n2);
		if(_root.data < n1 && _root.data < n2)
			return lca(_root.right, n1, n2);
		return _root;
	}
	public static boolean isSubTree(Node T, Node S) {
		if (S == null)
	        return true;
	    if (T == null)
	        return false;
	    if (areIdentical(T, S))
	        return true;
	    return isSubTree(T.left, S) || isSubTree(T.right, S);
	}
	public static boolean areIdentical(Node root1, Node root2){
	    if (root1 == null && root2 == null)
	        return true;
	    if (root1 == null || root2 == null)
	        return false;
	    return (root1.data == root2.data &&  areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right) );
	}
}

class Node{
	public int data;
	public Node left;
	public Node right;
	public Node nextRight;
	public int hd;
	public Node(int _data) {
		this.data = _data;
		this.left = null;
		this.right = null;
		this.hd = 0;
	}
	@Override
	public String toString() {
		return ""+this.data;
	}
}

class QueueItem{
	public Node node;
	public int hd;
	public QueueItem(Node _node, int _hd) {
		this.node = _node;
		this.hd = _hd;
	}
}