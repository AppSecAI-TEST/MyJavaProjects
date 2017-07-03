package hello;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @CrossOrigin
    @RequestMapping("/getAllProfiles")
    public String getAllProfiles() {
        String jsonData = "[{\"firstname\":\"ajitesh\",\"lastname\":\"kumar\",\"address\":\"211/20-B,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-888-6666\"},{\"firstname\":\"nidhi\",\"lastname\":\"rai\",\"address\":\"201,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-876-5432\"}]";
        return jsonData;
    }

    @CrossOrigin
    @RequestMapping("/reportToMixpanel")
    public String reportMixpanel() throws IOException {
        MixpanelAPIDemo obj = new MixpanelAPIDemo();
        obj.reportToMixpanel();
        String jsonData = "[{\"status\": \"we tried our best\"}]";
        //"we tried our best" is a bad data, not json compatible
        return jsonData;
    }
}