package me.mikkalmc.ads.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.mikkalmc.ads.model.Ad;
import me.mikkalmc.ads.repository.AdRepository;

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
    
    @PostMapping(value="/ad/search/owner", consumes = "application/json", produces = "application/json")
    public List<Ad> findByOwner(@RequestBody Map<String, String> body) {
        String owner = body.get("owner");

        return adRepository.findByOwner(owner);
    }

    @PostMapping(value="/ad/search/title", consumes = "application/json", produces = "application/json")
    public List<Ad> findByTitle(@RequestBody Map<String, String> body) {
        String title = body.get("title");

        return adRepository.findByTitle(title);
    }

    @DeleteMapping(value = "/ad/{id}", consumes = "application/json", produces = "application/json")
    public boolean delete(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        adRepository.deleteById(bookId);
        return true;
    } 
}