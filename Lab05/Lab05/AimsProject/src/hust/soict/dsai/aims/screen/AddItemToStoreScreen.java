package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected StoreScreen storeScreen;

    public AddItemToStoreScreen(Store store, StoreScreen storeScreen) {
        this.store = store;
        this.storeScreen = storeScreen;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        addBook.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store, storeScreen);
        });
        addCD.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store, storeScreen);
        });
        addDVD.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store, storeScreen);
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            storeScreen.refreshStore();
            storeScreen.setVisible(true);
            dispose();
        });
        menu.add(viewStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    protected JPanel createFormRow(String labelText, JComponent field) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(120, 25));
        row.add(label);
        row.add(field);
        return row;
    }
}
