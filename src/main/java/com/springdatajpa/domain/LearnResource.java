package com.springdatajpa.domain;/**
 * Created by Administrator on 2017/8/2.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author xuzhiyong
 * @createDate 2017-08-02-14:48
 */
@Entity
@Table(name = "learn_resource")
public class LearnResource implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String title;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
