import java.util.Scanner;

public class Player
{
    char id;

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
        String move = null;
        Scanner keyboard = new Scanner(System.in);

        do
        {
            System.out.print("Where would you like to play?");
            move = keyboard.nextLine();
        } while(!board.isMoveValid(move) && !board.isMoveAvailable(move));

        board.submitMove(move);
    }

    public boolean isMoveValid(String move)
    {
        return true;
    }
}