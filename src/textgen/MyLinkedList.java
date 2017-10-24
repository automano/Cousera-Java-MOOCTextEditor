package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size; 

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.head.next = this.tail;
		this.tail.prev = this.head;
		this.size = 0;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		add(size, element);
		return true;
	}

	
	public LLNode<E> getNode(int index){
		LLNode<E> getNode = new LLNode<E>(null);
		if(index < size / 2) {
			getNode = head.next;
			for(int j  = 0; j < index; j++) {
				getNode = getNode.next;
			}
		} else {
			getNode = tail;
			for(int j = size; j > index; j--) {
				getNode = getNode.prev;
			}
		}
		return getNode;
	}
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException();
		return getNode(index).data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		LLNode<E> indexNode = getNode(index);
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.prev = indexNode.prev;
		newNode.next = indexNode;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException();
		LLNode<E> tmpNode = getNode(index);
		tmpNode.prev.next = tmpNode.next;
		tmpNode.next.prev = tmpNode.prev;
		size--;
		return tmpNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		if(index < 1 || index > size - 1)
			throw new IndexOutOfBoundsException();
		LLNode<E> tmpNode = getNode(index);
		E tmp = tmpNode.data;
		tmpNode.data = element;
		return tmp;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prev, LLNode<E> next) {
		this.data = e;
		this.prev = prev;
		this.next = next;
	}
	
	public String toString() {
		return data.toString();
	}

}
