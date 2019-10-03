package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! (%d)";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,
                             @RequestParam(value="val", defaultValue="7") Integer val ){
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, val));
    }

    @RequestMapping("/")
    public String root(@RequestParam(value="name", defaultValue="World") String name,
                             @RequestParam(value="val", defaultValue="7") Integer val ){
        return "<html><body><h1>Hello</h1></body></html>";
    }

    private static String getWebStringFromStr(String i){
        return i.replace("\n", "\r\n");

    }

    @RequestMapping("/pure")
    public String pure(){

        return getWebStringFromStr( DHTData.generateRandom().getJsonString() );
    }

}
