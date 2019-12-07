package me.mikkalmc.ads.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.mikkalmc.login.model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    
    public String owner;
    public String title;
    public String description;
    public Integer price;

    protected Ad() {}

    public Ad(String owner, String title, String description, Integer price) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", title='" + title + '\'' +
                ", content='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}