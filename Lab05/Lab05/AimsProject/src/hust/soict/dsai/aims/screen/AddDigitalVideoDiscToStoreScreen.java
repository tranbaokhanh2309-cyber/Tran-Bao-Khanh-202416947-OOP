package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfCost = new JTextField(20);
    private JTextField tfDirector = new JTextField(20);
    private JTextField tfLength = new JTextField(20);

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);
        setTitle("Add DVD to Store");
        setSize(400, 320);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createMenuBar(), BorderLayout.NORTH);

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        form.add(createFormRow("Title:", tfTitle));
        form.add(createFormRow("Category:", tfCategory));
        form.add(createFormRow("Cost:", tfCost));
        form.add(createFormRow("Director:", tfDirector));
        form.add(createFormRow("Length (min):", tfLength));

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            String costStr = tfCost.getText().trim();
            String director = tfDirector.getText().trim();
            String lengthStr = tfLength.getText().trim();
            if (title.isEmpty() || costStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Title and Cost are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float cost = Float.parseFloat(costStr);
            int length = lengthStr.isEmpty() ? 0 : Integer.parseInt(lengthStr);
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, director, length);
            store.addMedia(dvd);
            storeScreen.refreshStore();
            JOptionPane.showMessageDialog(this, "DVD added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAdd);
        form.add(btnPanel);
        cp.add(form, BorderLayout.CENTER);
        setVisible(true);
    }
}
