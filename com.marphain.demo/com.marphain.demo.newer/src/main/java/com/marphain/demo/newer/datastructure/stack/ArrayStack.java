package com.marphain.demo.newer.datastructure.stack;

/**
 * 数组栈
 * @author lenovo
 *
 */
public class ArrayStack
{
	//数组，存放栈元素
	private Object[] nodes;
	
	//表示栈的元素个数，也表示下个入栈的索引值
	private int top;
	
	private static int SIZE = 10;
	
	public ArrayStack()
	{
		this.nodes = new Object[SIZE];
		this.top = 0;
	}

	//入栈
	public void push(Object node)
	{
		nodes[top] = node;
		top++;
	}
	
	//出栈
	public Object pop()
	{
		if (isEmpty())
		{
			return null;
		}
		
		Object node = nodes[--top];
		nodes[top] = null;
		
		return node;
	}
	
	public boolean isEmpty()
	{
		return top == 0;
	}
	
	public int length()
	{
		return top;
	}
	
	//数组扩容
	public void expand()
	{
		Object[] newNodes = new Object[nodes.length * 2];
		for(int i = 0; i < nodes.length; i++)
		{
			newNodes[i] = nodes[i];
		}
		
		nodes = newNodes;		
	}
	
	public static void main(String[] args)
	{
		ArrayStack stack = new ArrayStack();
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		stack.push("ddd");
		
		int length = stack.length();
		for(int i = 0; i < length; i++)
		{
			System.out.println(stack.pop());
		}
		
		System.out.println("size:" + stack.length());		
	}
}
