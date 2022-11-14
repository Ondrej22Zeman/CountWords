public class Word {
    private String name;
    private int count;

    public Word(String name) {
        this.name = name;
        this.count = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count += 1;
    }
}
