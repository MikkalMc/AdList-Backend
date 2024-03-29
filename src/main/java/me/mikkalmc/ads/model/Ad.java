package me.mikkalmc.ads.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    
    public Integer userID;
    public String owner;
    public String title;
    public String description;
    public Integer price;

    protected Ad() {}

    public Ad(String owner, String title, String description, Integer price, Integer userID) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.price = price;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", title='" + title + '\'' +
                ", content='" + description + '\'' +
                ", price='" + price + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}