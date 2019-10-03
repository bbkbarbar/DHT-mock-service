package hello;

public class Greeting {

    private final long id;
    private final String content;
    private final double temp = -12.34d;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Double getTemp(){ return temp; }

}
