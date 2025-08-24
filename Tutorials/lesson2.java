public class lesson2 {
    public static void main(String[] args) {
        // Variables & Data Types in Java

        // Primitive Data Types : int, float, double, char, boolean
        byte b = 1; // 1 byte = 8 bits, Range: -128 to 127(-2^7 to 2^7-1)
        short s = 2; // 2 bytes = 16 bits, Range: -32,768 to 32,767(-2^15 to 2^15-1)
        int i = 3; // 4 bytes = 32 bits, Range: -2,147,483,648 to 2,147,483,647(-2^31 to 2^31-1)
        long l = 4; // 8 bytes = 64 bits, Range: -9,223,372,036,854,775,808 to
                    // 9,223,372,036,854,775,807(-2^63 to 2^63-1)
        float f = 5.0f; // 4 bytes = 32 bits, Range: 1.4E-45 to 3.4028235E38 (-3.4^38*10 to 3.4^38*10-1)
        double d = 6.0d; // 8 bytes = 64 bits, Range: 4.9E-324 to 1.7976931348623157E308 (-1.7^308*10 to
                         // 1.7^308*10-1)
        char c = '7'; // 2 bytes = 16 bits, Range: 0 to 65,535
        boolean bl = true;// 1 byte = 8 bits, Range: true or false

        System.out.printf("Byte: %d\nShort: %d\nInt: %d\nLong: %d\nFloat: %f\nDouble: %f\nChar: %c\nBoolean: %b\n", b,
                s, i, l, f, d, c, bl);

        System.out.println("\n--- Type Casting ---");

        // TypeCasting in Java

        int x = 10;
        double y = x; // Implicit Type Casting

        System.out.printf("Int: %d\nDouble: %f\n", x, y);

        double z = 20.5;
        int w = (int) z; // Explicit Type Casting

        System.out.printf("Double: %f\nInt: %d\n", z, w);

        // Final Keyword in Java (constants)

        final double pi = 3.14;

        System.out.println("Pi: " + pi);

    }
}
