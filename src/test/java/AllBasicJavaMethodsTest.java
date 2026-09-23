import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("task2")
public class AllBasicJavaMethodsTest {

    private static final Random RANDOM = new Random();

    @RepeatedTest(10)
    void isEvenTest() {
        int n = RANDOM.nextInt(201) - 100;
        boolean expected = n % 2 == 0;
        boolean actual = BasicJavaTasks.isEven(n);
        assertEquals(expected, actual, "isEven: expected=" + expected + ", actual=" + actual + ", n=" + n);
    }

    @RepeatedTest(10)
    void checkAccessTest() {
        int age = RANDOM.nextInt(100);
        String expected = age > 18 ? "Allowed" : "Denied";
        String actual = BasicJavaTasks.checkAccess(age);
        assertEquals(expected, actual, "checkAccess: expected=" + expected + ", actual=" + actual + ", age=" + age);
    }

    @ParameterizedTest
    @MethodSource("gradeScores")
    void getGradeTest(int score) {
        String expected = expectedGrade(score);
        String actual = BasicJavaTasks.getGrade(score);
        assertEquals(expected, actual, "getGrade: expected=" + expected + ", actual=" + actual + ", score=" + score);
    }

    @RepeatedTest(10)
    void isPositiveTest() {
        int n = RANDOM.nextInt(201) - 100;
        boolean expected = n >= 0;
        boolean actual = BasicJavaTasks.isPositive(n);
        assertEquals(expected, actual, "isPositive: expected=" + expected + ", actual=" + actual + ", n=" + n);
    }

    @RepeatedTest(10)
    void blastOffTest() {
        int start = 1 + RANDOM.nextInt(10);
        StringBuilder expected = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            expected.append(i);
            if (i > 1) expected.append(" ");
        }
        expected.append(" Поехали!");
        String actual = BasicJavaTasks.blastOff(start);
        assertEquals(expected.toString(), actual, "blastOff: expected=" + expected + ", actual=" + actual + ", start=" + start);
    }

    @RepeatedTest(10)
    void sumToNTest() {
        int n = RANDOM.nextInt(20);
        int expected = n * (n + 1) / 2;
        int actual = BasicJavaTasks.sumToN(n);
        assertEquals(expected, actual, "sumToN: expected=" + expected + ", actual=" + actual + ", n=" + n);
    }

    @RepeatedTest(10)
    void hasBugTest() {
        String[] messages = RANDOM.nextBoolean()
                ? new String[]{"OK", "Warning", "Bug"}
                : new String[]{"OK", "Warning", "Info"};
        boolean expected = Arrays.stream(messages).anyMatch(s -> s.equalsIgnoreCase("Bug"));
        boolean actual = BasicJavaTasks.hasBug(messages);
        assertEquals(expected, actual, "hasBug: expected=" + expected + ", actual=" + actual + ", messages=" + Arrays.toString(messages));
    }

    @RepeatedTest(10)
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
        String actual = BasicJavaTasks.getEvenInRange(start, end);
        assertEquals(expected.toString(), actual, "getEvenInRange: expected=" + expected + ", actual=" + actual + ", range=" + start + ".." + end);
    }

    @RepeatedTest(10)
    void findMaxTest() {
        int[] arr = RANDOM.ints(5, -100, 101).toArray();
        int expected = Arrays.stream(arr).max().orElseThrow();
        int actual = BasicJavaTasks.findMax(arr);
        assertEquals(expected, actual, "findMax: expected=" + expected + ", actual=" + actual + ", array=" + Arrays.toString(arr));
    }

    @RepeatedTest(10)
    void reverseTest() {
        String[] arr = {"One", "Two", "Three", "Four"};
        String[] expected = {"Four", "Three", "Two", "One"};
        String[] actual = BasicJavaTasks.reverse(arr);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual), "reverse: expected=" + Arrays.toString(expected) + ", actual=" + Arrays.toString(actual));
    }

    @RepeatedTest(10)
    void calcAverageTest() {
        List<Integer> list = RANDOM.ints(5, 0, 101).boxed().toList();
        double expected = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        double actual = BasicJavaTasks.calcAverage(list);
        assertEquals(expected, actual, 0.000001, "calcAverage: expected=" + expected + ", actual=" + actual + ", list=" + list);
    }

    @RepeatedTest(10)
    void removeSpecificNameTest() {
        List<String> list = new ArrayList<>(List.of("Ivan", "Petr", "Anna", "Ivan"));
        String name = RANDOM.nextBoolean() ? "Ivan" : "Petr";
        List<String> expected = new ArrayList<>();
        for (String item : list) {
            if (!item.equals(name)) expected.add(item);
        }
        List<String> actual = BasicJavaTasks.removeSpecificName(list, name);
        assertEquals(expected, actual, "removeSpecificName: expected=" + expected + ", actual=" + actual + ", nameToRemove=" + name);
    }

    static Stream<Integer> gradeScores() {
        return Stream.generate(() -> RANDOM.nextInt(101)).limit(10);
    }

    private static String expectedGrade(int score) {
        if (score <= 20) return "E";
        if (score <= 40) return "D";
        if (score <= 60) return "C";
        if (score <= 80) return "B";
        return "A";
    }
}
