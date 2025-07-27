package model;

public class Course {
    private int id;
    public String name;
    private String description;
    private int teacherId;
    private int credits;

    public Course(int id, String name, String description, int teacherId, int credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacherId = teacherId;
        this.credits = credits;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teacherId=" + teacherId +
                ", credits=" + credits +
                '}';
    }
}
