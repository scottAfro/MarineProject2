//Scott Kennedy
//Node Class

package ie.gmit.computing;

import java.util.*;
import android.media.Image;

public class Node 
{
	private String name;
	private Node[] children = new Node[0];
	private Node parent;
	//private ImageIcon image = null;

	public Node(String name, Node parent)
	{
		super();
		this.name = name;
		this.parent = parent;			
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	
	/**
	 * Gets the parent node of this one.
	 * @return
	 */
	public Node getParent()
	{
		return this.parent;		
	}
	
	/** Adds the child node to this container making this its parent.
	 * 
	 * @param child is the node to add to the tree as a child of this
	 */
	 public void add (Node child, int index)
	  {
	    // Add the child to the list of children.
	    if ( index < 0 || index == children.length )  // then append
	    {
	    	Node[] newChildren = new Node[ children.length + 1 ];
	      System.arraycopy( children, 0, newChildren, 0, children.length );
	      newChildren[children.length] = child;
	      children = newChildren;
	    }
	    else if ( index > children.length )
	    {
	      throw new IllegalArgumentException("Cannot add child to index " + index + ".  There are only " + children.length + " children.");
	    }
	    else  // insert
	    {
	    	Node[] newChildren = new Node[ children.length + 1 ];
	      if ( index > 0 )
	      {
	        System.arraycopy( children, 0, newChildren, 0, index );
	      }
	      newChildren[index] = child;
	      System.arraycopy( children, index, newChildren, index + 1, children.length - index );
	      children = newChildren;
	    }
	    
	    // Set the parent of the child.
	    child.parent = this;
	  }
	 
	/**
	 * Adds the child node to this container making this its parent.
	 * The child is appended to the list of children as the last child.	  
	 */
	public void addChild (Node child)
	{
		add(child,-1);
	}
	
	public void removeChild(Node child)
	{
		if(parent != null)
		{
			int position = this.index();
			parent.remove(position);
			parent = null;
		}
	}//End of RemoveChild
	
	/**
	 * Remove the child at position index from the tree.
	 * 
	 *  @param index is the position of the child.  It should be between
	 *  0 (the first child) and the total number of children minus 1
	 *  (the last child).
	 *  @return The removed child node.  This will be null if
	 *  no child exists at the specified index.
	 */
	public Node remove (int index)
	{
		if (index < 0 || index >= children.length) 
		{
			throw new IllegalArgumentException("Unable to remove the index " + index + " when there are " + children.length);
		}
		
		//Handle to the node being removed.
		Node node = children[index];
		node.parent = null;
		
		//Remove the child from this node.
		Node[] newChildren = new Node[ children.length - 1];
		if( index > 0)
		{
			System.arraycopy(children, 0, newChildren, 0, index);
		}
		if(index != children.length - 1)
		{
			System.arraycopy(children, index + 1, newChildren, index, children.length - index - 1);
		}
		children = newChildren;
		
		return node;
	}//End of Remove	
	
	public Node[] children ()	
	{
		return children;
	}
	
	/**
	 * return if this node has children or its a leaf
	 * @return
	 */
 	public boolean hasChild()
	{
		if( parent == null )
		{
			return true;
		}
		else
		{
			return false;
		}
	}//End of hasChildren
	
	/**
	 * return if this node is the root node in the tree or not
	 * @return
	 */
	public boolean isRoot()
	{
		if(parent == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}//End of isRoot()
	
	/**
	 * Gets the position of this this node in 
	 * the list of children controlled by the parent node. 
	 */
	public int index()
	{
		if( parent != null)
		{
			for( int i = 0;; i++)
			{
				Object node = parent.children[i];
				
				if(this == node)
				{
					return i;
				}
			}
		}
		
		return -1;
	}//End of int index()
	
   /**
   * Gets this node's depth in the tree.  The root node will have a depth of 0, first-level nodes will have a depth
   * of 1, and so on.
   *  
   * @return The depth of this node in the tree.
   */
	public int depth ()
	{
	    int depth = recurseDepth( parent, 0 );
	    return depth;
	}
	
	 /**
	   * Recursive helper method to calculate the depth of a node.
	   * The caller should pass its parent and an initial depth of 0.
	   * 
	   * A recursive approach is used so that when a node that is part of a tree is removed from that tree, we do not need	   
	   * to recalculate the depth of every node in that subtree.
	   * 
	   * @param node is the node to recursively check for its depth. This should be set to parent by the caller.
	   *  
	   * @param depth is the depth of the current node (i.e. the child of node. This should be set to 0 by the caller.  
	   */
	 private int recurseDepth (Node node, int depth)
	 {
	    if ( node == null )  // reached top of tree
	    {
	      return depth;
	    }
	    else
	    {
	      return recurseDepth( node.parent, depth + 1 );
	    }
	 }	
}
