package gameOfNim;

import java.util.Random;
import java.util.Scanner;

/*
 * @author 16ypande
 * @date Nov 25 2013
 * @purpose Game of Nim - A game that involves picking marbles from a pile and trying not to pick the last marble.
 */

public class TheGameOfNim 
{
	static Random rand = new Random();
	static boolean difficulty = false;
	static int size = 0;
	public static void main (String[] args)
	{
		playgame();
	}
	public static void playgame ()
	{
		size = rand.nextInt(90) + 10;
		boolean player = rand.nextBoolean();
		System.out.println((player?"The computer starts." : "You start."));
		difficulty = rand.nextBoolean();
		System.out.println((difficulty?"The computer is playing smart." : "The computer is playing stupid."));
		while (size!=0)
		{
			if (player)
			{
				compmove();
				player = false;
			}
			else
			{
				usermove();
				player = true;
			}
		}
		System.out.println((player?"You picked the last marble. The computer wins." : "The computer picked the last marble. You win."));
	}
	public static void compmove()
	{
		System.out.println("There are " + size + " marbles in the pile.");
		if (difficulty)
		{
			if (clever())
				return;
			random();
		}
		else
			random();		
	}
	public static void usermove()
	{
		Scanner in = new Scanner(System.in);
		boolean incorrectmove = true;
		int move = 0;
		while (incorrectmove)
		{
			System.out.println("There are " + size + " marbles in the pile. How many would you like to take?");
			move = in.nextInt();
			if ((size==1&&move==1)|| move<=size/2&&move>=1)
				incorrectmove = false;
			else
				System.out.println("This move is incorrect. You cannot take 0 marbles and you cannot take more than half the marbles in the pile. Please try again.");
		}
		size-=move;
	}
	public static void random()
	{
		int take = rand.nextInt(size/2) + 1;
		size -= take;
		System.out.println("The computer took " + take + " marbles.");
	}
	public static boolean clever()
	{
		for (int i=0; i<=7; i++)
		{
			if (size == Math.pow(2,i)-1)
				return false;
			if (size<Math.pow(2, i))
			{
				int oldsize = size;
				size = (int) (Math.pow(2,i-1) - 1);
				System.out.println("The computer took " + (oldsize-size) + " marbles.");
				return true;
			}
		}
		return false;
	}
}
