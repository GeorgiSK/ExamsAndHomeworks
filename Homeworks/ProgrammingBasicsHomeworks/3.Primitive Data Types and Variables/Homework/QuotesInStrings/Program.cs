using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuotesInStrings
{
    class Program
    {
        static void Main(string[] args)
        {
            //variable declaration
            string firstString = "The \"use\" of quotations causes difficulties.";
            string secondString = @"The ""use"" of quotations causes difficulties.";

            //prints the variable on the console
            Console.WriteLine(firstString);
            Console.WriteLine(secondString);
        }
    }
}
