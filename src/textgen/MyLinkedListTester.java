/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			list1.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//check for invalid values
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//check when array is empty
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			boolean c = emptyList.add(null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
			
		}
		boolean a = list1.add(10);
		boolean b = emptyList.add(13);
		
		assertEquals("Add at End: check a is true ", true, a);
		assertEquals("Add at End: check last element is correct ", (Integer)10, list1.get(3));
		assertEquals("Add at End: check size is correct ", 4, list1.size());
		assertEquals("Add at End: check b is true ", true, b);
		assertEquals("Add at End: check element added to empty array is correct ", (Integer)13, emptyList.get(0));
		assertEquals("Add at End: check size is correct ", 1, emptyList.size());
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size is correct ",2,shortList.size());
		assertEquals("Size: check size is 0", 0, emptyList.size());
		assertEquals("Size: check size is correct ", 10, longerList.size());		//System.out.println(longerList.toString());
		longerList.add(11);
		assertEquals("Size: check size is correct ", 11, longerList.size());		//System.out.println(longerList.toString());
		int a=longerList.remove(10);
		assertEquals("Size: check size is correct ", 10, longerList.size());		//System.out.println(longerList.toString());
		longerList.add(10,67);		
		assertEquals("Size: check size is correct ", 11, longerList.size());
		assertEquals("Size: check size is correct ", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			shortList.add(1, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
			
		}
		//check for out of bounds
		try {
			shortList.add(3, "C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//check for invalid values
		try {
			shortList.add(-1, "C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//check when array is empty
		try {
			emptyList.add(1,67);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}

		list1.add(2,78);
		assertEquals("Add at Index: check element 2 is correct ", (Integer)78, list1.get(2));
		assertEquals("Add at Index: check size is correct ", 4, list1.size());
		
		list1.add(4,90);		
		assertEquals("Add at Index: check element 4 is correct ", (Integer)90, list1.get(4));
		assertEquals("Add at Index: check size is correct ", 5, list1.size());
		
		emptyList.add(0,78);
		assertEquals("Add at Index: check element 0 is correct ", (Integer)78, emptyList.get(0));
		assertEquals("Add at Index: check size is correct ", 1, emptyList.size());
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			shortList.set(1, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
			
		}
		try {
			list1.set(3, 10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//check for invalid values
		try {
			list1.set(-1, 10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		//check when array is empty
		try {
			emptyList.set(0, 11);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		list1.set(2, 34);
		
		assertEquals("Add at Index: check element 2 is correct ", (Integer)34, list1.get(2));
		assertEquals("Add at Index: check size is correct ", 3, list1.size());
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
