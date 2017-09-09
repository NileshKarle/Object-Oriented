package org.json.simple.parser;

import java.util.Random;
import java.util.Scanner;

/**
 * @author nilesh
 * 
 * @description A class to perform all the operations on the deck.
 *
 */
class Deck{
	String suit[]={"Clubs", "Diamonds", "Hearts", "Spades"};
	String rank[]={"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	String cards[]=new String[52];
	int i,j,k=0;
	Deck(){
		
	}
	/**
	 * makes a deck and stores it in a cards array.
	 */
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
	/**
	 * randomly suffles the deck in the cards array.
	 */
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
		/*for(k=0;k<cards.length;k++)
		{
		System.out.println(cards[k]);
	}*/
	}
	/**
	 * @param p is number of players.
	 * @param c is number of cards for each player.
	 * 
	 * @description collects the number of players and number of cards to be distributed for each player 
	 * and distributes the cards and displays on the screen.
	 */
	public void Distribute(int p,int c) {
		String players[][]=new String[p][c];
		int i=0,j,k;
		for(j=0;j<p;j++)
		{
			for(k=0;k<c;k++)
			{
				players[j][k]=cards[i];
				i++;
			}
		}
		for(j=0;j<p;j++)
		{
			System.out.println(" ");
			System.out.println("Player "+(j+1));
			
			for(k=0;k<c;k++)
			{
				System.out.println(players[j][k]);
			}
	}
}
}
public class CardDeck {
	
	public static void main(String[] args){
		
		Scanner scan=new Scanner(System.in);
Deck dck=new Deck();
dck.makeDeck();
dck.suffle();
System.out.println("enter the number of players ");
int n=scan.nextInt();
System.out.println("enter the number of cards for each player ");
int c=scan.nextInt();
if(n*c>52)
{
	System.out.println("cannot distribute");
	System.exit(0);
}
else
{
dck.Distribute(n,c);
}
}
}
