package com.marphain.demo.newer.datastructure.stack;

/**
 * 数据节点
 * @author lenovo
 *
 */
public class StackNode<T>
{
	private T data;
	
	private StackNode<T> next;
	
	public StackNode()
	{
	}
	
	public StackNode(T data, StackNode<T> next)
	{
		this.data = data;
		this.next = next;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public StackNode<T> getNext()
	{
		return next;
	}

	public void setNext(StackNode<T> next)
	{
		this.next = next;
	}

}
