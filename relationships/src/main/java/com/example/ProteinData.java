package com.example;

import javax.persistence.*;

@Entity
public final class ProteinData {
    @Id
    @GeneratedValue(generator = "myForeignGenerator")
    @org.hibernate.annotations.GenericGenerator(
            name = "myForeignGenerator",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name="property", value="user")
    )
    private int id;
    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private ProteinUser user;
    private int total;
    private int goal;

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
