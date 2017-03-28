package com.marphain.demo.newer.algorithm;

public class SortUtil
{
	/**
	 * 冒泡排序法
	 * @param arrays
	 */
	public static void bubbleSort(int[] arrays)
	{
		if ((arrays == null) || arrays.length < 2)
		{
			return;
		}
		
		int tmp = 0;
		int length = arrays.length;
		for (int i = 0; i < length; i++) 
		{
			for (int j = i + 1; j < length; j++)
			{
				if (arrays[i] > arrays[j]) 
				{
					tmp = arrays[j];
					arrays[j] = arrays[i];
					arrays[i] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] arrays = new int[]{9, 8, 4, 1, 2, 3, 6, 5, 7}; 
		SortUtil.bubbleSort(arrays);
		for (int i = 0; i < arrays.length; i++)
		{
			System.out.println(arrays[i]);
		}
	}

}
