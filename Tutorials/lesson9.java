public class lesson9 {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
        myCar.stop();
        myCar.fuelType();

        System.out.println("--------------------");

        Tesla myTesla = new Tesla();
        myTesla.start();
        myTesla.stop();
        myTesla.fuelType();
        myTesla.charge();

    }
}
