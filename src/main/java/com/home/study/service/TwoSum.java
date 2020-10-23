package com.home.study.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.home.study.model.ListNode;


public class TwoSum {

	public static void main(String[] args) {
		int[] nums=new int[]{2, 7, 11, 15, 3, 5, 8, 6, 1};
		
		List<List<Integer>> resultList =twoSum(nums, 9);
		for(List<Integer> list : resultList){
            System.out.println(Arrays.toString(list.toArray()));
        }
		
		List<List<Integer>> resultList2 =twoSumV2(nums, 9);
		for(List<Integer> list : resultList2){
            System.out.println(Arrays.toString(list.toArray()));
        }
		
		ListNode l1=new ListNode(2);
		ListNode l12=new ListNode(4);
		l12.setNext(new ListNode(3));
		l1.setNext(l12);
		
		ListNode l2=new ListNode(5);
		ListNode l22=new ListNode(6);
		l22.setNext(new ListNode(4));
		l2.setNext(l22);
		
		addTwoNumbers(l1,l2);
		
	}
	
	public static List<List<Integer>> twoSum(int[] nums, int target) {
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		List<List<Integer>> resultList = new ArrayList<>();
		for (int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		
		for (int i=0;i<nums.length;i++) {
			int other=target - nums[i];
			if(map.containsKey(other) && map.get(other)!=i) {
				resultList.add(Arrays.asList(i,map.get(other)));
				//为防止找到重复的元素对，匹配后从哈希表删除对应元素
                map.remove(nums[i]);
			}
		}
		
		return resultList;
	}
	
	public static List<List<Integer>> twoSumV2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int key=target-nums[i];
            if(map.containsKey(key)) {
            	resultList.add(Arrays.asList(map.get(key),i));
            }
            map.put(nums[i], i);
        }
        return resultList;
    }
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result=new ListNode(0);
		System.out.println("result:"+result.toString());
		ListNode temp=result;//变量指向的内存地址一样
		//进位
		int carry=0;
		while(l1!=null || l2!=null) {
			int a=l1!=null?l1.getVal():0;
			int b=l2!=null?l2.getVal():0;
			
			int sum=a+b+carry;
			carry=sum/10;
			sum=sum%10;
			
			temp.setNext(new ListNode(sum));
			//为了下次setNext()
			temp=temp.getNext();
			System.out.println("result:"+result.hashCode());
			System.out.println("temp:"+temp.hashCode());
			
			if(l1!=null) {
				l1=l1.getNext();
			}			
			if(l2!=null) {
				l2=l2.getNext();
			}
			
			
		}
		//处理最后一次相加后进位问题
		if(carry == 1) {
			temp.setNext(new ListNode(carry));
        }
        return result.getNext();
    }

}
