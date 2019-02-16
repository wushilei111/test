package serch;

import java.util.Arrays;

public class Serch {
    public static void main(String[] args) {
        int a[] = {1,3,4,6,7,9,10,13,15,16,18,20,21,24,26,29,33,36,39,45,47,55,65,73,77,79,82,84,87,92,94,95,99,1000};
        System.out.println(Arrays.toString(a));
        System.out.println(new InsertionSearch().insertionSearch(a,47,0,a.length-1));
        System.out.println(new FibonacciSearch().fibonacciSearch(a,47));

    }
}
