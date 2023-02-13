// "Point" class definition
package geometry;
public class Point {
    int x,y;
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String toString() {
        return x + "," + y;
    }
}

// "ColoredPoint" definition
package geometry;
public class ColoredPoint
extends Point {
    //int x,y;
    String color;
    //The constructor is not inherited from the superclass
    public ColoredPoint(int x, int y, String color) {
        super(x,y);
        this.color = color;
    }
    //The code below should not be used as is, the variable color should be included
    /*
    public int getX() { return x; }
    public int getY() { return y; }
    public String toString() {
        return x + “,” + y;
    }
    */
}

package geometry;
public class ColoredPoint
extends Point {
    int x,y;
    String color;
    public ColoredPoint(int x, int y, String color) {
        super(x,y);
        this.color = color;
    }
    /*
     * public int getX() { return x; }
     * public int getY() { return y; }
     * public String toString() {
     *     return x + “,” + y;
     * }
     */
    //The following code will override the inherited toString() method from the Point class
    public String toString() {
        return x + "," y + "," + color;
    }
    //As shown below, reusing inherited method code in overriding method is good programming practice
    public String toString() {
        return super.toString() + "," + color;
    }
}