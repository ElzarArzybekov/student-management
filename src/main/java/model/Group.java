package model;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public class Group {
    private int id;
    private String name;
    private int curatorId;
    private LocalDate startYear;

    public Group(int id, String name, int curatorId, LocalDate startYear) {
        this.id = id;
        this.name = name;
        this.curatorId = curatorId;
        this.startYear = startYear;
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

    public int getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(int curatorId) {
        this.curatorId = curatorId;
    }

    public LocalDate getStartYear() {
        return startYear;
    }

    public void setStartYear(LocalDate startYear) {
        this.startYear = startYear;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", curatorId=" + curatorId +
                ", startYear=" + startYear +
                '}';
    }
}
