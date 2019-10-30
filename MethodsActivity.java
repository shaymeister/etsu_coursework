public class MethodsActivity
{
    public static void main(String[] args)
    {
        int[] ARRAY = {95, 44, 24, 13, 59, 23, 22, 3, 39, 7};

        System.out.println("Minimum: " + minimum(ARRAY)
                         + "\nMaximum: " + maximum(ARRAY)
                         + "\nAverage: " + average(ARRAY)); 
    }

    public static int minimum(int [] array)
    {
        int min = array[0];
        for(int element : array) min = Math.min(element, min);
        return min;
    }

    public static int maximum(int[] array)
    {
        int max = array[0];
        for(int element : array) max = Math.max(element, max);
        return max;
    }

    public static double average(int[] array)
    {
        double sum = 0;
        for(int element : array) sum += element;
        double avg = sum / array.length;
        return avg;
    }
}