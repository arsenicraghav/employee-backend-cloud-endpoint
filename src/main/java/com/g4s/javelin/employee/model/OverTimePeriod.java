package com.g4s.javelin.employee.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by sromares on 3/16/16.
 */
@Entity
public class OverTimePeriod {

    @Id
    private String id;
    private String type;

    public OverTimePeriod() {
    }

    public OverTimePeriod(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
