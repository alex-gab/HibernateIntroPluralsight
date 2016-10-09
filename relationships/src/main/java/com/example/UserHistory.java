package com.example;

import javax.persistence.*;
import java.util.Date;

@Entity
public final class UserHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int id;
    @ManyToOne(optional = false)
    private ProteinUser user;
    private Date entryTime;
    private String entry;

    public UserHistory() {
    }

    public UserHistory(Date entryTime, String entry) {
        super();
        this.entryTime = entryTime;
        this.entry = entry;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProteinUser getUser() {
        return user;
    }

    public void setUser(ProteinUser user) {
        this.user = user;
    }
}
