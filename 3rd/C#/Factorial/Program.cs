using System;
namespace Factorial
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Pleas insert the factorial you want to calculate: ");
            //Read the factorial as text and converting it to integer
            int factorial = Convert.ToInt32(Console.ReadLine());
            Calculate(factorial);
        }

        static void Calculate(int factorial)
        {
            //The watch is about to begin
            var watch = System.Diagnostics.Stopwatch.StartNew();
            int result = 1;
            for (int i = 2; i <= factorial; i++)
            {
                //Previous number times current number
                result = result * i;
            }
            watch.Stop();
            //The watch is about to stop
            var elapsedMs = watch.ElapsedMilliseconds;
            Console.WriteLine("The factorial of " + factorial + " is: " + result);
            Console.WriteLine("Facorial calculated with for loop took: " + elapsedMs +"ms");


            //The watch is about to begin
            watch = System.Diagnostics.Stopwatch.StartNew();
            result = 1;
            int j = 2;
            while(j <= factorial)
            { 
                result = result * j;
                j++;
            }
            watch.Stop();
            //The watch is about to stop
            elapsedMs = watch.ElapsedMilliseconds;
            Console.WriteLine("Facorial calculated with while loop took: " + elapsedMs + "ms");



        }
    }
}
