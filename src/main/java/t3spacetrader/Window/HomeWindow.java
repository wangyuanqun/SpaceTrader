package t3spacetrader.Window;

import t3spacetrader.Data.*;
import t3spacetrader.Handler;
import t3spacetrader.LoadInfo;
import t3spacetrader.SpaceTrader.SpaceMaker;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.JSONObject;

import java.util.Date;


public class HomeWindow {

    private final SpaceMaker spaceMaker = SpaceMaker.getMaker();

    @FXML
    private TableView<Loan> loanInfo;
    @FXML
    private TableColumn<Loan, Integer> amount;
    @FXML
    private TableColumn<Loan, Boolean> require;
    @FXML
    private TableColumn<Loan, Integer> rate;
    @FXML
    private TableColumn<Loan, Integer> term;
    @FXML
    private TableColumn<Loan, String> type;

    @FXML
    private TableView<UserLoan> activeLoan;
    @FXML
    private TableColumn<UserLoan, Date> due;
    @FXML
    private TableColumn<UserLoan, Integer> repay;
    @FXML
    private TableColumn<UserLoan, String> id;
    @FXML
    private TableColumn<UserLoan, String> status;
    @FXML
    private TableColumn<UserLoan, String> typeA;

    @FXML
    private  TableView<Location> locations;
    @FXML
    private TableColumn<Location, String> locationName;
    @FXML
    private TableColumn<Location, String> locationSymbol;
    @FXML
    private TableColumn<Location, String> locationType;
    @FXML
    private TableColumn<Location, Integer> locationX;
    @FXML
    private TableColumn<Location, Integer> locationY;

    @FXML
    private  TableView<MarketPlace> marketLocation;
    @FXML
    private TableColumn<MarketPlace, Integer> marketP;
    @FXML
    private TableColumn<MarketPlace, Integer> marketQ;
    @FXML
    private TableColumn<MarketPlace, String> marketS;
    @FXML
    private TableColumn<MarketPlace, Integer> marketV;

    @FXML
    private TableView<Ship> ship;
    @FXML
    private TableColumn<Ship, String> shipClass;
    @FXML
    private TableColumn<Ship, String> shipMan;
    @FXML
    private TableColumn<Ship, Integer> shipCa;
    @FXML
    private TableColumn<Ship, Integer> shipPl;
    @FXML
    private TableColumn<Ship, Integer> shipSp;
    @FXML
    private TableColumn<Ship, String> shipTy;
    @FXML
    private TableColumn<Ship, Integer> shipWe;

    @FXML
    private TableView<PurchaseLocation> shipLoc;
    @FXML
    private TableColumn<PurchaseLocation, String> shipL;
    @FXML
    private TableColumn<PurchaseLocation, Integer> shipPr;

    @FXML
    private TableView<UserShip> userShip;
    @FXML
    private TableColumn<UserShip, String> userShipClass;
    @FXML
    private TableColumn<UserShip, String> userShipType;
    @FXML
    private TableColumn<UserShip, String> userShipId;
    @FXML
    private TableColumn<UserShip, String> userShipLoc;
    @FXML
    private TableColumn<UserShip, Integer> userShipSp;

    @FXML
    private TableView<UserShip> userShip1;
    @FXML
    private TableColumn<UserShip, String> userShipId1;
    @FXML
    private TableColumn<UserShip, String> userShipLoc1;
    @FXML
    private TableColumn<UserShip, Integer> userShipSp1;

    @FXML
    private TableView<Cargo> shipCargo;
    @FXML
    private TableColumn<Cargo, String> shipCargoGood;
    @FXML
    private TableColumn<Cargo, Integer> shipCargoQ;
    @FXML
    private TableColumn<Cargo, Integer> shipCargoTo;

    @FXML
    private TableView<UserShip> flightShip;
    @FXML
    private TableColumn<UserShip, String> flightShipId;
    @FXML
    private TableColumn<UserShip, String> flightShipLoc;
    @FXML
    private TableColumn<UserShip, Integer> flightShipSp;

    @FXML
    private TextField systemSymbol;
    @FXML
    private TextField systemType;
    @FXML
    private TextField marketSymbol;
    @FXML
    private TextField shipCl;
    @FXML
    private TextField username;
    @FXML
    private TextField credits;
    @FXML
    private TextField buyG;
    @FXML
    private TextField buyQ;
    @FXML
    private TextField sellG;
    @FXML
    private TextField sellQ;
    @FXML
    private TextField destination;
    @FXML
    private TextField flightId;
    @FXML
    private TextField viewId;

    @FXML
    private TextField arrive;
    @FXML
    private TextField depa;
    @FXML
    private TextField desti;
    @FXML
    private TextField dis;
    @FXML
    private TextField fc;
    @FXML
    private TextField fr;
    @FXML
    private TextField Id;
    @FXML
    private TextField shipId;
    @FXML
    private TextField ter;
    @FXML
    private TextField time;

    @FXML
    private Button obtain;
    @FXML
    private Button locationOk;
    @FXML
    private Button marketOk;
    @FXML
    private Button shipOk;
    @FXML
    private Button payoff;
    @FXML
    private Button buyShip;
    @FXML
    private Button sell;
    @FXML
    private Button purchase;
    @FXML
    private Button create;
    @FXML
    private Button view;


    public void initialize() {
        setTable();
        setText();
        setButton();
    }

    private void setButton() {

        view.setOnAction(e -> {
            if(viewId.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid Input.");
                alert.show();
            } else {
                JSONObject obj = spaceMaker.viewFlightPan(spaceMaker.getToken(), spaceMaker.getUsername(), viewId.getText());

                if(obj.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, obj.getJSONObject("error").getString("message"));
                    alert.show();
                    destination.clear();
                } else {
                    FlightPlan flight = Handler.getFlightPlan(obj.getJSONObject("flightPlan"));

                    arrive.setText(String.valueOf(flight.arrivesAt));
                    depa.setText(String.valueOf(flight.departure));
                    desti.setText(String.valueOf(flight.destination));
                    dis.setText(String.valueOf(flight.distance));
                    fc.setText(String.valueOf(flight.fuelConsumed));
                    fr.setText(String.valueOf(flight.fuelRemaining));
                    Id.setText(String.valueOf(flight.id));
                    shipId.setText(String.valueOf(flight.shipId));
                    ter.setText(String.valueOf(flight.terminatedAt));
                    time.setText(String.valueOf(flight.timeRemainingInSeconds));

                    arrive.setEditable(false);
                    depa.setEditable(false);
                    desti.setEditable(false);
                    dis.setEditable(false);
                    fc.setEditable(false);
                    fr.setEditable(false);
                    Id.setEditable(false);
                    shipId.setEditable(false);
                    ter.setEditable(false);
                    time.setEditable(false);
                }
            }
        });

        create.setOnAction(e -> {
            if(destination.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid Input.");
                alert.show();
            } else if(flightShip.getSelectionModel().selectedItemProperty().get() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please choose a ship.");
                alert.show();
            } else {
                JSONObject obj = spaceMaker.createFlightPlan(spaceMaker.getToken(), spaceMaker.getUsername(), flightShip.getSelectionModel().selectedItemProperty().get().id, destination.getText());

                if(obj.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, obj.getJSONObject("error").getString("message"));
                    alert.show();
                    destination.clear();
                } else {
                    FlightPlan flight = Handler.getFlightPlan(obj.getJSONObject("flightPlan"));

                    flightId.setText(flight.id);
                    flightId.setEditable(false);
                }
            }
        });

        sell.setOnAction(e -> {
            if(sellG.getText().isEmpty() || sellQ.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid Input.");
                alert.show();
            } else if(userShip1.getSelectionModel().selectedItemProperty().get() == null){
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please choose a ship.");
                alert.show();
            } else {

                JSONObject obj = spaceMaker.sellGoods(spaceMaker.getToken(), spaceMaker.getUsername(), userShip1.getSelectionModel().selectedItemProperty().get().id, sellG.getText(), sellQ.getText());

                if(obj.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, obj.getJSONObject("error").getString("message"));
                    alert.show();

                    sellG.clear();
                    sellQ.clear();
                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You sell goods successfully.");
                    alert.show();

                    sellG.clear();
                    sellQ.clear();

                    LoadInfo.loadUserShip1(userShip1, userShipId1, userShipLoc1, userShipSp1);
                    LoadInfo.loadUserShip1(flightShip, flightShipId, flightShipLoc, flightShipSp);
                    LoadInfo.loadUserShip(userShip, userShipClass, userShipType, userShipId, userShipLoc, userShipSp);
                    setText();
                }
            }
        });

        purchase.setOnAction(e -> {
            if(buyG.getText().isEmpty() || buyQ.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid Input.");
                alert.show();
            } else if(userShip1.getSelectionModel().selectedItemProperty().get() == null){
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please choose a ship.");
                alert.show();
            } else {

                JSONObject obj = spaceMaker.purchaseGoods(spaceMaker.getToken(), spaceMaker.getUsername(), userShip1.getSelectionModel().selectedItemProperty().get().id, buyG.getText(), buyQ.getText());

                if(obj.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, obj.getJSONObject("error").getString("message"));
                    alert.show();
                    buyQ.clear();
                    buyG.clear();
                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You buy goods successfully.");
                    alert.show();
                    buyQ.clear();
                    buyG.clear();

                    LoadInfo.loadUserShip1(userShip1, userShipId1, userShipLoc1, userShipSp1);
                    LoadInfo.loadUserShip1(flightShip, flightShipId, flightShipLoc, flightShipSp);
                    LoadInfo.loadUserShip(userShip, userShipClass, userShipType, userShipId, userShipLoc, userShipSp);
                    setText();
                }
            }
        });


        payoff.setOnAction(e -> {
            if(activeLoan.getSelectionModel().selectedItemProperty().get() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You need to select an active loan before pay off.");
                alert.show();
            } else {
                JSONObject obj = spaceMaker.payOffLoan(spaceMaker.getToken(), spaceMaker.getUsername(), activeLoan.getSelectionModel().selectedItemProperty().get().id);
                if(obj.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, obj.getJSONObject("error").getString("message"));
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You pay off a loan successfully.");
                    alert.show();
                    // update user loan table
                    LoadInfo.loadUserLoan(activeLoan, due, repay, id, status, typeA);
                    setText();
                }
            }
        });

        buyShip.setOnAction(e -> {
            if(ship.getSelectionModel().selectedItemProperty().get() == null || shipLoc.getSelectionModel().selectedItemProperty().get() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You need to select a ship and ship location before buy.");
                alert.show();
            }else {
                JSONObject obj = spaceMaker.purchaseShip(spaceMaker.getToken(), spaceMaker.getUsername(), ship.getSelectionModel().selectedItemProperty().get().type, shipLoc.getSelectionModel().selectedItemProperty().get().shipLocation);
                if(obj.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, obj.getJSONObject("error").getString("message"));
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You buy a ship successfully, please check your info.");
                    alert.show();
                    // update user ship table
                    LoadInfo.loadUserShip(userShip, userShipClass, userShipType, userShipId, userShipLoc, userShipSp);
                    LoadInfo.loadUserShip1(userShip1, userShipId1, userShipLoc1, userShipSp1);
                    LoadInfo.loadUserShip1(flightShip, flightShipId, flightShipLoc, flightShipSp);
                    setText();
                }
            }
        });

        obtain.setOnAction(e -> {
            if(loanInfo.getSelectionModel().selectedItemProperty().get() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You need to select an available loan before obtain one.");
                alert.show();
            } else {
                JSONObject obj = spaceMaker.obtainLoan(spaceMaker.getToken(), spaceMaker.getUsername(), loanInfo.getSelectionModel().selectedItemProperty().get().type);
                if(obj.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, obj.getJSONObject("error").getString("message"));
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You obtain a loan successfully.");
                    alert.show();
                    // update user loan table
                    LoadInfo.loadUserLoan(activeLoan, due, repay, id, status, typeA);
                    setText();
                }
            }
        });

        locationOk.setOnAction(e -> {
            if(systemSymbol.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid Input.");
                alert.show();
            } else {
                LoadInfo.loadLocation(locations, locationName, locationSymbol, locationType, locationX, locationY, systemSymbol.getText(), systemType.getText());
            }
        });

        marketOk.setOnAction(e -> {
            if(marketSymbol.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid Input.");
                alert.show();
            } else {
                LoadInfo.loadMarketLocation(marketLocation, marketP, marketQ, marketS, marketV, marketSymbol.getText());
            }
        });

        shipOk.setOnAction(e -> LoadInfo.loadShip(ship, shipClass, shipMan, shipCa, shipPl, shipSp, shipTy, shipWe, shipCl.getText()));

    }

    private void setTable() {

        //load loans table
        LoadInfo.loadLoan(loanInfo, amount, require, rate, term, type);
        LoadInfo.loadUserLoan(activeLoan, due, repay, id, status, typeA);
        LoadInfo.loadShip(ship, shipClass, shipMan, shipCa, shipPl, shipSp, shipTy, shipWe, "");

        // ship table listener
        ship.getSelectionModel().selectedItemProperty().addListener((obs, old, newSelection) -> {
            if(newSelection == null) {
                return;
            }

            shipL.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().shipLocation));
            shipPr.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().price));
            shipLoc.getItems().clear();
            shipLoc.getItems().addAll(newSelection.purchaseLocations);
        });

        // user ship table, usership listener
        LoadInfo.loadUserShip1(userShip1, userShipId1, userShipLoc1, userShipSp1);
        LoadInfo.loadUserShip1(flightShip, flightShipId, flightShipLoc, flightShipSp);
        LoadInfo.loadUserShip(userShip, userShipClass, userShipType, userShipId, userShipLoc, userShipSp);
        userShip.getSelectionModel().selectedItemProperty().addListener((obs, old, newSelection) -> {
            if(newSelection == null) {
                return;
            }

            shipCargoGood.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().good));
            shipCargoQ.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().quantity));
            shipCargoTo.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().totalVolume));
            shipCargo.getItems().clear();
            shipCargo.getItems().addAll(newSelection.cargo);
        });
    }

    private void setText() {
        UserInfo info = Handler.getUserInfo(spaceMaker.getUserInfo(spaceMaker.getToken(), spaceMaker.getUsername()).getJSONObject("user"));
        username.setText(info.username);
        credits.setText(String.valueOf(info.credits));
        username.setEditable(false);
        credits.setEditable(false);
    }
}