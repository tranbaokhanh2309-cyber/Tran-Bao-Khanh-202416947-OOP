package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added to store: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public ArrayList<Media> getItemsInStore() { return itemsInStore; }

    public void printStore() {
        System.out.println("*****Store*****");
        for (Media m : itemsInStore) {
            System.out.println(m);
        }
    }
}
