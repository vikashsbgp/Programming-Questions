package main.java.geeksforgeeks.string;

public class SmallestNumber {

    public static  String smallestNumberWithSumOfDigitsAsN(int n) {
        StringBuilder sb = new StringBuilder("");

        if (n < 10) {
            sb.append(n + "");
            sb.setLength(n + 1);
            sb.append("0", 1, 1 + n);
        }
        else {
            int q = 0, r = 0;
            if (n % 9 == 0) {
                q = n / 9;
                sb.setLength(q + n);
                sb.append("9", 1, 1 + q);
            }
            else {
                r = n % 9;
                q = n / 9;
                sb.setLength(r + q + n);
                sb.append(r + "");
                sb.append("9", 2, 2 + q);
            }
            sb.append("0", sb.length(), n + sb.length());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(SmallestNumber.smallestNumberWithSumOfDigitsAsN(22));
    }

}
