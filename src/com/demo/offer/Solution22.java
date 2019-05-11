package com.demo.offer;

import java.util.Stack;

public class Solution22 {
	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，
	 * 请判断第二个序列是否为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。
	 * 例如序列1,2,3,4,5是某栈的压入顺序，
	 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
	 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

	思路：用栈来压入弹出元素，相等则出栈。
	 */
	public boolean IsPopOrder(int[] push, int[] pop) {
		if(push==null || push.length==0 || pop==null || pop.length==0 || push.length!=pop.length) return false;
		Stack<Integer> stack=new Stack<>();
		int index=0;
		for(int i=0;i<push.length;i++) {
			stack.push(push[i]);
			while(!stack.isEmpty() && stack.peek()==pop[index]) {
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();
	}
}
