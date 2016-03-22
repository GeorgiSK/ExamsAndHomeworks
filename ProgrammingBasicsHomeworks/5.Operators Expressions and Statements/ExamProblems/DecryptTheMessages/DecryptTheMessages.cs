using System;
using System.Linq;

class DecryptTheMessages
{
    static void Main(string[] args)
    {
        string inputMessage = "start";
        int messageCounter = 0;

        string[] decryptedMessages = new string[100];

        while (inputMessage != "end" || inputMessage != "END")
        {
            inputMessage = Console.ReadLine();

            if (inputMessage == "start" || inputMessage == "START")
            {
                //looping untill the end keyword
                while (true)
                {
                    string encryptedMessage = Console.ReadLine();

                    if (encryptedMessage == "END" || encryptedMessage == "end")
                    {
                        inputMessage = "end";
                        break;
                    }
                    else
                    {
                        //checking if the encrypted message entered is valid
                        if (!String.IsNullOrEmpty(encryptedMessage))
                        {
                            messageCounter++;
                        }

                        //decrypting the message
                        for (int i = 0; i < encryptedMessage.Length; i++)
                        {
                            //checking if the char is a letter and decrypting it respectively
                            if (char.IsLetter(encryptedMessage[i]))
                            {
                                if (encryptedMessage[i] >= 65 && encryptedMessage[i] <= 77
                                    || encryptedMessage[i] >= 97 && encryptedMessage[i] <= 109)
                                {
                                    char var = (char)(encryptedMessage[i] + 13);
                                    decryptedMessages[messageCounter] += var;
                                }
                                else
                                {
                                    char var = (char)(encryptedMessage[i] - 13);
                                    decryptedMessages[messageCounter] += var;
                                }
                            }//checking if the char is a digit
                            else if (char.IsDigit(encryptedMessage[i]))
                            {
                                decryptedMessages[messageCounter] += encryptedMessage[i];
                            }

                            //checking for special characters
                            switch (encryptedMessage[i])
                            {
                                case (char)43:
                                    decryptedMessages[messageCounter] += " ";
                                    break;
                                case (char)37:
                                    decryptedMessages[messageCounter] += ",";
                                    break;
                                case (char)38:
                                    decryptedMessages[messageCounter] += ".";
                                    break;
                                case (char)35:
                                    decryptedMessages[messageCounter] += "?";
                                    break;
                                case (char)36:
                                    decryptedMessages[messageCounter] += "!";
                                    break;
                            }
                        }                        
                    }
                }
            }

            if (inputMessage == "END" || inputMessage == "end")
            {
                break;
            }
        }

        if (messageCounter > 0)
        {
            Console.WriteLine("Total number of messages: {0}", messageCounter);
        }
        else
        {
            Console.WriteLine("No message received.");
        }

        foreach (string i in decryptedMessages)
        {
            if (i != null)
            {
                Console.WriteLine("{0}", ReverseString(i));
            }
  
        }
    }

    static string ReverseString(string srtVarable)
    {
        return new string(srtVarable.Reverse().ToArray());
    }
}

