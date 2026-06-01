package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media m) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m);
            System.out.println("Added to cart: " + m.getTitle());
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public void removeMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
            System.out.println("Removed from cart: " + m.getTitle());
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }

    public ObservableList<Media> getItemsOrdered() { return itemsOrdered; }

    public void printCart() {
        System.out.println("*****Cart*****");
        for (Media m : itemsOrdered) {
            System.out.println(m);
        }
        System.out.printf("Total cost: %.2f $%n", totalCost());
    }
}
