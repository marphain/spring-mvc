package com.marphain.demo.newer.datastructure.tree;


/**
 * 二叉查找树
 * @author lenovo
 *
 * @param <T>
 */
public class BinaryTree<T extends Comparable>
{
	//二叉树
	private BinaryNode root;
	
	/**
	 * 插入树节点
	 * 
	 * @param t
	 */
	public void insert(T t)
	{
		root = insert(t, root);
	}
	
	/**
	 * 
	 * @param t
	 * @param node
	 * @return
	 */
	private BinaryNode insert(T t, BinaryNode node)
	{
		//1.若是空树，则直接将t作为根结点插入
		if (node == null)
		{
			return new BinaryNode(t);
		}
		
		int result = t.compareTo(node.getData());
		
		//2.若t小于node结点的数据的值，则将t要插入的结点的位置改变为node的左子树
		if (result < 0)
		{
			node.setLeftNode(insert(t, node.getLeftNode()));
		}
		//3.若t大于node结点的数据的值，则将t要插入的结点的位置改变为node的右子树
		else if(result > 0)
		{
			node.setRightNode(insert(t, node.getRightNode()));
		}
		
		//4.若t等于node结点的数据的值，则直接返回
		
		return node;		
	}
	
	/**
	 * 是否包含节点data
	 * @param data
	 * @return
	 */
	public boolean contains(T data)
	{
		return constains(data, root);
	}
	
	private boolean constains(T data, BinaryNode node)
	{
		//1.如果为空，则查找失败，返回false
		if (node == null)
		{
			return false;
		}
		
		int result = data.compareTo(node.getData());
		
		//2.如果data值小于node节点的值，则在node左节点查找
		if (result < 0)
		{
			return constains(data, node.getLeftNode());
		}
		//3.如果data值小于node节点的值，则在node左节点查找
		else if(result > 0)
		{
			return constains(data, node.getRightNode());
		}
		else
		{
			return true;
		}
		
	}
	
	/**
	 * 左子节点的值最小
	 * @param node
	 * @return
	 */
	public BinaryNode<T> findMin(BinaryNode<T> node)
	{
		if (node == null)
		{
			return null;
		}
		else if(node.getLeftNode() == null)
		{
			return node;
		}
		else
		{
			return findMin(node.getLeftNode());			
		}
	}
	
	/**
	 * 删除数据节点
	 * @param data
	 * @return
	 */
	public void remove(T data)
	{
		root = remove(data, root);
	}
	
	private BinaryNode<T> remove(T data, BinaryNode<T> node)
	{
		if(node == null)
		{
			return null;
		}
		
		int result = data.compareTo(node.data);
		
		//查找需要删除的节点
		if (result < 0)
		{
			node.leftNode = remove(data, node.leftNode);
		}
		else if (result > 0)
		{
			node.rightNode = remove(data, node.rightNode);
		}
		else 
		{
			//如果该节点的左右子树都存在，则选择右子树中最小的节点替换该节点,并删除右子树中的最小节点
			if ((node.leftNode != null) && (node.rightNode != null))
			{
				node.data = findMin(node.rightNode).data;
				node.rightNode = remove(node.data, node.rightNode);
			}
			else
			{
				node = (node.rightNode == null) ? node.leftNode : node.rightNode;
			}
		}
		
		return node;
	}
	
	/**
	 * 先根遍历
	 * 输出节点数据（先打印根节点，再打印左节点，最后打印右节点）
	 */
	public void display()
	{
		print(root);
	}
	private void print(BinaryNode node)
	{
		if (node != null) 
		{
			System.out.println(node.data);
			if (node.leftNode != null)
			{
				print(node.leftNode);
			}
			if (node.rightNode != null)
			{
				 print(node.rightNode);
			}
		}
	}


	/**
	 * 二叉树节点
	 * @author lenovo
	 *
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	private class BinaryNode<T>
	{
		//节点数据
		private T data;
		
		//左子节点
		private BinaryNode leftNode;
		
		//右子节点
		private BinaryNode rightNode;
		
		public BinaryNode(T data)
		{
			this.data = data;
		}
		
		public T getData()
		{
			return data;
		}
		
		public void setData(T data)
		{
			this.data = data;
		}
		
		public BinaryNode getLeftNode()
		{
			return leftNode;
		}
		
		public void setLeftNode(BinaryNode leftNode)
		{
			this.leftNode = leftNode;
		}
		
		public BinaryNode getRightNode()
		{
			return rightNode;
		}
		
		public void setRightNode(BinaryNode rightNode)
		{
			this.rightNode = rightNode;
		}
		
	}
	
	public static void main(String[] args)
	{
		BinaryTree<Integer> bTree = new BinaryTree<Integer>();
		bTree.insert(10);
		bTree.insert(9);
		bTree.insert(8);
		bTree.insert(7);
		bTree.insert(3);
		bTree.insert(4);
		bTree.insert(5);
		bTree.insert(6);
		bTree.insert(12);
		bTree.insert(11);
		bTree.insert(14);
		bTree.insert(13);
		bTree.insert(15);
		bTree.display();
		
		bTree.remove(12);
		bTree.display();
	}
}

