using System;

class MagicWand
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int topTriangleVarOne = (3 * n + 3) / 2;
        int topTrianglevarTwo = topTriangleVarOne;
        int topPartBottomOne = 2;
        int topPartBottomTwo = (3 * n + 2) - 1;
        int[] topPartBottomArray = { topPartBottomOne - 1, topPartBottomOne + 2,
            topTriangleVarOne, topTrianglevarTwo,topPartBottomTwo - 2, topPartBottomTwo + 1};
        //top part
        for (int i = 1; i <= 3 * n + 1; i++)
        {
            //top trianglepart
            if (i < n)
            {
                for (int y = 1; y <= 3 * n + 2; y++)
                {
                    if (y == topTriangleVarOne || y == topTrianglevarTwo)
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(".");
                    }
                }
                topTriangleVarOne++;
                topTrianglevarTwo--;
                Console.WriteLine();
            }//The bottom part of the top part #1
            else if (i > n && i <= (3 * n) / 2)
            {
                for (int z = 1; z <= 3 * n + 2; z++)
                {
                    if (z == topPartBottomOne || z == topPartBottomTwo)
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(".");
                    }
                }
                topPartBottomOne++;
                topPartBottomTwo--;
                Console.WriteLine();
            }//The bottom part of the top part #2
            else if (i > (3 * n) / 2 && i < (3 * n + 2) - (n + 1))
            {
                for (int t = 1; t <= 3 * n + 2; t++)
                {
                    if (t == topPartBottomArray[0] || t == topPartBottomArray[1]
                        || t == topPartBottomArray[2] || t == topPartBottomArray[3]
                        || t == topPartBottomArray[4] || t == topPartBottomArray[5])
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(".");
                    }
                }
                topPartBottomArray[0]--;
                topPartBottomArray[1]--;
                topPartBottomArray[4]++;
                topPartBottomArray[5]++;
                Console.WriteLine();
            }// middle part of the top part
            else
            {
                for (int x = 1; x <= 3 * n + 2; x++)
                {
                    if (x <= topTrianglevarTwo || x >= topTriangleVarOne)
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(".");
                    }
                }
                Console.WriteLine();
            }
        }
    }
}

