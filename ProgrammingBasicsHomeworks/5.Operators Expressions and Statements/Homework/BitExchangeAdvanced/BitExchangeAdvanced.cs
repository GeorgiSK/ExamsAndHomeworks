using System;

class BitExchangeAdvanced
{
    static void Main(string[] args)
    {
        uint n = uint.Parse(Console.ReadLine());
        int p = int.Parse(Console.ReadLine());
        int q = int.Parse(Console.ReadLine());
        int k = int.Parse(Console.ReadLine());

        int length = (p + k - 1) - p;
        for (int i = 0; i <= length; i++)
        {
            n = BitSwap(n, p + i, q + i);
        }

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


