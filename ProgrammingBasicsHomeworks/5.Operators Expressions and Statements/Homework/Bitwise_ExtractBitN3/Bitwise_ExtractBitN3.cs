using System;

class Bitwise_ExtractBitN3
{
    static void Main(string[] args)
    {
        uint n = uint.Parse(Console.ReadLine());

        
        uint nRight = n >> 3;
        uint bit = nRight & 1;

        Console.WriteLine(bit);
    }
}

