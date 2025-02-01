public class fibo {

    public static void main(String[] args) {
        System.out.println(fibonaci(7));
    }

    private static int fibonaci(int i) {

        if (i < 2) {
            return i;
        }

        return fibonaci(i - 1) + fibonaci(i - 2);

    }
}
