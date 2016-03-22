using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExchangeVariableValues
{
    class Program
    {
        static void Main(string[] args)
        {
            //variable declaration
            int a = 5;
            int b = 10;

            //prints the values before inversion
            Console.WriteLine("Before:");
            Console.WriteLine("a = " + a);
            Console.WriteLine("b = " + b);

            //inverses values
            a = a + b;
            b = a - b; 
            a = a - b;

            //prints the variables after inversion
            Console.WriteLine("After:");
            Console.WriteLine("a = " + a);
            Console.WriteLine("b = " + b);


        }
    }
}
