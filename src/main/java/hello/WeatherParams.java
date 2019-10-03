package hello;

public class WeatherParams {

    private final double temp;
    private final double humidity;

    public WeatherParams(double temp, double humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }
}
