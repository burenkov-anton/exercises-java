import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

class Test {

    public static void main(String[] args) {
        String expected = "420262531";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        App.main(null);

        String actual = out.toString();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.print(actual);

        if (!expected.equals(actual)) {
            throw new AssertionError("\"" + expected + "\" does not equal to \"" + actual + "\"");
        }

    }

}
