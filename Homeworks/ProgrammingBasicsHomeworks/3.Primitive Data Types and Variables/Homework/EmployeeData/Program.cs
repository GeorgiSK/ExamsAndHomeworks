using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeData
{
    class Program
    {
        static void Main(string[] args)
        {
            //variable declaration
            string firstName = "Amanda";
            string lastName = "Jonson";
            byte age = 27;
            char gender = 'f';
            long personalID = 8306112507;
            int employeeNum = 27563571;

            //prints hte varuiables on the console
            Console.WriteLine("First name: " + firstName);
            Console.WriteLine("Last name: "  + lastName);
            Console.WriteLine("Age: " + age);
            Console.WriteLine("Gender: " + gender);
            Console.WriteLine("Personal ID: " + personalID);
            Console.WriteLine("Unique Employee number: " + employeeNum);
        }
    }
}
