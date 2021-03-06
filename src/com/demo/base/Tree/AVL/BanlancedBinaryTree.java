package com.demo.base.Tree.AVL;


/**
 * AVL树本质上是一颗二叉查找树，但是它又具有以下特点：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树。
 * 在AVL树中任何节点的两个子树的高度最大差别为一，所以它也被称为平衡二叉树。
 * @author WangShuaiJie
 *
 */
public class BanlancedBinaryTree {
	TreeNode root;
	/**
	 * 添加节点
	 * @param node
	 */
	public void add(TreeNode node) {
		if(root==null) {
			root=node;
		}else {
			root.add(node);
		}
	}
	/**
	 * 查找
	 * @param value
	 * @return
	 */
	public TreeNode search(int value) {
		if(root==null) return null;
		return root.search(value);
	}
	/**
	 * 删除节点
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) return;
		TreeNode target=search(value);
		if(target==null) return;
		TreeNode parentNode=searchParent(value);
		//要删除的是叶子节点
		if(target.left==null && target.right==null) {
			if(parentNode.left.value==value) {
				parentNode.left=null;
			}else {
				parentNode.right=null;
			}
		//要删除的节点有两个字点
		}else if(target.left!=null && target.right!=null) {
			//删除右子树中值最小的节点
			int min=deleteMin(target.right);
			//替换目标节点值
			target.value=min;		
		}else {
		//要删除节点有一个左子节点或右子节点
			if(target.left!=null) {
				if(parentNode.left.value==value) {
					parentNode.left=target.left;
				}else {
					parentNode.right=target.left;
				}
			}else {
				if(parentNode.left.value==value) {
					parentNode.left=target.right;
				}else {
					parentNode.right=target.right;
				}
			}
		}
	}
	//删除最小节点
	private int deleteMin(TreeNode node) {
		TreeNode target=node;
		//向左找
		while(target.left!=null) {
			target=target.left;
		}
		//删除最小的节点
		delete(target.value);
		return target.value;
	}
	//查找父节点
	public TreeNode searchParent(int value) {
		if(root==null) return null;
		return root.searchParent(value);
	}
	//遍历
	public void inorder() {
		root.inorder();
	}
		
}
