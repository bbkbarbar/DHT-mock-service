package hello;

import java.util.Random;

public class DHTData {

    private float tempC = -273.0f;
    private float tempF = 459.3f;
    private float humidity = 0.0f;
    private float heatIndex = -273.0f;

    public DHTData(float tempC, float tempF, float humidity, float heatIndex) {
        this.tempC = tempC;
        this.tempF = tempF;
        this.humidity = humidity;
        this.heatIndex = heatIndex;
    }

    /**
     * Generate DHTData object with random values..
     * @return
     */
    public static DHTData generateRandom(){
        Random rand = new Random();

        float c = ( rand.nextInt(350) / 10.0f );
        float f = (c * (9/5.0f) + 32);
        float h = ( (rand.nextInt(600) + 200) /10.0f );
        float i = (c + ((rand.nextInt(100) - 50) / 100f) );

        return new DHTData(c, f, h, i);
    }

    public float getTempC() {
        return tempC;
    }

    public float getTempF() {
        return tempF;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getHeatIndex() {
        return heatIndex;
    }

    public static String generateJsonString(float c, float f, float h, float i){
        return "{\n\t\"values\":{\n" +
                "\t\t\"tempC\": \"" + c + "\",\n" +
                "\t\t\"tempF\": \"" + Float.toString(f) + "\",\n" +
                "\t\t\"humidity\": \"" + Float.toString(h) + "\",\n" +
                "\t\t\"heatIndex\": \"" + Float.toString(i) + "\"\n"  +
                "\t}\n" +
                "}"
        ;
    }

    public String getJsonString(){
        return generateJsonString(this.getTempC(), this.getTempF(), this.getHumidity(), this.getHeatIndex());
    }
}
