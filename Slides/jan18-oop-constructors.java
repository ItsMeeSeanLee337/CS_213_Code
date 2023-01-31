// This class definition will compile
public class Point {} 

// To create a new instance of the point class, we use the "new" keyword
new Point(); 

// Even though we have not defined a constructor in the class "point", the compiler throws a default constuctor that looks like this:
public class Point {
    public Point() { } // For this default constructor there are no arguments and nothing in the body
}