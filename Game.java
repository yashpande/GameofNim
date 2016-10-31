package gameOfNim;
/*
 * @author 16ypande
 * @date Dec 9 2013
 * @purpose Game of Nim - A game where the objective is NOT to take the last piece.
 */
public class Game 
//Simply plays the next move until the pile is zero. 
{
	public static void main (String[] args)
	{
		Player curplayer = new Player();
		while (Pile.size!=0)
		{
			curplayer.nextmove();
		}
		System.out.println((Player.curplayer?"You picked the last marble. The computer wins." : "The computer picked the last marble. You win."));
	}
}
