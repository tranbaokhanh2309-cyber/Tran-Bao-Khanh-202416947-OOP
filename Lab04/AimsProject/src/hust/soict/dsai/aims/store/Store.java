package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is not found in the store.");
        }
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}
