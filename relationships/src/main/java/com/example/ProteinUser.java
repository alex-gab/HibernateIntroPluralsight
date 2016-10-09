package com.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public final class ProteinUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int id;
    private String name;
    private int total;
    private int goal;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OrderColumn(name = "pos")
    private List<UserHistory> history = new ArrayList<UserHistory>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public List<UserHistory> getHistory() {
        return history;
    }

    public void setHistory(List<UserHistory> history) {
        this.history = history;
    }

    public void addHistory(UserHistory historyItem) {
        historyItem.setUser(this);
        history.add(historyItem);
    }
}
