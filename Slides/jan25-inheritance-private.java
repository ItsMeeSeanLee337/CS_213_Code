// "Point" class definition
public class Point {
    private int x,y;
    ...
}

// "ColoredPoint" class definition
public class ColoredPoint extends Point {
    // x and y inherited but HIDDEN
    ...
    // The following method Will NOT COMPILE because "x" is hidden even though it is inherited
    public int getX() { // override inherited getX()
        return x;
    }
}

public class Point {
    private int x,y;
    ...
}

public class ColoredPoint extends Point {
    // x and y inherited but HIDDEN
    ...
    // getX() is NOT overridden
}

public class PointApp {
    public static void
    main(String[] args) {
        ColoredPoint cp = new ColoredPoint(4,5,”blue”);
        // The follwing line Will NOT COMPILE because "x" is private
        System.out.println(cp.x);
        // The following line will compile and prints "4" because the inherited getX() method is able to access the "x" field
        System.out.println(cp.getX());  
    }
}
