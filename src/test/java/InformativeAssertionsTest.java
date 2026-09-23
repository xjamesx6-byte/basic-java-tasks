import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("task1")
class InformativeAssertionsTest {

    @Test
    void booleanResultTest() {
        int number = 8;
        boolean expected = true;
        boolean actual = BasicJavaTasks.isEven(number);
        assertEquals(expected, actual,
                "isEven: expected=" + expected + ", actual=" + actual + ", input=" + number);
    }

    @Test
    void listResultTest() {
        List<String> input = List.of("Ivan", "Petr", "Anna", "Ivan");
        List<String> expected = List.of("Petr", "Anna");
        List<String> actual = BasicJavaTasks.removeSpecificName(input, "Ivan");
        assertEquals(expected, actual,
                "removeSpecificName: expected=" + expected + ", actual=" + actual);
    }

    @Test
    void stringResultTest() {
        int score = 75;
        String expected = "B";
        String actual = BasicJavaTasks.getGrade(score);
        assertEquals(expected, actual,
                "getGrade: expected=" + expected + ", actual=" + actual + ", score=" + score);
    }

    @Test
    @Tag("negative")
    void intentionallyFailingTest() {
        int score = 90;
        String expected = "B";
        String actual = BasicJavaTasks.getGrade(score);
        assertEquals(expected, actual,
                "Intentional failure: expected=" + expected + ", actual=" + actual + ", score=" + score);
    }
}
