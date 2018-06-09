package collections;

public class DataIterator {

    private Data data;
    private int currNumber, currGroup;

    public DataIterator(Data data) {
        this.data = data;
        this.currNumber = 0;
        this.currGroup = 0;
    }

    public int next() {
        int temp = data.getGroups()[currGroup].getData()[currNumber];
        currNumber++;
        if (currNumber == data.getGroups()[currGroup].length()) {
            currNumber = 0;
            currGroup++;
        }
        return temp;
    }

    public boolean hasNext() {
        return ((currGroup != data.length()) && (currNumber != data.getGroups()[currGroup].length()));
    }
}
