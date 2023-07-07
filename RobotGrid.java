import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

public class RobotGrid {
    // Placeholder code for the main implementation class
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
    // Calculates the total number of safe squares in the 2D grid that are reachable by the robot
    public static int totalSafeSquares() {
        int count = 0;
        boolean[][] visited = new boolean[101][101]; // Keep track of visited squares
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 1, 0, -1}; // Possible movements: right, down, left, up
        int[] dy = {1, 0, -1, 0};

        // Start BFS from the initial position (0, 0)
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            // Check if the current square is safe
            if (isSafe(x, y)) {
                count++;

                // Explore the neighboring squares
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // Check if the neighboring square is within the grid bounds and hasn't been visited
                    if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
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
