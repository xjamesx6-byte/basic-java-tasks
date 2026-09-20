import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class AllBasicJavaMethodsTest {

    private static final Random RANDOM = new Random();

    @Test
    void isEvenTest() {
        int n = RANDOM.nextInt(201) - 100;
        check("isEven", BasicJavaTasks.isEven(n), n % 2 == 0);
    }

    @RepeatedTest(3)
    void checkAccessTest() {
        int age = RANDOM.nextInt(100);
        check("checkAccess", BasicJavaTasks.checkAccess(age), age > 18 ? "Allowed" : "Denied");
    }

    @ParameterizedTest
    @MethodSource("gradeScores")
    void getGradeTest(int score) {
        check("getGrade", BasicJavaTasks.getGrade(score), expectedGrade(score));
    }

    @Test
    void isPositiveTest() {
        int n = RANDOM.nextInt(201) - 100;
        check("isPositive", BasicJavaTasks.isPositive(n), n >= 0);
    }

    @Test
    void blastOffTest() {
        int start = 1 + RANDOM.nextInt(10);
        StringBuilder expected = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            expected.append(i);
            if (i > 1) expected.append(" ");
        }
        expected.append(" Поехали!");
        check("blastOff", BasicJavaTasks.blastOff(start), expected.toString());
    }

    @Test
    void sumToNTest() {
        int n = RANDOM.nextInt(20);
        int expected = n * (n + 1) / 2;
        check("sumToN", BasicJavaTasks.sumToN(n), expected);
    }

    @Test
    void hasBugTest() {
        String[] messages = {"OK", "Warning", RANDOM.nextBoolean() ? "Bug" : "Info"};
        boolean expected = Arrays.stream(messages).anyMatch(s -> s.equalsIgnoreCase("Bug"));
        check("hasBug", BasicJavaTasks.hasBug(messages), expected);
    }

    @Test
    void getEvenInRangeTest() {
        int start = RANDOM.nextInt(10);
        int end = start + RANDOM.nextInt(10);
        StringBuilder expected = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                if (expected.length() > 0) expected.append(" ");
                expected.append(i);
            }
        }
        check("getEvenInRange", BasicJavaTasks.getEvenInRange(start, end), expected.toString());
    }

    @Test
    void findMaxTest() {
        int[] arr = RANDOM.ints(5, -100, 101).toArray();
        int expected = Arrays.stream(arr).max().getAsInt();
        check("findMax", BasicJavaTasks.findMax(arr), expected);
    }

    @Test
    void reverseTest() {
        String[] arr = {"One", "Two", "Three", "Four"};
        String[] expected = {"Four", "Three", "Two", "One"};
        check("reverse", Arrays.toString(BasicJavaTasks.reverse(arr)), Arrays.toString(expected));
    }

    @Test
    void calcAverageTest() {
        List<Integer> list = RANDOM.ints(5, 0, 101).boxed().toList();
        double expected = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        check("calcAverage", BasicJavaTasks.calcAverage(list), expected);
    }

    @Test
    void removeSpecificNameTest() {
        List<String> list = new ArrayList<>(List.of("Ivan", "Petr", "Anna", "Ivan"));
        String name = "Ivan";
        List<String> expected = new ArrayList<>(List.of("Petr", "Anna"));
        check("removeSpecificName", BasicJavaTasks.removeSpecificName(list, name), expected);
    }

    static Stream<Integer> gradeScores() {
        return Stream.of(RANDOM.nextInt(101), RANDOM.nextInt(101), RANDOM.nextInt(101),
                RANDOM.nextInt(101), RANDOM.nextInt(101));
    }

    private static String expectedGrade(int score) {
        if (score <= 20) return "E";
        if (score <= 40) return "D";
        if (score <= 60) return "C";
        if (score <= 80) return "B";
        return "A";
    }

    private static void check(String method, Object actual, Object expected) {
        System.out.println("========================Test method start");
        if (expected.equals(actual)) {
            System.out.println(method + ": TEST PASSED");
        } else {
            System.out.println(method + ": TEST FAILED");
        }
        System.out.println("Test method end");
        System.out.println("========================");
    }
}
