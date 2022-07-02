package org.aposternak35.app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Modification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column
    private String name;

    @Column
    private String caption;

    @Column
    private int periodBegin;

    @Column
    private int periodEnd;

    private Boolean active;

    @JsonBackReference
    @ManyToOne
    private Model model;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }



    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPeriodBegin() {
        return periodBegin;
    }

    public void setPeriodBegin(int periodBegin) {
        this.periodBegin = periodBegin;
    }

    public int getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(int periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
