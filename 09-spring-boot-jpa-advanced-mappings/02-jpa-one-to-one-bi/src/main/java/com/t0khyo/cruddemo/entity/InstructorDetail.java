package com.t0khyo.cruddemo.entity;

import jakarta.persistence.*;

/**
 * ToDo:
 * 1.annotate the class as an entity and map to db table
 * 2.define the fields
 * 3.annotate the fields with db column name
 * 4. crate constructors
 * 5.generate getters/setters methods
 * 6.generate toString() method
 */
@Entity
@Table(schema = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    // constructors
    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    // getters/setters methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" + "id=" + id + ", youtubeChannel='" + youtubeChannel + '\'' + ", hobby='" + hobby + '\'' + '}';
    }
}
