using System;

class BookProblem
{
    static void Main(string[] args)
    {
        const int DaysInMonth = 30;
        const int MonthsInYear = 12;

        int pages = int.Parse(Console.ReadLine());
        int campDays = int.Parse(Console.ReadLine());
        int pagesPerDay = int.Parse(Console.ReadLine());

        if (campDays == 30 || pagesPerDay == 0)
        {
            Console.WriteLine("never");
            return;
        }

        int readingDaysInAMonth = DaysInMonth - campDays;
        int pagesPerMonth = pagesPerDay * readingDaysInAMonth;

        int totalMonths = (int)Math.Ceiling((double)pages / pagesPerMonth);

        int numOfMonthsNeeded = totalMonths % MonthsInYear;
        int numOfYearsNeeded = totalMonths / MonthsInYear;
        
        
        Console.WriteLine("{0} years {1} months", numOfYearsNeeded, numOfMonthsNeeded);
        
    }
}

