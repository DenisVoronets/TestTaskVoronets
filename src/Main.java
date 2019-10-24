import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
public class Main {

    private static  String fileName = "C:\\Users\\Admin\\Desktop\\task1.txt";//Ваш путь к файлу
    private static BufferedReader reader;
    private static int[] array;

    public static void main(String[] args) throws FileNotFoundException {
        myPercentile();
        median();
        maxValue();
        minValue();
        averageValue();
    }

    private static void median() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        array = reader.lines().mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        double median;
        if (array.length % 2 == 0)
            median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else
            median = (array[array.length / 2]);
        System.out.println(median);
    }

    private static void maxValue() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        OptionalInt optionalMax = reader.lines().mapToInt(Integer::parseInt).max();
        if (optionalMax.isPresent()) {
            System.out.println(optionalMax.getAsInt());
        }
    }

    private static void minValue() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        OptionalInt optionalMin = reader.lines().mapToInt(Integer::parseInt).min();
        if (optionalMin.isPresent()) {
            System.out.println(optionalMin.getAsInt());
        }
    }

    private static void averageValue() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
        array = reader.lines().mapToInt(Integer::parseInt).toArray();
        if (array != null) {
            double average = IntStream.of(array).average().getAsDouble();
            System.out.println(average);
        }
    }

    private static void myPercentile() throws FileNotFoundException {
        double percentile = 90;
        reader = new BufferedReader(new FileReader(fileName));
        array = reader.lines().mapToInt(Integer::parseInt).toArray();
        int index = (int) ((percentile / 100) * array.length);
        System.out.println(array[index - 1]);
    }
}





