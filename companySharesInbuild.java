package org.json.simple.parser;

import java.util.LinkedList;
import java.util.Scanner;
class Node
{
    protected String data;
    protected Node link;
    public Node()
    {
        link = null;
        data = null;
    }    
    public Node(String d,Node n)
    {
        data = d;
       link = n;
    }    
    public void setLink(Node n)
    {
        link = n;
    }    
    public void setData(String d)
    {
        data = d;
    }    
    public Node getLink()
    {
        return link;
    }    
    public String getData()
    {
        return data;
    }
}
class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
    /*  Constructor  */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element at begining  */
    public void insertAtStart(String val)
    {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            nptr.setLink(start);
            start = nptr;
        }
        }
    
   
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getLink();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
           size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
           {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }  
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
       }
        Node ptr = start;
       System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
public class companySharesInbuild {
	public static void main(String []args){
		Scanner scan=new Scanner(System.in);
		linkedList ll=new linkedList();
		//LinkedList ll=new LinkedList();
		Update up=new Update();
		int value=0;
		while(value!=3)
		{
		System.out.println("enter 1 to add .");
		System.out.println("enter 2 to remove .");
		System.out.println("enter 3 to exit .");
		value=scan.nextInt();
		if(value==1)
		{
			System.out.println("enter the value ");
			String val=scan.next();
			ll.insertAtStart(val);
			ll.display();
			 //linkedList
			//ll=up.add(ll);
		}
		if(value==2)
		{
			System.out.println("enter the position to delete");
			int pos=scan.nextInt();
			//ll=up.remove(ll);
			ll.deleteAtPos(pos);
		}
		if(value==3)
		{
			System.out.println(" bye ");
			System.exit(0);
		}
		else
		{
			System.out.println("enter a valid input .");
		}
		}
	}

}
