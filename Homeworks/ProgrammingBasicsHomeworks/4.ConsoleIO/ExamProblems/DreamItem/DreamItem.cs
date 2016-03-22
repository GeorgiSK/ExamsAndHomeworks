using System;

class DreamItem
{
    static void Main(string[] args)
    {
        string inputString = Console.ReadLine();

        char[] separationChar = {'\\'};
        string[] data = inputString.Split(separationChar);

        int totalDays = 0;
        double earnedMoney;
        double moneyLeft;
        switch (data[0])
        {
            case "Jan":
                totalDays = 21;
                break;
            case "Feb":
                totalDays = 18;
                break;
            case "Mar":
                totalDays = 21;
                break;
            case "Apr":
                totalDays = 20;
                break;
            case "May":
                totalDays = 21;
                break;
            case "June":
                totalDays = 20;
                break;
            case "July":
                totalDays = 21;
                break;
            case "Aug":
                totalDays = 21;
                break;
            case "Sept":
                totalDays = 20;
                break;
            case "Oct":
                totalDays = 21;
                break;
            case "Nov":
                totalDays = 20;
                break;
            case "Dec":
                totalDays = 21;
                break;

        }

        earnedMoney = (Convert.ToDouble(data[1]) * Convert.ToInt32(data[2])) * totalDays;      

        if (earnedMoney >= 700)
        {
            earnedMoney += earnedMoney / 10;
        }

        moneyLeft = earnedMoney - Convert.ToDouble(data[3]);

        if (moneyLeft >= 0)
        {
            Console.WriteLine("Money left = {0:0.00} leva.", moneyLeft);
        }
        else
        {
            Console.WriteLine("Not enough money. {0:0.00} leva needed.", Convert.ToDouble(data[3]) - earnedMoney);
        }


    }
}

