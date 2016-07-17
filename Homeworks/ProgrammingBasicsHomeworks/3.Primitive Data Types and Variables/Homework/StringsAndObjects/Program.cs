using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringsAndObjects
{
    class Program
    {
        static void Main(string[] args)
        {
            //variable declaration
            string hello = "Hello";
            string world = "World";
            object concatenation = hello + " " + world;
            string helloWorld = (string)concatenation;
        }
    }
}
