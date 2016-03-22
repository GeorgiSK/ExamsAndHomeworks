using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BasketBattle
{
    class Program
    {
        static void Main(string[] args)
        {
            //variable declaration
            int firstPlayerPoints = 0;
            int secondPlayerPoints = 0;
            double roundCounter = 0;
            bool playerSwitched = true;
            int p;
            string second;
            string i;
            
            string first = Convert.ToString(Console.ReadLine());
            int n = Convert.ToInt32(Console.ReadLine());
            

            //names the players
            if (first == "Simeon")
            {
                second = "Nakov";
            }
            else
            {
                second = "Simeon";
            }

            //this loop switches rhe players every two turns and adds the points to their counters if they succeed
            for(int y = 0; y < n*2;y++)
            {
                roundCounter++;
                p = Convert.ToInt32(Console.ReadLine());
                i = Console.ReadLine();
                
                //switches the players
                if(y % 2 != 0)
                {
                    playerSwitched = !playerSwitched;
                }

                //adds the points
                if (i == "success")
                {
                    if (playerSwitched && firstPlayerPoints + p <= 500)
                    {
                        firstPlayerPoints += p;
                    }else if(!playerSwitched && secondPlayerPoints + p <= 500)
                    {
                        secondPlayerPoints += p;
                    }
                }

                //checks if someone has achieved the max score and prints the first output case on the console
                if (firstPlayerPoints == 500 )
                {
                    Console.WriteLine(first);
                    Console.WriteLine(Math.Ceiling(roundCounter / 2));
                    Console.WriteLine(secondPlayerPoints);
                    break;
                }else if(secondPlayerPoints == 500)
                {
                    Console.WriteLine(first);
                    Console.WriteLine(Math.Ceiling(roundCounter / 2));
                    Console.WriteLine(firstPlayerPoints);
                    break;
                }
            }

            //prints hte second output case
            if(firstPlayerPoints < 500 && firstPlayerPoints == secondPlayerPoints)
            {
                Console.WriteLine("DRAW");
                Console.WriteLine(firstPlayerPoints);
            }


            //prints the third output case
            if (firstPlayerPoints < 500 && secondPlayerPoints < 500)
            {
                if(firstPlayerPoints != secondPlayerPoints)
                {
                    if(firstPlayerPoints > secondPlayerPoints)
                    {
                        Console.WriteLine(first);
                        Console.WriteLine(firstPlayerPoints - secondPlayerPoints);
                    }else
                    {
                        Console.WriteLine(second);
                        Console.WriteLine(secondPlayerPoints - firstPlayerPoints);
                    }
                }
            }

        }
    }
}
