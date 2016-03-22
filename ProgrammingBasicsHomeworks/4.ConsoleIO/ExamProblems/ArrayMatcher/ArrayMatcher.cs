using System;

class ArrayMatcher
{
    static void Main(string[] args)
    {
        string inputString = Console.ReadLine();

        char[] separationChar = { '\\' };
        string[] data = inputString.Split(separationChar);

        char[] firstString = data[0].ToCharArray();
        char[] secondString = data[1].ToCharArray();
        string outputString = "";

        switch (data[2])
        {
            case "join":
                outputString = Join(firstString, secondString);
                break;
            case "right exclude":
                outputString = RightExclude(firstString, secondString);
                break;
            case "left exclude":
                outputString = LeftExclude(firstString, secondString);
                break;
        }

        foreach(char i in StringRearangeAscendingASCII(outputString))
        {
            Console.Write(i);
        }
        Console.WriteLine();
    }

    static string Join(char[] firstArray, char[] secondArray)
    {
        string result = "";

        for (int i = 0; i < firstArray.Length; i++)
        {
            for (int y = 0; y < secondArray.Length; y++)
            {
                if (firstArray[i] == secondArray[y])
                {
                    result += firstArray[i];
                    break;
                }
            }
        }

        return result;

    }

    static string RightExclude(char[] firstArray, char[] secondArray)
    {
        string result = "";
        for (int i = 0; i < firstArray.Length; i++)
        {
            int counter = 0;
            for (int y = 0; y < secondArray.Length; y++)
            {
                if (firstArray[i] == secondArray[y])
                {
                    counter++;
                    break;
                }
            }

            if (counter == 0)
            {
                result += firstArray[i];
            }
        }
        return result;

    }

    static string LeftExclude(char[] firstArray, char[] secondArray)
    {
        string result = "";
        for (int i = 0; i < secondArray.Length; i++)
        {
            int counter = 0;
            for (int y = 0; y < firstArray.Length; y++)
            {
                if (secondArray[i] == firstArray[y])
                {
                    counter++;
                    break;
                }
            }

            if (counter == 0)
            {
                result += secondArray[i];
            }
        }
        return result;

    }

    static char[] StringRearangeAscendingASCII(string inputString)
    {
        char[] data = inputString.ToCharArray();
        bool swapped;
        do
        {
            swapped = false;
            for (int i = 0; i < data.Length - 1; i++)
            {
                if (data[i] > data[i + 1])
                {
                    char temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        
        return data;
    }
}

