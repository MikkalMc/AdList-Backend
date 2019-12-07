package me.mikkalmc.ads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.mikkalmc.ads.model.Ad;

public interface AdRepository extends JpaRepository<Ad, Integer> {
    
    List<Ad> findByOwner(String owner);

    List<Ad> findByTitle(String title);
}