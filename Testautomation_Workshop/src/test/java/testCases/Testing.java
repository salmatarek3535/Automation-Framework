package testCases;

import java.util.Arrays;

public class Testing {

    public static void main(String args[])
    {
        String test= "salma";
        int arr[]= {1,5,3,4};
        test= reverseString(test);
        System.out.println(test);

        swap(10,20);

        System.out.println(removeSpaces("Sa lm a "));

        String test2= " salma  ";
        System.out.println(test2.trim());

        System.out.println(Arrays.toString(sortArray(arr)));


    }

    public static String reverseString(String input)
    {
        if(input== null)
        {
            throw new IllegalArgumentException("not valid argument");
        }
        char chars[]= input.toCharArray();
        StringBuilder output= new StringBuilder();

        for(int i=chars.length-1;i>=0;i--)
        {
            output.append(chars[i]);
        }

        return output.toString();
    }

    public static void swap(int num1, int num2)
    {
        System.out.println("number 1 before swap "+ num1+ " number 2 before swap "+num2);

        num1= num2+num1;
        num2= num1-num2;
        num1= num1-num2;

        System.out.println("number 1 after swap "+ num1+ " number 2 after swap "+num2);
    }

    public static String removeSpaces(String input)
    {
        char chars[]= input.toCharArray();
        StringBuilder output= new StringBuilder();

        for(char c:chars)
        {
            if(!Character.isWhitespace(c))
            {
                output.append(c);
            }
        }

        return output.toString();
    }

    public static int[] sortArray(int array[])
    {
        Arrays.sort(array);
        return array;
    }
}
