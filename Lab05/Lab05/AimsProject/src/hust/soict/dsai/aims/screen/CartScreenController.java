package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblTotalCost;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        updateTotalCost();

        // Listen for selection changes
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });

        // Filter listener
        if (tfFilter != null) {
            tfFilter.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable,
                                    String oldValue, String newValue) {
                    showFilteredMedia(newValue);
                }
            });
        }
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Now Playing");
                alert.setHeaderText(null);
                alert.setContentText("Playing: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Player Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cart Empty");
            alert.setContentText("Your cart is empty!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setContentText("Order placed! Total: " + cart.totalCost() + " $");
            alert.showAndWait();
            cart.getItemsOrdered().clear();
            updateTotalCost();
        }
    }

    private void updateTotalCost() {
        if (lblTotalCost != null) {
            lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
        }
    }

    void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }
        FilteredList<Media> filtered = new FilteredList<>(cart.getItemsOrdered(), p -> {
            if (radioBtnFilterTitle != null && radioBtnFilterTitle.isSelected()) {
                return p.getTitle().toLowerCase().contains(filterText.toLowerCase());
            } else {
                return String.valueOf(p.getId()).contains(filterText);
            }
        });
        tblMedia.setItems(filtered);
    }
}
