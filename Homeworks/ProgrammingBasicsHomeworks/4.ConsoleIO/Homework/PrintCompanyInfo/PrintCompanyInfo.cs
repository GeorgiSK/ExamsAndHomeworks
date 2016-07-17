using System;

class PrintCompanyInfo
{
    static void Main(string[] args)
    {
        string companyName = Console.ReadLine();
        string companyAddress = Console.ReadLine();
        string phoneNumber = Console.ReadLine();
        string faxNumber = Console.ReadLine();
        string website = Console.ReadLine();
        string managerFN = Console.ReadLine();
        string managerLN = Console.ReadLine();
        int managerAge = int.Parse(Console.ReadLine());
        string managerPhone = Console.ReadLine();


        Console.WriteLine(companyName);
        Console.WriteLine("Address: {0}", companyAddress);
        Console.WriteLine("Tel. {0}", phoneNumber);
        Console.WriteLine("Fax: {0}", faxNumber);
        Console.WriteLine("Web site: {0}", website);
        Console.WriteLine("Manager: {0}{1} (age: {2}, tel. {3})",managerFN, managerLN, managerAge, managerPhone);
    }
}

