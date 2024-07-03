package com.applicacion_hibernate.entidades.blog;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "post_details")
public class PostDetails {

    @Id
    private int id;

    @Column (name = "topic")
    private String topic;

    @Column(name= "datePosted")
    private Date datePosted;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name="post_id")
    private Post post;

    public PostDetails(String topic, Date datePosted) {
        this.topic = topic;
        this.datePosted = datePosted;
    }

    public PostDetails(){}

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostDetails{" +
                "topic='" + topic + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }
}
