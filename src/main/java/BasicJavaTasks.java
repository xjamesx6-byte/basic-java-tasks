import java.util.ArrayList;
import java.util.List;

public class BasicJavaTasks {

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static String checkAccess(int age) {
        return age > 18 ? "Allowed" : "Denied";
    }

    public static boolean isPositive(int n) {
        return n >= 0 ? true : false;
    }

    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) return "E";
        if (score <= 40) return "D";
        if (score <= 60) return "C";
        if (score <= 80) return "B";
        if (score <= 100) return "A";
        return "Error";
    }

    public static String blastOff(int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            result.append(i);
            if (i > 1) result.append(" ");
        }
        result.append(" Поехали!");
        return result.toString();
    }

    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static boolean hasBug(String[] messages) {
        for (String message : messages) {
            if (message.equalsIgnoreCase("Bug")) return true;
        }
        return false;
    }

    public static String getEvenInRange(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                if (result.length() > 0) result.append(" ");
                result.append(i);
            }
        }
        return result.toString();
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int number : arr) {
            if (number > max) max = number;
        }
        return max;
    }

    public static String[] reverse(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public static double calcAverage(List<Integer> list) {
        if (list.isEmpty()) return 0;
        int sum = 0;
        for (int number : list) sum += number;
        return (double) sum / list.size();
    }

    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();
        for (String name : list) {
            if (!name.equals(nameToRemove)) result.add(name);
        }
        return result;
    }
}
