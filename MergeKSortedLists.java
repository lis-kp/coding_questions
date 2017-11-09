import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import org.omg.PortableServer.ServantActivator;

public class MergeKSortedLists {	
	/**
	 * Definition for singly-linked list.
	 */
	  public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }

	/*
	 * Brute-force solution
	 * Source: Leetcode
	 
	 * Intuition & Algorithm
	 Traverse all the linked lists and collect the values of the nodes into an array.
	 Sort and iterate over this array to get the proper value of nodes.
	 Create a new sorted linked list and extend it with the new nodes.
	 
	 * Complexity Analysis
	 Time complexity : O(NlogN) where N is the total number of nodes.
	 Collecting all the values costs O(N) time.
	 A stable sorting algorithm costs O(NlogN) time.
	 Iterating for creating the linked list costs O(N) time.
	 Space complexity : O(N)
	 Sorting cost O(N) space (depends on the algorithm you choose).
	 Creating a new linked list costs O(N) space.
	 */
	public  ListNode mergeKListsBruteForce(ListNode[] lists) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < lists.length; i++) {
			ListNode p = lists[i];
			while (p != null) {
				list.add(p.val);
				p = p.next;
			}
		}
		
		Collections.sort(list);
		
		//creates a dummy node 
		ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        //iterates sorted arraylist of values 
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer value = (Integer) iterator.next();
			ListNode node = new ListNode(value);
			tail.next = node;
			tail = tail.next;
		}
		return dummy.next;       
    }
	
	public static ListNode compareOneByOne(ListNode[] lists) {
        return null;
    }
}
