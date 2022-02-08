package FOO;

/*
 * Name: Jerome Sparnaay
 * Date: February 4th, 2022
 * Description: Object and class lab creating a 2d point object and creating methods
 */

public class Main {

/**
 *  2d point class and some appropriate methods
 * @author jerome Sparnaay
 * */
    public static class MyPoint {

        /** x coordinate of point*/
        private double xCoor;

        /** Y coordinate of point*/
        private double yCoor;

        /** creates a point with 0, 0 coordinates*/
        public MyPoint(){
        }

        /** creates point with x and y coordinates passed
         * @param x coordinate value to set the x coordinate of the point
         * @param y coordinate value to set the y coordinate of the point
         * */
        public MyPoint(double x, double y){
            this.xCoor = x;
            this.yCoor = y;
        }

        /** getter of private variable xCoor*/
        public double getxCoor() {
            return xCoor;
        }

        /** getter of private variable yCoor*/
        public double getyCoor() {
            return yCoor;
        }

        /** Setter for private variable xCoor*/
        public void setxCoor(int xCoor) {
            this.xCoor = xCoor;
        }

        /** Setter for private variable yCoor*/
        public void setyCoor(int yCoor) {
            this.yCoor = yCoor;
        }

        /**
         * Measures distance from first point to point passed by reference
         * @param otherPoint point to be measured against to find the distance
         * @return distance from object MyPoint to other point
         * */
        public double toString(MyPoint otherPoint){
            double distance;

            double deltaXPow2 = Math.pow((this.xCoor - otherPoint.xCoor), 2);
            double deltaYPow2 = Math.pow((this.yCoor - otherPoint.yCoor),2);

            distance = Math.sqrt(deltaXPow2 + deltaYPow2);
            return distance;
        }

        /**
         * verifies if one point is equal to another passed one
         * @param otherPoint point to be compared to for equal
         * @return boolean value of the equalness of both xCoor and yCoor variable
         * */
        public boolean equal(MyPoint otherPoint){

            if (this.xCoor != otherPoint.xCoor)
                return false;
            return this.yCoor == otherPoint.yCoor;
        }

        /** method to check if a given array contains a point
         * @param points array of points
         * @param p point to be checked if array contains it
         * @return boolean value of the response of if the array points contains p
         * */
        public static boolean contains(MyPoint[] points, MyPoint p){

            for (MyPoint point : points) {
                if (point.equal(p))
                    return true;
            }
                return false;
        }

        /**
         * verifies if an array of points forms a horizontal
         * @param points array of point to be skimmed through
         * @return boolean of if all points share a common y-axis
         * */
        public static boolean horizontal(MyPoint[] points){

            double firstPointY = points[0].yCoor;

            for (MyPoint point : points){
                if (point.yCoor != firstPointY)
                    return false;
            }
            return true;
        }
    }
    /**
     * test program to test class MyPoint
     * @param args command line arguments
     * */
    public static void main(String[] args) {

        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(2.0, 4.0);
        MyPoint p3 = new MyPoint();

        MyPoint[] points = new MyPoint[2];
        points[0] = new MyPoint(0,0);
        points[1] = new MyPoint(2.0, 4.0);

                                            //expected result:
        System.out.println(p2.getyCoor());  //4
        System.out.println(p1.getxCoor());  //0
        p1.setxCoor(4);
        System.out.println(p1.getxCoor());  //4

        System.out.println(p1.toString(p2));//4.472 = sqrt((4-2)^2+(0-4)^2)

        System.out.println(MyPoint.horizontal(points)); //false
        points[0].setyCoor(4);
        System.out.println(MyPoint.horizontal(points)); //true

        System.out.println(MyPoint.contains(points, p3)); // false
        points[0].setyCoor(0);
        System.out.println(MyPoint.contains(points, p3)); //true

    }
}
