package pl.coderslab.springbootproject.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "plans")
public class Plan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Type(type = "numeric_boolean")
    private boolean important;
    @Type(type = "numeric_boolean")
    private boolean urgent;
    @Type(type = "numeric_boolean")
    private boolean done;


    @Transient
    private String timeStartView;
    @Transient
    private String timeStopView;

    @Transient
    private String dateStartView;

    @Transient
    private String dateStopView;


    private Date timeStart;

    private Date timeStop;

    @ManyToOne
    private User user;


    public Plan() {
    }

    public Plan(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Plan setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Plan setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Plan setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isImportant() {
        return important;
    }

    public Plan setImportant(boolean important) {
        this.important = important;
        return this;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public Plan setUrgent(boolean urgent) {
        this.urgent = urgent;
        return this;
    }


    public Plan setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public Plan setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public Date getTimeStop() {
        return timeStop;
    }

    public Plan setTimeStop(Date timeStop) {
        this.timeStop = timeStop;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Plan setUser(User user) {
        this.user = user;
        return this;
    }

    public String getTimeStartView() {
        return timeStartView;
    }

    public Plan setTimeStartView(String timeStartView) {
        this.timeStartView = timeStartView;
        return this;
    }

    public String getTimeStopView() {
        return timeStopView;
    }

    public Plan setTimeStopView(String timeStopView) {
        this.timeStopView = timeStopView;
        return this;
    }

    public String getDateStartView() {
        return dateStartView;
    }

    public Plan setDateStartView(String dateStartView) {
        this.dateStartView = dateStartView;
        return this;
    }

    public String getDateStopView() {
        return dateStopView;
    }

    public Plan setDateStopView(String dateStopView) {
        this.dateStopView = dateStopView;
        return this;
    }

    public boolean isDone() {
        return done;
    }

    public Plan setDone(boolean done) {
        this.done = done;
        return this;
    }
}
