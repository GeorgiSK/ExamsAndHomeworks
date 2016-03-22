using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dumbbell
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            string middle = new string('.', n);
            string beginning = new string('.', n / 2) + new string('&', n / 2 + 1);
            string end = new string('&', n / 2 + 1) + new string('.', n / 2);

            Console.WriteLine(beginning + middle + end);

            for (int i = 0; i < n / 2 - 1; i++)
            {
                string beginningg = new string('.', n / 2 - i - 1) + "&" + new string('*', n / 2 + i ) + "&" ;
                string endd = "&" + new string('*', n / 2 + i) + "&" + new string('.', n / 2 - i - 1);
                Console.WriteLine( beginningg + middle + endd);
            }


            string midLineBegin = "&" + new string('*', n - 2) + "&"; 
            string midLineEnd = "&" + new string('*', n - 2) + "&";
            string midLineMid = new string('=', n);
            Console.WriteLine(midLineBegin + midLineMid + midLineEnd);

            for (int i =  n / 2 - 1; i > 0; i--)
            {
                string beginninggg = new string('.', n / 2 - i) + "&" + new string('*', n / 2 + i - 1) + "&";
                string enddd = "&" + new string('*', n / 2 + i - 1) + "&" + new string('.', n / 2 - i);

                Console.WriteLine(beginninggg + middle + enddd);
            }



            Console.WriteLine(beginning + middle + end);
        }
    }
}
