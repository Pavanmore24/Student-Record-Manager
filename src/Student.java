public class Student {
    private int ID;
    private String Name;
    private int Mark;

    public Student(int id, String name, int mark) {
        this.ID = id;
        this.Name = name;
        this.Mark = mark;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        this.Mark = mark;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + Name + ", Marks: " + Mark;
    }
}
