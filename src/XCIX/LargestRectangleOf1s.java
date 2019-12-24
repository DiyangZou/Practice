package XCIX;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
    /*
    The given matrix is not null and has size of M * N, M >= 0 and N >= 0
    */
        int m = matrix.length;
        int n = matrix[0].length;

        int result = maxRectangle(m,n,matrix);
        return result;

    }

    public int maxHist(int R,int C,int row[])
    {
        Deque<Integer> result = new LinkedList<>();
        int top_val;
        int max_area = 0;
        int area = 0;
        int i = 0;
        while (i < C)
        {
            if (result.isEmpty() || row[result.peek()] <= row[i])
                result.offerFirst(i++);

            else
            {
                top_val = row[result.peek()];
                result.pollFirst();
                area = top_val * i;

                if (!result.isEmpty())
                    area = top_val * (i - result.peek() - 1 );
                max_area = Math.max(area, max_area);
            }
        }
        while (!result.isEmpty())
        {
            top_val = row[result.peekFirst()];
            result.pollFirst();
            area = top_val * i;
            if (!result.isEmpty())
                area = top_val * (i - result.peekFirst() - 1 );

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
    public int maxRectangle(int R,int C,int A[][])
    {
        int result = maxHist(R,C,A[0]);
        for (int i = 1; i < R; i++)
        {
            for (int j = 0; j < C; j++)
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];
            result = Math.max(result, maxHist(R,C,A[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleOf1s s = new LargestRectangleOf1s();
        int result = s.largest(new int[][]{{0,1,1,0,1},{1,1,1,1,1},{0,1,1,1,1},{1,1,0,0,1}});
        System.out.print(result);
    }
}
