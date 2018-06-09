package collections;


public class Data {
    private String name;
    private Group[] groups;

    public Data(String name, Group ... groups) {
        this.name = name;
        this.groups = new Group[groups.length];
        for (int i = 0; i < groups.length; i++) {
            this.groups[i] = groups[i];
        }
    }

    public void setName(String name)        { this.name = name; }

    public void setGroups(Group[] groups)   { this.groups = groups; }

    public String getName()                 { return name; }

    public Group[] getGroups()              { return groups; }

    public int length()                     { return groups.length; }

    public DataIterator iterator()          { return new DataIterator(this);
    }
}
