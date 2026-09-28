public class Student {
    private String id;
    private String name;
    private String programme;
    private double marks;

    public Student(String id, String name, String programme, double marks) {
        this.id = id;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getProgramme() { return programme; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setProgramme(String programme) { this.programme = programme; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return String.format("ID: %-10s Name: %-20s Programme: %-15s Marks: %.2f",
                id, name, programme, marks);
    }
}
