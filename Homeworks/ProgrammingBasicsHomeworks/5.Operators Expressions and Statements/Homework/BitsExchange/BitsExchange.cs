using System;

class BitsExchange
{
    static void Main(string[] args)
    {
        uint n = uint.Parse(Console.ReadLine());

        n = BitSwap(n, 3, 24);
        n = BitSwap(n, 4, 25);
        n = BitSwap(n, 5, 26);

        Console.WriteLine(n);

    }

    static public uint GetBitAtPosition(uint n, int p)
    {
        uint nRightP = n >> p;
        uint bit = nRightP & 1;
        return bit;
    }

    static public uint PutZero(uint n, int p)
    {
        uint mask = ~((uint)1 << p);
        uint result = n & mask;
        return result;
    }

    static public uint PutOne(uint n, int p)
    {
        uint mask = (uint)1 << p;
        uint result = n | mask;
        return result;
    }

    static public uint BitSwap(uint n, int firstPosition, int secondPosition)
    {
        uint firstBit = GetBitAtPosition(n, firstPosition);
        uint secondBit = GetBitAtPosition(n, secondPosition);

        if (firstBit != secondBit)
        {
            uint result;
            if (firstBit == 0)
            {
                result = PutZero(n, secondPosition);
            }
            else
            {
                result = PutOne(n, secondPosition);
            }

            if (secondBit == 0)
            {
                result = PutZero(result, firstPosition);
            }
            else
            {
                result = PutOne(result, firstPosition);
            }
            return result;
        }
        else
        {
            return n;
        }
        
    }

}

