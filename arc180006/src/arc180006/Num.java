
// Starter code for lp1.
// Version 1.0 (Monday, Jan 27).

// Change following line to your NetId
package arc180006;

import java.util.*;

public class Num implements Comparable<Num> {

    static long defaultBase = 10; // Change as needed
    static long base = defaultBase; // Change as needed
    long[] arr; // array to store arbitrarily large integers
    boolean isNegative; // boolean flag to represent negative numbers
    static boolean karatsuba = false;
    int len; // actual number of elements of array that are used; number is stored in
             // arr[0..len-1]

    private List<Long> list;

    Num() {
        list = new LinkedList<>();
    }

    public Num(String s) {
        //TODO
    }

    public Num(long x) {
        isNegative = false;

		// When x is Negative, making it positive with flag isNegative as true
		if (x < 0) {
			this.isNegative = true;
			x = -1 * x;
		}
		double lengthArr = 0;

		// When x = 0, lengthArr = -Infinity
		if (x == 0) {
			lengthArr = 1;
		}
		// No of digits in this.Num = log_base (x) + 1 = log(x)/log(base) + 1
		else {
			lengthArr = ((Math.log((double) x)) / (Math.log((double) base))) + 1;
		}

		this.len = (int) lengthArr; // Real to integer (floor function)
		arr = new long[this.len];

		long n = x;
		// Iteratively pass appropriate digit to this.arr (array of long)
		for (int i = 0; i < len; i++) {
			arr[i] = n % base();
			n /= base();
		}
    }

    public static Num add(Num a, Num b) {
        return null;
    }

    public static Num subtract(Num a, Num b) {
        return null;
    }

    public static Num product(Num a, Num b) {
        Num out = null;
        if(a.getList().size() == 0 || b.getList().size() == 0){
            return new Num(0L);
        }
        if(karatsuba){
            //karatsuba implementation

        }else{
           // Normal multiplication
        }

        out.isNegative = a.isNegative ^ b.isNegative;

        return out;
    }
    
	
    public static Num power(Num a, long n) {
		if(n < 0)
		{
			n = subtract(new Num(0), n);
			a = divide(1, a);
		}
		return powerHelper(a, n);
    }

    //use divide and conquer
    private Num powerHelper(Num a, long N)
    {
        //base
        if(n.compareTo(0) == 0) return 1;

        //logic
        Num temp = powerHelper(a, n / 2);
        if(n % 2 == 0)
            return multiply(temp,temp);
        else
            return multiply(a, multiply(temp,temp));
    }

    // Use binary search to calculate a/b
    public static Num divide(Num a, Num b) {
        return null;
    }

    // return a%b
    public static Num mod(Num a, Num b) {
        return null;
    }

    // Use binary search
    public static Num squareRoot(Num a) {
        //Edge Case
        if(a == null) return null;

        //Logic
        Num l = new Num(0), h = new Num(a.by2());

        while(compareNums(l , h) <= 1)
        {
            Num m = add(l, subtract(h, l).by2()); // calculate the mid point between l and h

            Num x =  m.multiply(m);  // keep a temporary variable equal to the square of m

            if(compareNum(x , a) == 1) return x; //found square root

            else if(compareNum(x, a) < 1) // x less than target
                l = add(m,1);

            else  //x more than target
                h = m.subtract(m,1);
        }
    }

    // Utility functions
    // compare "this" to "other": return +1 if this is greater, 0 if equal, -1
    // otherwise
    public int compareTo(Num other) {
        return 0;
    }

    // Output using the format "base: elements of list ..."
    // For example, if base=100, and the number stored corresponds to 10965,
    // then the output is "100: 65 9 1"
    public void printList() {
    }

    // Return number to a string in base 10
    public String toString() {
        return null;
    }

    public long base() {
        return base;
    }

    // Return number equal to "this" number, in base=newBase
    public Num convertBase(int newBase) {
        return null;
    }

    // Divide by 2, for using in binary search
    public Num by2() {
        return null;
    }

    // Evaluate an expression in postfix and return resulting number
    // Each string is one of: "*", "+", "-", "/", "%", "^", "0", or
    // a number: [1-9][0-9]*. There is no unary minus operator.
    public static Num evaluatePostfix(String[] expr) {
        return null;
    }

    public static Num evaluateInfix(String[] expr) {
        return null;
    }
    // Parse/evaluate an expression in infix and return resulting number
    // Input expression is a string, e.g., "(3 + 4) * 5"
    // Tokenize the string and then input them to parser
    // Implementing this method correctly earns you an excellence credit
    public static Num evaluateExp(String expr) {
        return null;
    }
    public List<Long> getList() {
        return list;
    }

    public static void main(String[] args) {
        Num x = new Num(999);
        Num y = new Num("80");
        Num z = Num.add(x, y);
        System.out.println(z);
        Num a = Num.power(x, 8);
        System.out.println(a);
        if (z != null)
            z.printList();
    }
}
