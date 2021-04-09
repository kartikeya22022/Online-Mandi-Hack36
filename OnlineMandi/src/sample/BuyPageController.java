package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class BuyPageController implements Initializable {
    @FXML
    private TableColumn cropNameTableColumn;
    @FXML
    private TableColumn priceTableColumn;
    @FXML
    private TableColumn quantityTableColumn;
    @FXML
    private TableView cropTableView;
    @FXML
    private TextArea descriptionTextArea;

    private String phoneNo;
    private String name;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final ObservableList<Offer> data = FXCollections.observableList(SellerTable.getInstance().getAllOffers());
        cropNameTableColumn.setCellValueFactory(
                new PropertyValueFactory<Offer,Integer>("cropName")
        );
        priceTableColumn.setCellValueFactory(
                new PropertyValueFactory<Offer,Integer>("price")
        );
        quantityTableColumn.setCellValueFactory(
                new PropertyValueFactory<Offer,Integer>("quantity")
        );
        cropTableView.setItems(data);
        cropTableView.getSelectionModel().select(0);
        setDescriptionTextArea();
    }
    @FXML
    public void clickItem(MouseEvent event) {
        setDescriptionTextArea();
    }

    public void setDescriptionTextArea() {
        Offer offer = (Offer)cropTableView.getSelectionModel().getSelectedItem();
        descriptionTextArea.setText("OfferID: "+offer.getOfferId()+"\n"+
                        "Seller Name: "+offer.getSellerName()+"\n"+
                        "Seller Phone Number: "+offer.getSellerPhone()+"\n"+
                        "Crop Name: "+offer.getCropName()+"\n"+
                        "Quantity: "+offer.getQuantity()+"\n"+
                        "Price/KG: "+offer.getPrice()+"\n"+
                        "Sale start date: "+offer.getStartDate().toString()+"\n"+
                        "Sale end date: "+offer.getEndDate().toString()+"\n"
                );
    }
}
