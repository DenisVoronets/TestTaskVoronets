import java.io.IOException;

public class Check {

    private Rectangle rectangle;
    private myPoint myPoint;

    void check() throws IOException {
        rectangle = new Rectangle();
        rectangle.createRectangle();
        myPoint = new myPoint();
        myPoint.createPoint();

        inside();
        outside();
        onTheSideandOnTheTop();


    }

    private void inside() {
        double xMax_Coordinate = rectangle.getMaxXpoint();
        double xMin_Сoordinate = rectangle.getMinXpoint();
        double yMax_Сoordinate = rectangle.getMaxYpoint();
        double yMin_Сoordinate = rectangle.getMinYpoint();

        for (int i = 0; i < myPoint.getXpoints().length; i++) {//перебор массива с Х координатами точки
            double v = myPoint.getXpoints()[i];
            for (int j = 0; j < myPoint.getYpoints().length; j++) {//перебор массива с У координатами точки
                double v1 = myPoint.getYpoints()[j];
                if (i != j) {
                    continue;
                }
                if (xMin_Сoordinate < v && v < xMax_Coordinate && v1 > yMin_Сoordinate && v1 < yMax_Сoordinate) {
                    System.out.println("Точка: " + "(" + v + " ; " + v1 + ")" + "- 2");
                }
            }
        }
    }


    private void outside() {// узнаем положение точки ограничивая оси ХУ по максимальным и минимальным значениям
        // (работает этот метод только ,если две стороны четерехуголника пренадлежат осям)
        //  например для фигуры Ромб метод не работает
        double xMax_Coordinate = rectangle.getMaxXpoint();
        double xMin_Сoordinate = rectangle.getMinXpoint();
        double yMax_Сoordinate = rectangle.getMaxYpoint();
        double yMin_Сoordinate = rectangle.getMinYpoint();

        for (int i = 0; i < myPoint.getXpoints().length; i++) {//перебор массива с Х координатами точки
            double v = myPoint.getXpoints()[i];
            for (int j = 0; j < myPoint.getYpoints().length; j++) {//перебор массива с У координатами точки
                double v1 = myPoint.getYpoints()[j];
                if (i != j) {
                    continue;
                }
                if (xMin_Сoordinate >= v | v >= xMax_Coordinate && yMin_Сoordinate >= v1 | v1 >= yMax_Сoordinate && v != v1) {
                    System.out.println("Точка: " + "(" + v + " ; " + v1 + ")" + "- 3");
                }
            }
        }
    }


    private void onTheSideandOnTheTop() {
        int z = 0;
        double rectangleXcoordinate;
        double rectangleYcoordinate;
        double pointXcoordinate;
        double pointYcoordinate;

        for (int i = 0; i < rectangle.getXpoints().length; i++) {//перебор массива с Х координатами четерехугольника
            rectangleXcoordinate = rectangle.getXpoints()[i];
            for (int j = 0; j < rectangle.getYpoints().length; j++) {//перебор массива с У координатами четерехугольника
                rectangleYcoordinate = rectangle.getYpoints()[j];
                if (i != j) {
                    continue;
                }
                double x0 = rectangleXcoordinate;//записуем координаты для подстановки в сравнение х0,х,х1, у0,у,у1
                double y0 = rectangleYcoordinate;
                double x1 = rectangle.getXpoints()[++i];
                double y1 = rectangle.getYpoints()[++j];
                z++;
                if (z <= 4) {
                    for (int k = 0; k < myPoint.getXpoints().length; k++) {//перебор массива с Х координатами точки
                        pointXcoordinate = myPoint.getXpoints()[k];
                        for (int l = 0; l < myPoint.getYpoints().length; l++) {//перебор массива с У координатами точки
                            pointYcoordinate = myPoint.getYpoints()[l];
                            if (k != l) {
                                continue;
                            }

                            double x = pointXcoordinate;//записываем координаты ХУ нашей точки для подстановки в сравнение
                            double y = pointYcoordinate;
                            if (x0 <= x && x <= x1 && y < y1 && y0 <= y) {
                                System.out.println("Точка: " + "(" + x + " ; " + y + ")- 1");
                            }
                            //метод находит точку на вершине onTheTop
                            if (x0 == x && y0 == y) { //четные номер массива с координатами ХУ
                                System.out.println("Точка: " + "(" + x + " ; " + y + ")- 0");
                            }
                            if (x == x1 && y == y1) { //не четный номер массива с координатами ХУ
                                System.out.println("Точка: " + "(" + x + " ; " + y + ")- 0");
                            }
                        }
                    }
                }
            }
        }
    }





}
