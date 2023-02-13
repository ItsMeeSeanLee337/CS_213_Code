int i = "123".parseAsInteger(); // Bad design: An instance method should be applicable to All instances. But not all strings are parsable as integers

// String static method: parseAsInteger
int i = String.parseAsInteger("123"); 

// Integer static method: parseInt
int i = Integer.parseInt("123"); 
/* Integer.parseInt is better: Think of converting strings to doubles, floats also
 * having all these types of conversions in String would require String to know about
 * formats of other types, which is NOT its business.
 * Best to localize custom functionality in the corresponding target (converted type) classes.
 */

// ”Global” variables that need to be shared by multiple classes/objects can be housed as static fields in a class:
public class Storage {
    static int x;
    static float y;
    static String color="blue";
    static float y;
    ...
}