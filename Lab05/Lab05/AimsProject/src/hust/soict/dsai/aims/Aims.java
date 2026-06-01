package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Populate the store with sample media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD1's Title", "category 1", 76.0f, "Director A", 90);
        Book book2 = new Book("Book2's Title", "category 2", 61.0f);
        book2.addAuthor("Author B");
        CompactDisc cd3 = new CompactDisc("CD3's Title", "category 3", 59.0f, "Artist C");
        cd3.addTrack(new Track("Track 1", 200));
        cd3.addTrack(new Track("Track 2", 180));

        CompactDisc cd4 = new CompactDisc("CD4's Title", "category 1", 38.0f, "Artist D");
        cd4.addTrack(new Track("Track A", 210));
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("DVD5's Title", "category 2", 43.0f, "Director E", 120);
        CompactDisc cd6 = new CompactDisc("CD6's Title", "category 3", 95.0f, "Artist F");
        cd6.addTrack(new Track("Track X", 190));

        Book book7 = new Book("Book7's Title", "category 1", 24.0f);
        book7.addAuthor("Author G");
        Book book8 = new Book("Book8's Title", "category 2", 78.0f);
        book8.addAuthor("Author H");
        CompactDisc cd9 = new CompactDisc("CD9's Title", "category 3", 95.0f, "Artist I");
        cd9.addTrack(new Track("Track Y", 175));

        store.addMedia(dvd1);
        store.addMedia(book2);
        store.addMedia(cd3);
        store.addMedia(cd4);
        store.addMedia(dvd5);
        store.addMedia(cd6);
        store.addMedia(book7);
        store.addMedia(book8);
        store.addMedia(cd9);

        // Add some media to cart for testing
        try {
            cart.addMedia(dvd1);
            cart.addMedia(cd3);
            cart.addMedia(book7);
        } catch (LimitExceededException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Test PlayerException handling
        DigitalVideoDisc badDvd = new DigitalVideoDisc("Bad DVD", "test", 10.0f, "Director", 0);
        try {
            badDvd.play();
        } catch (PlayerException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), "Illegal DVD Length", JOptionPane.ERROR_MESSAGE);
        }

        // Launch GUI
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }
}
