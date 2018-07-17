public class MyFactoryMethod {

  private static Logistics road = new RoadLogistics();
  private static Logistics sea = new SeaLogistics();

  public static void main(String[] args) {
    road.deliver();
    sea.deliver();
  }
}

interface Transport {

  void deliver();
}

class Truck implements Transport {

  @Override
  public void deliver() {
    System.out.println("Deliver by road");
  }
}

class Ship implements Transport {

  @Override
  public void deliver() {
    System.out.println("Deliver by sea");
  }
}

abstract class Logistics {

  void deliver() {
    Transport t = getTransport();
    t.deliver();
  }

  //The factory method
  abstract Transport getTransport();
}

class RoadLogistics extends Logistics {

  @Override
  Transport getTransport() {
    return new Truck();
  }
}

class SeaLogistics extends Logistics {

  @Override
  Transport getTransport() {
    return new Ship();
  }
}



