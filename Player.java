package gameOfNim;

import java.util.Random;
import java.util.Scanner;
/*
 * Removes numbers from the pile based on certain constraints. The compmove method removes numbers either randomly or using a certain algorithm, 
 * while the usermove method removes numbers based on a user input.
 */
public class Player 
{
	static Random rand = new Random();
	static boolean curplayer;
	static boolean difficulty;
	static Pile pile = new Pile();
	public Player()
	{
		curplayer = rand.nextBoolean();
		difficulty = rand.nextBoolean();
		System.out.println((curplayer?"The computer starts." : "You start."));
		System.out.println((difficulty?"The computer is playing smart." : "The computer is playing stupid."));
	}
	public void nextmove()
	{
		if (curplayer)
		{
			compmove();
			curplayer = false;
		}
		else
		{
			usermove();
			curplayer = true;
		}
	}
	public static void compmove()
	{
		pile.dispsize();
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
			pile.dispsize();
			System.out.println("How many marbles would you like to take?");
			move = in.nextInt();
			if (pile.canberemoved(move))
				incorrectmove = false;
			else
				System.out.println("This move is incorrect. You cannot take 0 marbles and you cannot take more than half the marbles in the pile. Please try again.");
		}
		pile.remove(move);
	}
	public static void random()
	{
		int take = ((pile.getsize()==1)?1:(rand.nextInt(pile.getsize()/2) + 1));
		pile.remove(take);
		System.out.println("The computer took " + take + ((take==1)?" marble.":" marbles."));
	}
	public static boolean clever()
	{
		for (int i=0; i<=7; i++)
		{
			if (pile.getsize() == Math.pow(2,i)-1)
				return false;
			if (pile.getsize()<Math.pow(2, i))
			{
				int take = (int) (pile.getsize() - (Math.pow(2,i-1) - 1));
				System.out.println("The computer took " + take + " marbles.");
				pile.remove(take);
				return true;
			}
		}
		return false;
	}
}
