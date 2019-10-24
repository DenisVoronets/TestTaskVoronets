import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Stream;

class myPoint {

    private String fileNamePoint = "C:\\Users\\Admin\\Desktop\\task2point.txt";//Ваш путь к файлу

    private double[] array;
    private double[] xpoints;
    private double[] ypoints;

    void createPoint() throws IOException {
        getArrayFromFile();
        getXpointFromFile();
        getYpointsFromFile();
    }

    private void getArrayFromFile() throws IOException {//достаем из файла все координаты и записываем в общий массив
        Path path = Paths.get(fileNamePoint);
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

    double[] getXpoints() {
        return xpoints;
    }//геттеры для Х координат
    double[] getYpoints() {
        return ypoints;
    }//геттеры для У координат
}

