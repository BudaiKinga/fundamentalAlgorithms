package stream.model;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class SimpleObject {

    private int id;
    private String name;

    public SimpleObject(int id, String name) {
        this.id = id;
        this.name = name;
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
}
