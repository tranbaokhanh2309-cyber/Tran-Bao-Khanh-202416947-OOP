package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String author) {
        authors.add(author);
    }

    public boolean removeAuthor(String author) {
        if (authors.contains(author)) {
            authors.remove(author);
            return true;
        }
        System.err.println("Author not found: " + author);
        return false;
    }

    public List<String> getAuthors() { return authors; }

    @Override
    public String toString() {
        return "Book [title=" + getTitle() + ", category=" + getCategory()
                + ", cost=" + getCost() + ", authors=" + authors + "]";
    }
}
