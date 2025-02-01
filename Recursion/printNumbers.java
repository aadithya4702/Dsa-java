class printNumbers {

    // print numbers from 5 to 1 - 5,4,3,2,1

    public static void main(String[] args) {
        printNum(5);

    }

    private static void printNum(int i) {

        if (i == 0) {
            return;
        }
        System.out.println(i);
        printNum(i - 1);

    }
}