public class Supercl {
    static int x=2;
    public static void m() {
        System.out.println("in class Supercl");
    }
}

public class Subcl
extends Supercl {
    int x=3; // Instance field with same name as inherited static field x
}

public class StaticTest {
    public static void main(String[] args) {
        System.out.println(Subcl.x); // This line will not compile because we "cannot make static reference to non-static field x"
        // The instance field of the same name will HIDE inherited static field
    }
}

public class Supercl {
    static int x=2;
    public static void m() {
        System.out.println("in class Supercl");
    }
}

// In the following code we will try to make a static method in "Subcl" to get the inherited static "x"
public class Subcl
extends Supercl {
    int x=3;
    public static int getX() {
        return x;
    }
}
// Similar to before this will not compile because we "cannot make static reference to non-static field x"

public class Supercl {
    static int x=2;
    public static void m() {
        System.out.println("in class Supercl");
    }
}

public class Subcl
extends Supercl {
    int x=3;
}

public class StaticTest {
    public static void main(String[] args) {
        Subcl subcl = new Subcl();
        System.out.println(subcl.x); // This will print out "3", the instance field
        Supercl supercl = new Subcl();
        // "Supercl" is the static type while "Subcl" is the dynamic type
        System.out.println(supercl.x); // This will print out "2", the inherited static field
        // Inherited static fields are statically bount to reference type, not dynamically bound to instance type
    }
}

public class Sorter {
    public static void sort(String[] names) {
        System.out.println("simple sort");
    }
}

public class IllustratedSorter
extends Sorter {
    // Overrides the sort method from the parent class "Sorter"
    public static void sort(String[] names) {
        System.out.println("illustrated sort");
    }
}

Sorter p = new IllustratedSorter();
// "Sorter" is the static type while "IllustratedSorter" is the dynamic type

p.sort(); // This line will print out "simple sort"
// sort() is statically bound to "p", meaning since "Sorter" is the static type of "p", the sort() method in "Sorter" is called

public class Sorter {
    public static void sort(String[] names) {
        System.out.println("simple sort");
    }
}

// This class will not compile because "“Instance method cannot override static method sort from Sorter"
public class IllustratedSorter
extends Sorter {
    // Overrides the sort method from the parent class "Sorter"
    public void sort(String[] names) {
        System.out.println("illustrated sort");
    }
}
