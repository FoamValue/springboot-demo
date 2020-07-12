package day0711;

public class DayMain02 {

    public static int multiply(int A, int B) {
        if (B == 0) return 0;
        return A + multiply(A, --B);
    }

    public static void main(String[] args) {
        System.out.println(multiply(10, 2));
    }


}
