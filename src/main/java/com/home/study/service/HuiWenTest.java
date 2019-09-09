package com.home.study.service;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 输入: 121   输出: true | 输入: -121 输出: false
 * @author: yajun.fan
 * @date: 2019年5月29日
 */
public class HuiWenTest {

	public static void main(String[] args) {
		isPalindrome(1221);
	}
	
	 public static boolean isPalindrome(int x) {
	        //边界判断
	        if (x < 0) return false;
	        int div = 1;
	        //循环，知道被除数和除数等长
	        while (x / div >= 10) {
	        	div *= 10;
	        }
	        //除(/)是取的结果的商
	        //求余(%)顾名思义是取的余数
	        while (x > 0) {
	            int left = x / div;
	            int right = x % 10;
	            if (left != right) {
	            	return false;
	            }
	            x = (x % div) / 10;
	            div /= 100;
	        }
	        return true;
	   }
}
