using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TorrentPirate
{
    class Program
    {
        static void Main(string[] args)
        {
            //variable declaration
            int sizeOfMovie = 1500;
            int wifiSpeed = 2;
            double numOfMovies;
            double downloadCost;
            double downloadTime;
            double cinemaCost;
            double resultCost;
            string resultPlace;

            //getting the input
            int d = Convert.ToInt32(Console.ReadLine());
            int p = Convert.ToInt32(Console.ReadLine());
            int w = Convert.ToInt32(Console.ReadLine());

            //equasions
            numOfMovies = Convert.ToDouble(d) / sizeOfMovie;
            downloadTime = Convert.ToDouble(d) / Convert.ToDouble(wifiSpeed) / 60 / 60;
            downloadCost = downloadTime * w;
            cinemaCost = numOfMovies * p;

            //result check
            if (downloadCost > cinemaCost)
            {
                resultCost = cinemaCost;
                resultPlace = "cinema";
            }
            else
            {
                resultCost = downloadCost;
                resultPlace = "mall";
            }

            //console print
            Console.WriteLine(resultPlace + " -> {0:0.00}lv", resultCost);

        }
    }
}