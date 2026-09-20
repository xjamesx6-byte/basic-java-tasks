import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicJavaTask1Test {

    private static final Random RANDOM = new Random();

    @Test
    void testIsEven() {
        start();
        int n = 1 + RANDOM.nextInt(100);
        boolean actual = BasicJavaTasks.isEven(n);
        boolean expected = n % 2 == 0;
        printResult("isEven", actual == expected);
        end();
    }

    @RepeatedTest(20)
    void testCheckAccess() {
        start();
        int age = RANDOM.nextInt(100);
        String actual = BasicJavaTasks.checkAccess(age);
        String expected = age > 18 ? "Allowed" : "Denied";
        printResult("checkAccess", expected.equals(actual));
        end();
    }

    @ParameterizedTest
    @MethodSource("randomScores")
    void testGetGrade(int score) {
        start();
        String actual = BasicJavaTasks.getGrade(score);
        String expected = expectedGrade(score);
        printResult("getGrade", expected.equals(actual));
        end();
    }

    static Stream<Integer> randomScores() {
        return IntStream.range(0, 10).mapToObj(i -> RANDOM.nextInt(101));
    }

    private static String expectedGrade(int score) {
        if (score <= 20) return "E";
        if (score <= 40) return "D";
        if (score <= 60) return "C";
        if (score <= 80) return "B";
        return "A";
    }

    private static void start() {
        System.out.println("========================Test method start");
    }

    private static void end() {
        System.out.println("Test method end");
        System.out.println("========================");
    }

    private static void printResult(String method, boolean passed) {
        System.out.println(method + ": " + (passed ? "TEST PASSED" : "TEST FAILED"));
    }
}
