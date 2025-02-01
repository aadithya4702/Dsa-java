package BinarySearchQuestions;

public class smallestLetter {

    public static void main(String[] args) {

        char target = 'j';
        char[] letters = { 'c', 'f', 'j' };

        System.out.println(nextGreatestLetter(letters, target));

    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int l = 0;
        int h = letters.length - 1;
        int mid = 0;

        if (target > letters[letters.length - 1]) {
            return letters[0];
        }
        while (l <= h) {
            mid = l + (h - l) / 2;

            if (letters[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return letters[l];

    }
}
