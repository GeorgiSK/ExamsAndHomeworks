using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NullValuesArithmetic
{
    class Program
    {
        static void Main(string[] args)
        {
            int? varOne = null;
            double? varTwo = null;

            Console.WriteLine(varOne);
            Console.WriteLine(varTwo);

            varOne = varOne+ 5;
            varTwo = varOne + 99;

            Console.WriteLine(varOne);
            Console.WriteLine(varTwo);
        }
    }
}
