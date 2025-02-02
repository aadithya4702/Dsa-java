package JavaTest;

public class PrimeCheck {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i * i <= n; i++) { // Check up to sqrt(n)
            if (n % i == 0) {
                return false; // If divisible by any number, not prime
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 29; // Example number
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
