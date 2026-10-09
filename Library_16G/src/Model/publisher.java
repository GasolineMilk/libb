package Model;

public class publisher {

    private int publisher_id;
    private String name;

    public publisher() {}

    public publisher(int publisher_id, String name) {
        super();
        this.publisher_id = publisher_id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "publisher [publisher_id=" + publisher_id + ", name=" + name + "]";
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}