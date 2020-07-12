package day0711;

public class DayMain {

    static int addDigits(int num) {
        if (num < 10)
        return num;
        char[] chars = String.valueOf(num).toCharArray();
        num = 0;
        for (Character c : chars) {
            num += Integer.valueOf(c.toString());
        }
        return addDigits(num);
    }

    public static void main(String[] args) {
        System.out.println(addDigits(83));
    }
}
