package org.json.simple.parser;

import java.util.HashMap;
import java.util.Scanner;

class Manage{
	
	HashMap<String,String> hm=new HashMap<String,String>();
	Scanner scan=new Scanner(System.in);
	void add()
	{
		System.out.println("enter name ");
		String name=scan.next();
		System.out.println("enter address ");
		String address=scan.next();
		System.out.println("enter number ");
		String number=scan.next();
		address+=" "+number;
		hm.put(name,address);
		System.out.println(hm);
	}
	void delete()
	{
		System.out.println("enter name to delete ");
		String name=scan.next();
		if(hm.containsKey(name)==true)
		{
			hm.remove(name);
		}
		System.out.println(hm);
	}
	void edit(){
		System.out.println("enter name to edit ");
		String name=scan.next();
		if(hm.containsKey(name)==true)
		{
			System.out.println("enter number ");
			String number=scan.next();
			System.out.println("enter address ");
			String address=scan.next();
			address+=" "+number;
			hm.put(name,address);
		}
		System.out.println(hm);
	}
	void search(){
		System.out.println("enter name to search ");
		String name=scan.next();
		if(hm.containsKey(name)==true)
		{
			System.out.println(hm.get(name));
		}
		else
		{
			System.out.println(" "+name+" not found.");
		}
		
	}
	
}
public class AddressSaved {
	public static void main(String []args) {
		
		Scanner scan=new Scanner(System.in);
		Manage m=new Manage();
		int i=0;
		while(i!=5)
		{
			System.out.println("1) Add ");
			System.out.println("2) delete ");
			System.out.println("3) edit ");
			System.out.println("4) search ");
			System.out.println("5) exit ");
			int swtch=scan.nextInt();
			if(swtch==1){
				m.add();
			}
			if(swtch==2){
				m.delete();
			}
			if(swtch==3){
				m.edit();
			}
			if(swtch==4){
				m.search();
			}
			if(swtch==5){
				System.out.println("program terminates successfully.");
				System.exit(0);
			}
			
		}
		
	}

}
