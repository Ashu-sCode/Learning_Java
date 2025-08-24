interface Vehicle {

    void start();

    void stop();

   void fuelType();

}

interface Electric {
    void charge();
}

class Car implements Vehicle{

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    @Override
    public void fuelType() {
        System.out.println("Car uses petrol.");
    }
}

class Tesla implements Vehicle, Electric{

    @Override
    public void start() {
        System.out.println("Tesla started.");
    }

    @Override
    public void stop() {
        System.out.println("Tesla stopped.");
    }

    @Override
    public void fuelType() {
        System.out.println("Tesla uses electricity.");
    }

    @Override
    public void charge() {
        System.out.println("Tesla is charging.");
    }

}