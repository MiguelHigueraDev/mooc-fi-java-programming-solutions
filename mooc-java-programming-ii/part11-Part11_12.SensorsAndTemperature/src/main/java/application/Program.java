package application;

public class Program {

    public static void main(String[] args) {
        Sensor kumpula = new TemperatureSensor();
        kumpula.setOn();
        System.out.println("temperature in Kumpula " + kumpula.read() + " degrees Celsius");

        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiVantaaAirport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();
        helsinkiRegion.addSensor(kumpula);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiVantaaAirport);

        helsinkiRegion.setOn();
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");

        AverageSensor ka = new AverageSensor();
        ka.addSensor(new StandardSensor(3));
        ka.addSensor(new StandardSensor(7));
        System.out.println(ka.readings());
        ka.readings();
    }

}
