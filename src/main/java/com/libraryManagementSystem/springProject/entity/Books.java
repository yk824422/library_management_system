package com.libraryManagementSystem.springProject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="books")
@NoArgsConstructor
@Data
public class Books {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "title")
    private  String title;

    public Books(int id, String title, String author, int rackId, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rackId = rackId;
        this.isAvailable = isAvailable;
    }

    @Column(name = "author")
    private  String author;

    @Column(name = "rack_id")
    private  Integer rackId;

    @Column(name = "is_available")
    private  Boolean isAvailable;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRackId() {
        return rackId;
    }

    public void setRackId(int rackId) {
        this.rackId = rackId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rackId=" + rackId +
                ", isAvailable=" + isAvailable +
//                ", userDetails=" + userDetails +
                '}';
    }


}
