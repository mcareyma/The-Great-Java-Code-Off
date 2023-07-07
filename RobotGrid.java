public class RobotGrid {

    public static int calculateDigitSum(int num)
    {
        num = Math.abs(num);
        int sum = 0;

        while (num != 0)
        {
            sum = sum + num % 10;
            num = num/10;
        }
        return sum;
    }

    // Determines whether a given coordinate (x, y) is safe to visit
    public static boolean isSafe(int x, int y) {
        int sum = calculateDigitSum(x) + calculateDigitSum(y);
        return sum <= 23;
    }

    // Calculates the total number of safe squares in the 2D grid
    public static int totalSafeSquares() {
        int count = 0;

        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                if (isSafe(x, y)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {


        System.out.println(totalSafeSquares());


    }

    public int shortestSafeJourney(int a, int b, int x, int y) {
        // TODO: Add implementation logic here
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
