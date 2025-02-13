/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static class Node
    {
       int  data;
       Node next;
       
       
       Node(int data)
       {
           this.data=data;
       }
    }
    
    static class LinkedList
    {
        
    Node head;
    Node tail;
    public void addLast(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }else
        {
            tail.next=n;
            tail=n;
        }
    }
    
    public void addFirst(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }else
        {
            n.next=head;
            head=n;
        }
    }
    public void display()
    {
        if(head==null)
        {
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    public void removeFirst()
    {
        if(head==null)
        return;
        if(head==tail)
        {
            head=null;
            tail=null;
        }
        else
        {
            head=head.next;
        }
    }
    
    public void removeLast()
    {
        if(head==null)
        {
            return;
        }else 
        {
            Node temp=head;
            while(temp.next.next!=null)
            temp=temp.next;
            temp.next=null;
            tail=temp;
        }
    }
    public int peekFirst()
    {
        if(head==null)
        return -1;
        return head.data;
    }
    
    public int peekLast()
    {
        if(head==null)
        return -1;
        return tail.data;
    }
    
    /*
        Detect If there is a loop in linked list- Floyd Cycle's algorithm
    */
    public int detectStartOfCycle(Node node)
    {
        // Define 2 pointers slow and fast
        Node slow=node;
        
        Node fast=node;
        boolean flag=false;
        while(slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
              flag=true;
              break;
            }
            
        }
        slow=node;
        if(flag)
        {
            while(slow!=fast)
            {
                slow=slow.next;
                fast=fast.next;
                if(slow==fast)
                break;
            }
            return slow.data;
        }else
        {
            return -1;
        }
    }
    
   
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
		LinkedList list=new LinkedList();
		list.addLast(10); 
        list.addLast(20); 
        list.addLast(30); 
        list.addLast(40);
        list.addLast(50);
  
        /*Create loop for testing */
        list.tail.next = list.head; 
        System.out.println(list.detectStartOfCycle(list.head));
	
	   
	}
}