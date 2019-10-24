import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Rectangle {

    private String fileNameRectangle = "C:\\Users\\Admin\\Desktop\\task2rectangle.txt";//Ваш путь к файлу

    private double[] array;
    private double[] xpoints;
    private double[] ypoints;

    void createRectangle() throws IOException {
        getArrayFromFile();
        getXpointFromFile();
        getYpointsFromFile();
    }

    private void getArrayFromFile() throws IOException {//достаем из файла все координаты и записываем в общий массив
        Path path = Paths.get(fileNameRectangle);
        array = Files.lines(path)
                .flatMap(e -> Stream.of(e.split(" ")))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }




    private void getXpointFromFile() {//делим общий массив на х координаты
        xpoints = new double[4];
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {
                continue;
            }
            int k = i / 2;
            xpoints[k] = array[i];
        }

    }

    private void getYpointsFromFile() {//делим общий массив на у координаты
        ypoints = new double[4];
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                continue;
            }
            int k = i / 2;
            ypoints[k] = array[i];
        }
    }
    double getMaxXpoint(){// получаем максимальное значение х координат
        double max = xpoints[0];
        for (double xpoint : xpoints) {
            if (xpoint > max)
                max = xpoint;
        }
        return max;
    }
    double getMinXpoint(){// получаем минимальное значение х координат
        double min = xpoints[0];
        for (double xpoint : xpoints) {
            if (xpoint < min)
                min = xpoint;
        }
        return min;
    }
    double getMaxYpoint(){// получаем максимальное значение у координат
        double max = ypoints[0];
        for (double ypoint : ypoints) {
            if (ypoint > max)
                max = ypoint;
        }
        return max;
    }
    double getMinYpoint(){ //получаем минимальное значение у координат
        double min = ypoints[0];
        for (double ypoint : ypoints) {
            if (ypoint < min)
                min = ypoint;
        }
        return min;
    }
    double[] getYpoints() {
        return ypoints;
    }//геттеры для Х координат
    double[] getXpoints() {
        return xpoints;
    }//геттеры для У координат



}
