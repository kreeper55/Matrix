package collections;

public class Group {
    private int id;
    private int[] data;

    public Group(int id, int ... data) {
        this.id = id;
        this.data = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
    }

    public void setId(int id)       { this.id = id; }

    public void setData(int[] data) { this.data = data; }

    public int getId()              { return id; }

    public int[] getData()          { return data; }

    public int length()             { return data.length; }
}
