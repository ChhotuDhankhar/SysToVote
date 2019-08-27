package ca.systovote.controllers;

import ca.systovote.model.Sys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SysController {
    private List<Sys> sysList = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();

    @GetMapping("/hello")
    public String getHelloMessage()
    {
        return "Hello World!";
    }

    @PostMapping("/sys")
    public Sys createNewSys(@RequestBody Sys sys)
    {
        //set sys to have next ID
        sys.setId(nextId.incrementAndGet());
        sysList.add(sys);
        return sys;
    }


}
