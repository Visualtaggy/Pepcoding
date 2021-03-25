// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
// 3. Complete the body of pri tMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
import java.util.*;

public class MazePaths {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int n = scn.nextInt();
        System.out.print("Enter no. of coll: ");
        int m = scn.nextInt();

        printMazePaths(1, 1, n, m, "");
        scn.close();
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        // H
        if (sc < dc) {
            printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        }
        // V
        if (sr < dr) {
            printMazePaths(sr + 1, sc, dr, dc, psf + "v");
        }
    }
}
