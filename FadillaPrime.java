import java.util.Scanner;

record PrimeCheckResult(boolean isPrime, int divisor) {
}

public class FadillaPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================== Checking Prime Numbers ===========================\n");

        System.out.print("Please Input A Round Number: ");
        int numberChecked = scanner.nextInt();

        PrimeCheckResult checkResult = primeNumberChecker(numberChecked);
        if (checkResult.isPrime()) {
            System.out.println(numberChecked + " is a prime number\n");
        } else {
            System.out.println(numberChecked + " is not a prime number because it can be divided by "
                    + checkResult.divisor() + "\n");
        }

    }

    public static PrimeCheckResult primeNumberChecker(int numberChecked) {
        // numbers 1 and less than 1 are not prime
        if (numberChecked <= 1) {
            return new PrimeCheckResult(false, numberChecked);
        } else {
            for (int i = 2; i <= Math.sqrt(numberChecked); i++) {
                // if it has a divisor other than itself and 1 then it is not a prime number
                if (numberChecked % i == 0) {
                    return new PrimeCheckResult(false, i);
                }
            }
        }

        return new PrimeCheckResult(true, -1);
    }
}