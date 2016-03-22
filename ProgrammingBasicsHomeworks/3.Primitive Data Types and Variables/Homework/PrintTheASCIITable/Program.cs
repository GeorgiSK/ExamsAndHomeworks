using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrintTheASCIITable
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;


            for (byte counter = 0; counter < 255; counter++)
            {
                Console.WriteLine((char)counter);
            }
        }
    }
}
