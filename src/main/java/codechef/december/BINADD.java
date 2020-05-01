package codechef.december;

public class BINADD {

    public static int addition(int A, int B) {

        while (B > 0) {

            int U = A ^ B;
            int V = A & B;
            A = U;
            B = V * 2;

            System.out.println("U = " + U + " V = " + V);

        }
        System.out.println("*********************");
        return A;
    }
    public static void main(String[] args) {
        int A = 3, B = 2;
        System.out.println(addition(A, B));
    }

}
