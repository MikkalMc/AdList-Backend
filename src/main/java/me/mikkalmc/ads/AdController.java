package me.mikkalmc.ads;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdController {
    @Autowired
    AdRepository adRepository;

    @GetMapping("/ad")
    public List<Ad> index() {
        return adRepository.findAll();
    }

    @PostMapping(path = "/ad", consumes = "application/json", produces = "application/json")
    public Ad create(@RequestBody Map<String, String> body){
        System.out.println(body);
        String owner = body.get("owner");
        String title = body.get("title");
        String description = body.get("description");
        Integer price =  Integer.parseInt(body.get("price"));
        return adRepository.save(new Ad(owner, title, description, price));
    }
}