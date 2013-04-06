package utils;

public class Utilities
{
    //Following Method determines whether a string is convertable to a Double

    public static String convertable(String num)
    {
        try
        {
            double check = Double.parseDouble(num);
        }
        catch (NumberFormatException nfe)
        {
            if (num.equals(""))
            {
                return "Value Required";
            }
            else
            {
                return "Invalid Data!";
            }
        }
        return "ok";
    }

    //The Following method converts a string to a Double
    public static Double convert(String num)
    {
        return Double.parseDouble(num);
    }
}
