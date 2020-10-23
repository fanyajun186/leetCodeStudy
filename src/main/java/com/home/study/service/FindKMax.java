package com.home.study.service;

import java.util.Arrays;

public class FindKMax {

	public static void main(String[] args) {
		/*Integer num= 2;		
		String[] array = {"1","2","3","4"};
		boolean flag = Arrays.asList(array).contains(num+"");
		System.out.println("flag:" + flag);//--- flag:true
		flag = Arrays.asList(array).contains("0");
		System.out.println("flag:" + flag);//--- flag:false
		flag = Arrays.asList(array).contains("5");
		System.out.println("flag:" + flag);//--- flag:false
		 */
		int[] array = new int[] {7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
        System.out.println(findNumberK(array, 5));
	}

	private static int findNumberK(int[] array, int k) {
		//1.用前k个元素构建小顶堆
        buildHeap(array, k);
       //2.继续遍历数组，和堆顶比较
        for (int i = k; i < array.length; i++) {
            if(array[i] > array[0]) {
                array[0] = array[i];
                downAdjust(array, 0, k);
            }
        }
        //3.返回堆顶元素
        return array[0];
	}

	/**
	 * 构建堆
	 * @param array
	 * @param k
	 */
	private static void buildHeap(int[] array, int length) {
		//从最后一个非叶子节点开始，依次下沉调整
        for (int i = (length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, length);
        }
		
	}

	private static void downAdjust(int[] array, int index, int length) {
		//temp保存父节点的值，用于最后的赋值
        int temp = array[index];
        int childIndex = 2 * index + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex])
                break;
            //无需真正交换，单项赋值即可
            array[index] = array[childIndex];
            index = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[index] = temp;
		
	}

}
