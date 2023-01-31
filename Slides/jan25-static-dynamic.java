public class PointApp {
    public static void
    main(String[] args) {
        /* 
         * Every ColoredPoint is a Point (just like every Student is a Person)
         * So any ColoredPoint instance (dynamic type) can be referred to by a Point variable (static type)
         */
        Point p1 = new Point(2,3);
        ColoredPoint p2 = new ColoredPoint(4,5,”blue”);
        Point p3 = new ColoredPoint(2,3,”red”);
    }
}

public class PointApp {
    public static void
    main(String[] args) {
        Point p1 = new Point(2,3);
        ColoredPoint p2 = new ColoredPoint(4, 5,"blue"); 
        // The following code will print out "blue"
        System.out.println(p2.getColor());
        Point p3 = new ColoredPoint(2,3,”red”);
        // The following code will print out "2"
        System.out.println(p3.getX());
        // The following code will print out ""p3 = 2, 3, red"
        System.out.println("p3 = " + p3);
        /*
         * Static type of p3 is Point, but dynamic type (type of instance it points to) is ColoredPoint.
         * So, the p3.toString() static call is bound to the dynamic type, ColoredPoint.
         * This results in the overridding version of toString() being executed.
         */
    }
}

public class PointApp {
    public static void
    main(String[] args) {
        // The following code WILL NOT COMPILE because every point (RHS) is NOT a ColoredPoint (LHS)
        // So a Point instance cannot be referenced by a ColoredPoint variable
        ColoredPoint p4 = new Point(5,6);
    }
}

public class PointApp {
    public static void
    main(String[] args) {
        // The following code WILL NOT COMPILE because the static type of p5 is "Point"
        // ONLY members of "Point" class can be syntactically referenced by p5
        // Since getColor() is not in the "Point" class, and thus the compiler flags error
        Point p5 = new ColoredPoint(1, 2, green);
        System.out.println(p5.getColor()); 
    }
}