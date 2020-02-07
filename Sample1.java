package com.google.gson;

/*package maven_task_1;*/

import java.util.*;
class Chocolate 
{
	int cWeight;
	int cPrice;
	public Chocolate(int cWeight,int cPrice)
	{
		this.cWeight=cWeight;
		this.cPrice=cPrice;
	}
	public int getWeight()
	{
		return cWeight;
	}
	public int getPrice()
	{
		return cPrice;
	}
}

class Sweet
{
	int sWeight;
	int sPrice;
	public Sweet(int sWeight,int sPrice)
	{
		this.sWeight=sWeight;
		this.sPrice=sPrice;
	}
	public int getWeight()
	{
		return sWeight;
	}
	public int getPrice()
	{
		return sPrice;
	}
}

public class Sample1 
{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Chocolate> chocolates = new ArrayList<Chocolate>();
	static ArrayList<Chocolate> candies = new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets = new ArrayList<Sweet>();
	static HashMap<String,Integer> w = new HashMap<String,Integer>();
	static HashMap<String,Integer> p = new HashMap<String,Integer>();
	
	
	public static void main(String[] args)
	{
		inputChocolates();
		inputSweets();
		
		System.out.println("Total weight of the gift is:" + totalWeight());
		System.out.println("Enter the number to sort: 1. Price 2.  Weight");
		int t = sc.nextInt();
		
		if(t==1)
		{
			
			Comparator<Chocolate> comapareByPrice = (Chocolate c1, Chocolate c2) -> ((Integer) c1.getPrice()).compareTo(c2.getPrice());
			
			Collections.sort(chocolates, comapareByPrice);
		}
		else if(t==2)
		{
			
			Comparator<Chocolate> comapareByWeight = (Chocolate c1, Chocolate c2) -> ((Integer) c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(chocolates, comapareByWeight);
		}
	
		
		System.out.println("After sorting:");
		
		for(Chocolate chocolate : chocolates)
		{
			System.out.println(chocolate.getPrice());
		}
		range(t);
	}
	
	public static void inputChocolates()
	{
		System.out.println("Enter the number of chocolates in gifts:\n");
		
		int n = sc.nextInt();
		for(int i = 1; i<= n; i++)
		{
			System.out.println("Enter chocolate type: 1. Candy 2. Doublecandy");
			int chocolateType = sc.nextInt();
			System.out.println("Enter chocolate weight");
			int cWeight = sc.nextInt();
			System.out.println("Enter chocolate price");
			int cPrice = sc.nextInt(); 
			
			if(chocolateType==1)
			{
				System.out.println("Enter candy name");
				String cn=sc.next();
				if(w.containsKey(cn))
				{
					w.put(cn,(int)w.get(cn)+cWeight);
				}
				else
				{
					w.put(cn,cWeight);
				}
				if(p.containsKey(cn))
				{
					p.put(cn,(int)p.get(cn)+cPrice);
				}
				else
				{
					p.put(cn,cPrice);
				}
			}
			Chocolate choco = new Chocolate(cWeight,cPrice);
			chocolates.add(choco);
			if(chocolateType==1)
			{
				candies.add(choco);
			}
		}
	}
	
	
public static void inputSweets()
	{
		System.out.println("Enter the number of sweets in gifts:\n");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter the weight of the sweet");
			int sWeight = sc.nextInt();
			System.out.println("Enter the price of the sweet");
			int sPrice = sc.nextInt();
			Sweet sweet = new Sweet(sWeight,sPrice);
			sweets.add(sweet);
		}
	}
	
	public static int totalWeight()
	{
		int totalWeight = 0;
		for (Chocolate choco : chocolates)
		{
			totalWeight += choco.getWeight();
		}
		for(Sweet sweet : sweets)
		{
			totalWeight += sweet.getWeight();
		}
		return totalWeight;
	}
	
	public static void range(int t)
	{
		System.out.println("Let's find the range : ");
		int ll,ul;
		if(t==1)
		{
			System.out.println("Enter the lowerLimit of the price : ");
			ll = sc.nextInt();
			System.out.println("Enter the higherLimit of the price : ");
			ul = sc.nextInt();
			
			Set<Map.Entry<String,Integer>> candySet = p.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext())
			{
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentPrice = (int)candyElement.getValue();
				if(currentPrice>=ll && currentPrice<=ul)
				{
					System.out.println(candyElement.getKey());
				}
			}
		}
		else
		{
			System.out.println("Enter the lowerLimit of the weight : ");
			ll = sc.nextInt();
			System.out.println("Enter the higherLimit of the weight : ");
			ul = sc.nextInt();
				
			Set<Map.Entry<String,Integer>> candySet = w.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext())
			{
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentWeight = (int)candyElement.getValue();
				if(currentWeight>=ll && currentWeight<=ul)
				{
					System.out.println(candyElement.getKey());
				}
			}
		}
	}
	
}
