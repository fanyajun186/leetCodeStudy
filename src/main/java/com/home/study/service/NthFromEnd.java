package com.home.study.service;

/**
 * 链表的倒数第N个元素
 * @author: yajun.fan
 * @date: 2020年10月23日
 */
public class NthFromEnd {

	public static void main(String[] args) {
		int[] inputs = {5,3,7,2,4,1,9,8};
        Node head = buildLinkList(inputs);
        Node node = findNthFromEnd(head,3);
        System.out.println("链表倒数第3个元素是：" + node.data);
	}
	
	/**
	 * 查找倒数第N个
	 * @param head
	 * @param i
	 * @return
	 */
	private static Node findNthFromEnd(Node head, int n) {
		Node p1 = head;
		Node p2 = head;
		for (int j = 1; j < n; j++) {
			p2 = p2.next;
            if(p2 == null){
                throw new IllegalArgumentException("参数n超出链表长度！");
            }
		}
		while(p2.next!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}


	/**
	 * 创建链表
	 * @param inputs
	 * @return
	 */
	private static Node buildLinkList(int[] array) {
		Node head = new Node(array[0]);
		Node p = head;
		for (int i = 1; i < array.length; i++) {
			p.next=new Node(array[i]);
			p=p.next;			
		}
		return head;
	}



	private static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
		}
	}

}
