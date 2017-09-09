package org.json.simple.parser;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class Pack{
	String suit[]={"Clubs", "Diamonds", "Hearts", "Spades"};
	String rank[]={"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	String cards[]=new String[52];
	int i,j,k=0;
	Queue<String> q=new LinkedList<String>();
	Queue<String> play=new LinkedList<String>();
	String players[][]=new String[4][9];
	Pack(){
		play.add("player1");
		play.add("player2");
		play.add("player3");
		play.add("player4");
	}
	public void makeDeck()
	{
		for(i=0;i<suit.length;i++)
		{
			for(j=0;j<rank.length;j++)
			{
				cards[k]=suit[i]+rank[j];
				k++;
			}
		}
	}
	public void suffle()
	{
		k=0;
		while(k<=40){
			
			Random r=new Random();
			int random1=r.nextInt(52);
			int random2=r.nextInt(52);
			if(random1!=random2)
			{
				String temp=cards[random1];
				cards[random1]=cards[random2];
				cards[random2]=temp;		
			}
			k++;
		}
			
	}
	public void Distribute() {
		
		String Arrange[]=new String[9];
		int i=0,j=0,k=9;
		while(j<=36)
		{
			for(i=0;i<9;i++)
			{
				Arrange[i]=cards[j];
				j++;
			}
		Sort(Arrange);
		}
		
}
	private void Sort(String arrange[]) {
		int i;
		
		for(i=0;i<arrange.length;i++)
		{
			if(arrange[i].contains("2")==true)
					{
				       q.add(arrange[i]);
					}
		}
		for(i=0;i<arrange.length;i++)
		{
			if(arrange[i].contains("3")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("4")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("5")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("6")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("7")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("8")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("9")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("10")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("Jack")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			 if(arrange[i].contains("Queen")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{
			if(arrange[i].contains("King")==true)
			{
		       q.add(arrange[i]);
			}
		}
		for(i=0;i<arrange.length;i++)
		{ 
			if(arrange[i].contains("Ace")==true)
			{
		       q.add(arrange[i]);
			}
		}
		
	}
	public void Display() {
		for(j=0;j<4;j++)
		{
			System.out.println(" ");
			System.out.println(play.poll());
			
			for(k=0;k<9;k++)
			{
				System.out.println(q.poll());
			}
	}
	
	}
}

public class ArrangCards {
	
public static void main(String[] args){
	
Scanner scan=new Scanner(System.in);
Pack dck=new Pack();
dck.makeDeck();
dck.suffle();
dck.Distribute();
dck.Display();
}

}
