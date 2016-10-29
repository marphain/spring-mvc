package com.marphain.demo.newer.datastructure.stack;


/**
 * 链栈
 * 后进先出（LIFO)
 * @author lenovo
 *
 */
public class LinkStack<T>
{
	//栈顶元素
	private StackNode<T> top;
	
	//栈元素个数
	private int size;
	
	//入栈
	public void push(T data)
	{
		top = new StackNode(data, top);
		size++;
	}
	
	//出栈
	public T pop()
	{
		StackNode<T> node = this.top;
		this.top = this.top.getNext();
		node.setNext(null);
		size--;
		
		return node.getData();
	}
	
	//返回栈顶元素，但不出栈
	public T peek()
	{
		return this.top.getData();
	}
	
	//获取栈元素个数
	public int length()
	{
		return this.size;
	}
	
	public static void main(String[] args)
	{
		LinkStack<String> stack = new LinkStack<String>();
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
