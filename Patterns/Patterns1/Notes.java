package Patterns1;

public class Notes {
    /*
     * Before writing the code spend lot of time on structuring the code
     * and dry running it. this will make code cleaner and more efficient.
     * 
     * Pattern Solving Approach
     * 1. First figure out number of rows
     * 2. Second figure out number of columns
     * 3. figure out what to print on each place.
     * this approach will solve the half of problem.
     * 
     * General approach is for the no of rows we use outer loop without
     * PrintLn*
     * And for columns we use inner loops without ln i.e. normal print();
     * this will print the content on the same line and pattern will be formed
     * 
     * one more general approach is
     * For rows i.e. i or outer loop
     ** we loop from i = 1 to i<=n **
     * for columns the condition may vary.
     * for square pattern j= 1 to j<=n (i.e. same as n)
     ********* 
     * For Triangle pattern***********
     * there are two main types of triangle
     * 1. increasing
     * 2. decreasing
     ***
     * logic for increasing
     * outer loop i=1 to i<=n;
     * inner loop j=1 to j<=i; j++;
     ***
     * logic for decreasing
     * outer loop i=1 to i<=n;
     * inner loop j=i to j<=n; j++;
     ****** 
     * Solution********
     * for any triangle pattern
     * 1. Breakdown the pattern according to those 2 triangles.
     * then nest the loops accordingly.
     */

    /*
     * For printing the numbers a third variable P can be taken into the
     * consideration
     */

    /*
     * For Printing the Alphabets we have to use char calcuation
     * using ascii values suppose for printing B we'll do 'A'+1 and typecast
     * it to char
     * ex {(char)('A'+j-1)} this logic is for square char pattern Jth position.
     * ex {(char)('A'+i-1)} this logic is for square char pattern ith position.
     * for ith position increment value by typecasting {p = (char)(p+1)}
     */
}
