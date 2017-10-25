/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author nileshjayanandana
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    
    @Id 
    @Column(name = "id")
    @SequenceGenerator(name = "seq", sequenceName = "employee_seq")    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> tasks;
    
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        tasks.forEach(task->{task.setEmployee(this);});
        this.tasks = tasks;
    }
    
}
