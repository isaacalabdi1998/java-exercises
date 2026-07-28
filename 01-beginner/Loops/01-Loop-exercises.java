package loops;
public class LoopExercises
{


   /* Prints a multiplication table from 1 to n using nested loops. */
    public static void printMultiplicationTable(int n)
   {
       for (int row = 1;  row <= n;  row++)
       {
           for (int col = 1;  col <= n;  col++)
           {
               System.out.print((row * col) + "\t");
           }
           System.out.println();
       }
   }


    /*   Returns the sum of all numbers from 1 to n, but skips multiples of 3,
         and stops entirely if the running sum exceeds 100.   */
   public static int sumWithSkipAndStop(int n)
   {
       int sum = 0;
       for (int i = 1;  i <= n; i++)
       {
           if(i % 3 == 0)
           {
               continue;
           }
           sum += i;
           if(sum > 100)
           {
               break;
           }
       }
       return sum;
   }



    /*  Searches a 2D array for a target value. Returns a string "Found at [row][col]"
        or "Not found". Uses a labeled break to exit both loops once found.  */
   public static String findInMatrix(int[][] matrix, int target)
   {
       String result = "Not found";
       search:
            for (int row = 0;  row < matrix.length;  row++)
            {
                for (int col = 0;  col < matrix[row].length;  col++)
                {
                    if (matrix[row][col] == target)
                    {
                        result = "Found at [" + row + "][" + col + "]";
                        break search;
                    }
                }
            }

       return result;
   }



   /*  Computes the factorial of n using a loop with an accumulator.  */
   public static long factorial(int n)
    {
        long accumulator = 1;

        for (int i = 1;  i <= n;  i++)
        {
            accumulator *= i;
        }

        return accumulator;
    }



    /*  Prints a pyramid pattern of stars with the given number of rows. */
    public static void printPyramid(int rows)
    {
        for (int i = 0; i < rows; i++)
        {

            for (int j = 0; j < rows - i - 1; j++)
            {
                System.out.print(" ");
            }

            for (int j = 0; j < (2 * i + 1); j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }



    /*  Returns elements of the array in reverse order as a comma-separated string. */
    public static String iterateBackwards(int[] arr)
    {
        StringBuilder sb = new StringBuilder();
        for (int i =  arr.length - 1;  i >= 0;  i--)
        {
            sb.append(arr[i]);

            if (i != 0)
            {
                sb.append(", ");
            }
        }

        return sb.toString();
    }



    /*  Simulates a simple number guessing scenario. Keeps generating random numbers  between 1 and
         100 (inclusive) in an infinite loop until the target is hit. Returns how many attempts it took.*/
    public static int countUntilMatch(int target)
    {
        int attempts = 0;
        java.util.Random random = new java.util.Random();

        while (true)
        {
            attempts++;

            int number = random.nextInt(100) + 1;

            if (number == target)
            {
                break;
            }
        }

        return attempts;
    }






  

    ///  ------------------Main Method----------------
    public static void main(String[] args)
    {
      
        System.out.println("=== Multiplication Table (4x4) ===");
        LoopExercises.printMultiplicationTable(4);


        System.out.println("\n=== Sum with Skip and Stop (n=50) ===");
        System.out.println("Sum: " + LoopExercises.sumWithSkipAndStop(50));

      
        System.out.println("\n=== Find in Matrix ===");
        int[][] matrix = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
        System.out.println(LoopExercises.findInMatrix(matrix, 5));
        System.out.println(LoopExercises.findInMatrix(matrix, 99));

      
        System.out.println("\n=== Factorial ===");
        System.out.println("5! = " + LoopExercises.factorial(5));
        System.out.println("10! = " + LoopExercises.factorial(10));

      
        System.out.println("\n=== Pyramid (5 rows) ===");
        LoopExercises.printPyramid(5);

      
        System.out.println("\n=== Iterate Backwards ===");
        System.out.println(LoopExercises.iterateBackwards(new int[]{1, 2, 3, 4, 5}));

      
        System.out.println("\n=== Count Until Match ===");
        System.out.println("Attempts to find 42: " + LoopExercises.countUntilMatch(42));

    }
}



/*
       -------------------- Output --------------------
      
            === Multiplication Table (4x4) ===
            1	2	3	4	
            2	4	6	8	
            3	6	9	12	
            4	8	12	16	


            === Sum with Skip and Stop (n=50) ===
            Sum: 108

            
            === Find in Matrix ===
            Found at [1][1]
            Not found

            
            === Factorial ===
            5! = 120
            10! = 3628800


            === Pyramid (5 rows) ===
                *
               ***
              *****
             *******
            *********

            
            === Iterate Backwards ===
            5, 4, 3, 2, 1

            
            === Count Until Match ===
            Attempts to find 42: 182
   
   
   */
