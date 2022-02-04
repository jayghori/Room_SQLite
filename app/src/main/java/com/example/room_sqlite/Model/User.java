package com.example.room_sqlite.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "userD")
public class  User {

    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String salary;
    String company;

    public User(int id, String name, String salary, String company) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.company = company;
    }

    @Ignore
    public User( String name, String salary, String company) {
        this.name = name;
        this.salary = salary;
        this.company = company;
    }

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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
