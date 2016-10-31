package gameOfNim;

import java.util.Random;
//Creates a new number which is the size of the pile. Methods include removing numbers from the pile and telling whether a certain move is valid.
public class Pile 
{
	static Random rand = new Random();
	static int size = 0;
	public Pile()
	{
		size = rand.nextInt(90) + 10;
	}
	public void dispsize()
	{
		System.out.println((size==1)?("There is one marble in the pile."):("There are " + size + " marbles in the pile."));
	}
	public void remove (int toremove)
	{
		size -= toremove;
	}
	public boolean canberemoved (int move)
	{
		if ((size==1&&move==1)|| move<=size/2&&move>=1)
			return true;
		return false;
	}
	public int getsize()
	{
		return size;
	}
}
