/*
 * In the following code, the program works without having to create any "Echo" objects
 * The virtual Machine executes the main method Directly on the "Echo" class (not via an "Echo" object)
 * This is because the main method is declared static
 */
public class Echo {
    public static void main(String[] args)
    throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        String line = br.readLine();
        System.out.println(line);
    }
}
/*
 * Calling the main method directly on the class makes the design NOT object-oriented
 * Object orientation implies that there is an object or an instance of which a field is accessed, or on which a method is executed
 */

// An extreme use of static methods is in the java.lang.Math class in which every
single method is static
public class Math {
    public static float abs(float a) {...}
    ...
    public static int max(int a, int b) {...}
    ...
    public static double sqrt(double a) {...}
    ...
}

/*
 * The reason is that every method implements a self-sufficient mathematical function with inputs and result
 * once the function returns, there is nothing to be kept around (as in a field of an object) for later recall/use.
 * In other words there is no state to be maintained
 */
// The Math methods can be called directly on the class, for example:
double sqroot = Math.sqrt(35);
// In fact, you CANNOT create an instance of the Math class - “instantiation” is not allowed

/*
 * Math is a “utility” class because all methods are static or “utility” methods
 * the class is just an umbrella under which a whole lot of math functions are gathered together
 */
public class Math {
    ...
    // final means it can be never be assigned to afterward, so initialization MUST be done at declaration time (hence, a constant)
    public static final double E ...
    public static final double PI ...
    ...
}
// Because of the "final" we cannot do something like this:
Math.PI = Math.PI * 2;
//Since the constants are static, they can be accessed via class names (without objects):
double area = Math.PI * radius * radius;

public class Tiger {
    public static final int MAX_COUNT = 10;
    public static final int MAX_MASS = 2000;
    // The variable "count" is the class property and is shared by all instances
    private static int count = 0;
    public Tiger(int mass)
    throws Exception { // The following is a This is a "checked" exception, so the constructor must declare a throws
        if (count == MAX_COUNT) {
            throw new Exception("Max count exceeded");
        }
        if (mass < 0 || mass > MAX_MASS) {
            throw new IllegalArgumentException("Unacceptable mass"); // This is an "Unchecked/runtime" exception, no throws declaration needed (but it is a subclass of Exception, so is covered by the throws Exception declaration)
        }
        count++;
    }
    ...
}

public class Tiger {
    public static final int MAX_COUNT=10;
    public static final int MAX_MASS=2000;
    private static int count=0;
    public Tiger(int mass)
    throws Exception {
        ...
        count++;
    }
    public static int getCount() {
        return count;
    }
}
/*
 * A client would want to know how many Tiger instances are around BEFORE creating (or not) another instance
 * Since count is private and static, it has to be accessed via a method that is a property of the class, not of an instance, i.e. the method is static.
 */

 public class Application {
    public static void main(String[] args)
    throws Exception { // Since the Tiger constructor throws a checked exception, the calling method, main, must either catch it, or throw it
        int m = Tiger.MAX_MASS; // use class name to get MAX_MASS
        Tiger t = new Tiger(m-100);
        // You may use an instance to acess a static field or method, but it is not good practice
        int c = t.getCount(); // using instance to get count
        ...
    }
}
// Always use class name to get at static members of a class, even in situations where you can use an instance, so that your code adheres to the design implication of static
int currCount = Tiger.getCount(); // use class name
if (currCount < Tiger.MAX_COUNT) {
    Tiger t= new Tiger(...);
    ...
} else {
    . . . // do whatever
}