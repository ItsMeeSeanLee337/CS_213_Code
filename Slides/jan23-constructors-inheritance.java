// Given this definition of a point class:
public class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// The statement below will not compile because there isn't a matching no-argument constructor in "Point"
Point p = new Point();
// The default constructor is only written in by the compiler ONLY when there is no programmer defined constructor

public class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // The bottom two statements call another matching (in argument sequences/ types) constructor in the class
    // In this case the first constructor
    public Point (int x) {
        this(x, 0);
    }
    public Point () {
        this(0, 0);
    }
}

public class Point {
    public static final int X_MAX=800, Y_MAX=800;
    int x, y;
    // Most general constructor with params for all fields (x and y)
    public Point(int x, int y) {
        if (0 || x > X_MAX || y < 0 || y > Y_MAX) {
            throw new IllegalArgumentException(“invalid x or y”);
        }
        this.x = x;
        this.y = y;
    }
    // This code Will NOT COMPILE because there is a duplicate constructor: Point(int)
    public Point (int x) {
        this(x, 0);
    }
    public Point (int y) {
        this(0, y);
    }
    // We can either allow default for x or default for y, but not both
    public Point () {
        this(0, 0);
    }
}

public class Point {
    int x, y;
}

public class ColoredPoint
extends Point {
    //int x, y;
    // Subclass ColoredPoint inherits x and y from superclass Point
    // What this means is x and y are fields in ColoredPoint, without the programmer having to write them in (CODE REUSE)
}

Point p = new Point(); // OK, x and y in instance p are zero

ColoredPoint cp = new ColoredPoint(); // OK, x and y in instance cp are zero

public class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
}

Point p = new Point(3,4); // OK, p is (3,4)

// The following class will not compile because the default constructor of "Colored Point" invokes the superclass constructor
public class ColoredPoint
extends Point {
    /*
     * int x,y;
     * public ColoredPoint() {
     *     super();
     * }
     */
}
// Because the superclass Point does not have a no-arg constructor, the subclass ColoredPoint will not compile

public class ColoredPoint
extends Point {
    //int x,y; 
    String color;
    public ColoredPoint(int x, int y, String color) {
        super(x,y); // We will need to write a constructor that calls superclass’s constructor with arguments
        this.color = color;
    }
    // The following alternative will not compile becausse the ompiler will write in super() as the FIRST statement, but "Point" does not have a no-arg constructor
    public ColoredPoint(int x, int y, String color) {
        //super();
        this.x = x; this.y = y;
        this.color = color;
    }
    // There is nothing wrong with this but design-wise it's not a good approach
    public ColoredPoint(int x, int y, String color) {
        this.x = x; this.y = y;
        this.color = color;
    }
}