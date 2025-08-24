public class lesson3 {

    public static void main(String[] args) {

        // String & StringBuilder in Java

        // String in Java
        System.out.println("=== Strings in Java ===");

        // String Declaration
        String name = "John"; // String literal
        // Literals are immutable(cannot be changed after creation)
        String name2 = new String("John"); // String object (Constructor)

        System.out.println("String literal: " + name);
        System.out.println("String object constructor: " + name2);

        //String Immutablity 
        name = name + " Doe"; // Creates new String object
        System.out.println("String literal after concatenation: " + name);
       
        // Use full String methods
        System.out.println("String literal length: " + name.length()); //Returns the length of the string
        System.out.println("Uppercase: " + name.toUpperCase()); //Returns the string in uppercase
        System.out.println("Lowercase: " + name.toLowerCase()); //Returns the string in lowercase
        System.out.println("Character at index 2: " + name.charAt(2)); //Returns the character at the specified index
        System.out.println("Index of character 'o': " + name.indexOf('o')); //Returns the index of the first occurrence of the specified character
        System.out.println("Substring from index 2 to 5: " + name.substring(2, 6)); //Returns a substring of the string from the specified start index to the specified end index
        System.out.println("Replace 'John' with 'Jane': " + name.replace("John", "Jane")); //Replaces all occurrences of a substring with another substring
        System.out.println("Contains 'Doe': " + name.contains("Doe")); //Returns true if the string contains the specified substring
        System.out.println("whitespace trimmed: " + name.trim()); //Returns a copy of the string with leading and trailing whitespace removed
        System.out.println("Equals 'John Doe': " + name.equals("John Doe")); //Returns true if the string is equal to the specified string
        System.out.println("Starts with 'John': " + name.startsWith("John")); //Returns true if the string starts with the specified prefix
        System.out.println("Ends with 'Doe': " + name.endsWith("Doe")); //Returns true if the string ends with the specified suffix
        System.out.println("Contains 'Doe' ignoring case: " + name.equalsIgnoreCase("John Doe")); //Returns true if the string contains the specified substring ignoring case

        // StringBuilder in Java
        System.out.println("\n=== StringBuilder in Java ===");

        // What are StringBuilders in Java?
        // StringBuilders are mutable, they can be changed after creation
        StringBuilder sb = new StringBuilder("Hello"); // StringBuilder object
        System.out.println("StringBuilder object: " + sb);

        // Use full StringBuilder methods
        sb.append(" World"); // Appends the specified string to the end of this StringBuilder object
        System.out.println("StringBuilder object after appending: " + sb);

        sb.insert(3, "Java"); // Inserts the specified string at the specified index in this StringBuilder object
        System.out.println("StringBuilder object after inserting: " + sb);

        sb.replace(3, 6, "Python"); // Replaces a substring of this StringBuilder object with the specified string
        System.out.println("StringBuilder object after replacing: " + sb);

        sb.delete(5,9); // Deletes the characters in the specified range from this StringBuilder object
        System.out.println("StringBuilder object after deleting: " + sb);

        // Convert StringBuilder to String
        

        String newString = sb.toString(); // Converts this StringBuilder object to a String object
        System.out.println("StringBuilder object converted to String: " + newString);

        // Reading args from command line

        System.out.println("\n=== Reading args from command line ===");

        for (String arg : args) {
            System.out.println("Argument: " + arg);
        }

    }

}
