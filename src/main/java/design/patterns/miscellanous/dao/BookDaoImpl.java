package design.patterns.miscellanous.dao;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class BookDaoImpl implements BookDao{
    @Override
    public void create(Book b) {
        System.out.println("Book " + b.getName() + " created");
    }
}
