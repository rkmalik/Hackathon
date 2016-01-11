package leetcode.prob297;

import java.util.LinkedList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {

		 System.out.println ("Entered Serialize method.");
	        
	        StringBuffer o = new StringBuffer ("");
	        
	        if (root == null) {
	            
	            //o.append ("");
	            return o.toString ();
	        }
	        
	        // I will convert this based on BFS
	        LinkedList<TreeNode> cur = new LinkedList<> ();
	        cur.add (root);
	         o.append (root.val+",");
	        LinkedList<TreeNode> newList = null;
	        
	        while (!cur.isEmpty()) {
	            
	            TreeNode n = cur.removeFirst ();
	            //o.append (n.val+",");
	            
	            if (newList == null) {
	                newList = new LinkedList<> ();
	            }
	            
	            if (n.left!= null)  {
	                newList.add(n.left);
	                 o.append (n.left.val+",");
	            } else {
	                o.append("null,");
	            }
	            
	            if (n.right != null) {
	                newList.add(n.right);
	                o.append (n.right.val+",");
	            } else {
	                o.append("null,");
	            }
	            
	            if (cur.isEmpty() && !newList.isEmpty()) {
	                cur = newList;
	                newList=null;
	            }
	        }
	        
	        //o.append ("]");
	        System.out.println (o.toString());
	        return o.toString ();
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		System.out.println("Entered DeSerialize method.");
		System.out.println(data);

		if (data == null || data.isEmpty())
			return null;

		String[] nodes = data.split(",");
		return dh(nodes);
	}

	private static TreeNode dh(String[] nodes) {

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nq = null;

		TreeNode root = null;
		TreeNode cur = null;
		String d = nodes[0];
		System.out.println(d);
		TreeNode n = new TreeNode(Integer.parseInt(d));
		root = n;
		q.add(n);
		n = null;

		for (int i = 1; i < nodes.length;) {
			cur = q.removeFirst();

			if (nq == null) {
				nq = new LinkedList<>();
			}

			d = nodes[i++];
			if (d.equals("null")) {
				cur.left = null;
			} else {
				n = new TreeNode(Integer.parseInt(d));
				cur.left = n;
				nq.add(n);
				n = null;
			}

			d = nodes[i++];
			if (d.equals("null")) {
				cur.right = null;
			} else {
				n = new TreeNode(Integer.parseInt(d));
				cur.right = n;
				nq.add(n);
				n = null;
			}

			if (q.isEmpty()) {
				q = nq;
				nq = null;
			}
		}

		return root;
	}
	
	
	public static void main (String args []) {
		
		TreeNode root = new TreeNode (1);
		root.left = new TreeNode (2);
		root.right = new TreeNode (3);
		root.right.left = new TreeNode (4);
		root.right.right = new TreeNode (5);
		System.out.print(deserialize(serialize (root)));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));