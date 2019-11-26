package me.mikkalmc.ads;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Integer> {
    
    List<Ad> findByOwner(String owner);

    List<Ad> findByTitle(String title);
}