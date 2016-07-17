using System;

class KingOfThieves
{
    static void Main(string[] args)
    {
        int sizeOfGem = int.Parse(Console.ReadLine());
        char typeOfGem = char.Parse(Console.ReadLine());

        //top section
        for (int i = 1; i < sizeOfGem; i += 2)
        {
            int x = 0;
            int y = 0;
            int z = 0;

            while (x < (sizeOfGem - i) / 2)
            {
                Console.Write("-");
                x++;
            }
            while ( y < i)
            {
                Console.Write("{0}", typeOfGem);
                y++;
            }
            while ( z < (sizeOfGem - i) / 2)
            {
                Console.Write("-");
                z++;
            }

            if (x + y + z == sizeOfGem)
            {
                Console.Write("\n");
            }
        }


        //middle + bottom section
       for (int i = sizeOfGem; i >= 1; i -= 2)
        {
            int x = 0;
            int y = 0;
            int z = 0;

            while (x < (sizeOfGem - i) / 2)
            {
                Console.Write("-");
                x++;
            }
            while (y < i)
            {
                Console.Write("{0}", typeOfGem);
                y++;
            }
            while (z < (sizeOfGem - i) / 2)
            {
                Console.Write("-");
                z++;
            }

            if (x + y + z == sizeOfGem)
            {
                Console.Write("\n");
            }
        }
    }
}

