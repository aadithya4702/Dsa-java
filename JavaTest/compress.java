package JavaTest;


public class compress {

    public static void main(String[] args) {

        String a = "aaabbaaccc";
        char checkChar = a.charAt(0);
        int currCount = 1;
        StringBuilder str = new StringBuilder();

        for (int i = 1; i < a.length(); i++) {
            if (checkChar == a.charAt(i)) {
                currCount++;
            } else {
                str.append(checkChar);
                str.append(currCount);
                checkChar = a.charAt(i);
                currCount = 1;
            }

        }
        str.append(checkChar).append(currCount);

        System.out.println("Compressesed string of " + a + " is : " + str.toString());
        revertToNormal(str.toString());
    }

    private static void revertToNormal(String string) {

        int count = 0;
        char curChar = ' ';
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                count = Character.getNumericValue(string.charAt(i)); // Correct conversion

                for (int j = 0; j < count; j++) {
                    str.append(curChar);
                }
            } else {
                curChar = string.charAt(i);
            }
        }
        System.out.println("After decompressing from " + string + " to " + str.toString());

    }
}
