package Model;

public class author {

    private int author_id;
    private String name;

    public author() {}

    public author(String name) {
        super();
        this.name = name;
    }
    public author(int author_id, String name) {
        super();
        this.name = name;
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "author [author_id=" + author_id + ", name=" + name + "]";
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}