package com.demo.leetcode;

public class PalindromeString {
	/**
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true

	 */
	public static boolean isPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1) return true;
        int i=0,j=s.length()-1;
        while(i<j) {
        	while(i<j && !judge(s.charAt(i))) i++;
        	while(i<j && !judge(s.charAt(j))) j--;
        	if(i<j) {
        		if(uppercase(s.charAt(i))!=uppercase(s.charAt(j))) {
        			return false;
        		}
        		i++;
        		j--;
        	}
        }
		return true;
    }
	
	public static boolean judge(char c) {
		if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')) {
			return true;
		}
		return false;
	}
	
	public static char uppercase(char c) {
		if(c>='a' && c<='z') {
			return (char) (c-'a'+'A');
		}
		return c;
	}
	
	public static void main(String[] args) {
		String s="A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
}
