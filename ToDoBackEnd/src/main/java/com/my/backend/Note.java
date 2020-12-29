package com.my.backend;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long noteId;

    private String note;

    @ManyToOne
    @JoinColumn(name="id")
    private User user;

    private boolean done;

    public Note(String note, User user) {
        this.note = note;
        this.user = user;
        this.done = false;
    }

    public Note(){}

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getUserName() {return user.getName();}

    public void setUserId(long id){
        this.user.setId(id);
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }
}


