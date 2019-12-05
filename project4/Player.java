import java.util.Scanner;

public class Player
{
    char id;

    public Player()
    {
        this.id = 'O';
    }

    public Player(char character)
    {
        this.id = character;
    }

    public void setId(char character)
    {
        this.id = character;
    }

    public char getId()
    {
        return this.id;
    }

    public void move(Board board)
    {
        String move = "flag";
        Scanner keyboard = new Scanner(System.in);

        while(!board.isMoveAvailable(move))
        {
            System.out.print("Where would you like to play? ");
            move = keyboard.nextLine();
        }

        board.submitMove(move, this.id);
        board.printBoard();
    }
}