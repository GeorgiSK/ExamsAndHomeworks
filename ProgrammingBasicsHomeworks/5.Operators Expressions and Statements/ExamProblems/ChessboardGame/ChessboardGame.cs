using System;

class ChessboardGame
{
    static void Main(string[] args)
    {
        //Getting input
        int n = int.Parse(Console.ReadLine());
        string inputString = Console.ReadLine();

        int teamBlack = 0;
        int teamWhite = 0;
        int winnerPoints = 0;
        int loserPoints = 0;
        string winner;


        for (int i = 0; i < inputString.Length; i++)
        {
            if (i >= n * n)
            {
                break;
            }
            //assigning values to the grid
            if (inputString[i] >= 48 && inputString[i] <= 57
                || inputString[i] >= 65 && inputString[i] <= 90
                || inputString[i] >= 97 && inputString[i] <= 122)
            {
                if (i % 2 == 0)
                {
                    if (inputString[i] >= 48 && inputString[i] <= 57
                        || inputString[i] >= 97 && inputString[i] <= 122)
                    {
                        teamBlack += inputString[i];
                    }
                    else
                    {
                        teamWhite += inputString[i];
                    }

                }
                else
                {
                    if (inputString[i] >= 48 && inputString[i] <= 57
                        || inputString[i] >= 97 && inputString[i] <= 122)
                    {
                        teamWhite += inputString[i];
                    }
                    else
                    {
                        teamBlack += inputString[i];
                    }
                }

            }

        }

        //determining the winner
        if (teamWhite > teamBlack)
        {
            winner = "white team";
            winnerPoints = teamWhite;
            loserPoints = teamBlack;
            Console.WriteLine("The winner is: {0}", winner);
            Console.WriteLine("{0}",winnerPoints - loserPoints);
        } else if(teamWhite < teamBlack)
        {
            winner = "black team";
            winnerPoints = teamBlack;
            loserPoints = teamWhite;
            Console.WriteLine("The winner is: {0}", winner);
            Console.WriteLine("{0}", winnerPoints - loserPoints);
        }
        else 
        {
            Console.WriteLine("Equal result: {0}", teamBlack);
        }

    }
}

