using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IsoscelesTriangle
{
    class Program
    {
        static void Main(string[] args)
        {
            //variable declaration
            char copywrite = '\u00A9';

            //prints the variable on the console
            Console.WriteLine(" " + " " + " " + copywrite);
            Console.WriteLine(" " + " " + copywrite + " " + copywrite);
            Console.WriteLine(" " + copywrite + " " + " " + " " + copywrite);
            Console.WriteLine(copywrite + " " + copywrite + " " + copywrite + " " + copywrite);

        }
    }
}
