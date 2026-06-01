package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfCost = new JTextField(20);
    private JTextField tfArtist = new JTextField(20);

    public AddCompactDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);
        setTitle("Add CD to Store");
        setSize(400, 280);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createMenuBar(), BorderLayout.NORTH);

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        form.add(createFormRow("Title:", tfTitle));
        form.add(createFormRow("Category:", tfCategory));
        form.add(createFormRow("Cost:", tfCost));
        form.add(createFormRow("Artist:", tfArtist));

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            String costStr = tfCost.getText().trim();
            String artist = tfArtist.getText().trim();
            if (title.isEmpty() || costStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Title and Cost are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float cost = Float.parseFloat(costStr);
            CompactDisc cd = new CompactDisc(title, category, cost, artist);
            store.addMedia(cd);
            storeScreen.refreshStore();
            JOptionPane.showMessageDialog(this, "CD added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAdd);
        form.add(btnPanel);
        cp.add(form, BorderLayout.CENTER);
        setVisible(true);
    }
}
