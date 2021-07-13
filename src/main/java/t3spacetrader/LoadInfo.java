package t3spacetrader;

import t3spacetrader.Data.*;
import t3spacetrader.SpaceTrader.SpaceMaker;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.json.JSONObject;

import java.util.Date;

public class LoadInfo {

    private final static SpaceMaker spaceMaker = SpaceMaker.getMaker();

    public static void loadLoan(TableView<Loan> loanInfo,
                                TableColumn<Loan, Integer> amount,
                                TableColumn<Loan, Boolean> require,
                                TableColumn<Loan, Integer> rate,
                                TableColumn<Loan, Integer> term,
                                TableColumn<Loan, String> type) {

        amount.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().amount));
        require.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().collateralRequired));
        rate.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().rate));
        term.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().termInDays));
        type.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().type));

        loanInfo.getItems().clear();

        loanInfo.getItems().addAll(Handler.getLoan(
                spaceMaker.getLoansInfo(spaceMaker.getToken()).getJSONArray("loans")));

    }

    public static void loadUserLoan(TableView<UserLoan> activeLoan,
                                    TableColumn<UserLoan, Date> due,
                                    TableColumn<UserLoan, Integer> repay,
                                    TableColumn<UserLoan, String> id,
                                    TableColumn<UserLoan, String> status,
                                    TableColumn<UserLoan, String> typeA) {

        typeA.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().type));
        due.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().due));
        repay.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().repaymentAmount));
        id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().id));
        status.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().status));

        activeLoan.getItems().clear();

        activeLoan.getItems().addAll(Handler.getUserInfo(spaceMaker.getUserInfo(spaceMaker.getToken(), spaceMaker.getUsername()).getJSONObject("user")).loans);
    }

    public static void loadUserShip(TableView<UserShip> userShip,
                                    TableColumn<UserShip, String> userShipClass,
                                    TableColumn<UserShip, String> userShipType,
                                    TableColumn<UserShip, String> userShipId,
                                    TableColumn<UserShip, String> userShipLoc,
                                    TableColumn<UserShip, Integer> userShipSp) {

        userShipClass.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().clas));
        userShipType.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().typ));
        userShipId.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().id));
        userShipLoc.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().loc));
        userShipSp.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().spaceAvailable));

        userShip.getItems().clear();

        userShip.getItems().addAll(Handler.getUserInfo(spaceMaker.getUserInfo(spaceMaker.getToken(), spaceMaker.getUsername()).getJSONObject("user")).ships);
    }

    public static void loadUserShip1(TableView<UserShip> userShip1,
                                     TableColumn<UserShip, String> userShipId1,
                                     TableColumn<UserShip, String> userShipLoc1,
                                     TableColumn<UserShip, Integer> userShipSp1) {

        userShipId1.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().id));
        userShipLoc1.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().loc));
        userShipSp1.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().spaceAvailable));

        userShip1.getItems().clear();

        userShip1.getItems().addAll(Handler.getUserInfo(spaceMaker.getUserInfo(spaceMaker.getToken(), spaceMaker.getUsername()).getJSONObject("user")).ships);
    }

    public static void loadLocation(TableView<Location> location,
                                    TableColumn<Location, String> locationName,
                                    TableColumn<Location, String> locationSymbol,
                                    TableColumn<Location, String> locationType,
                                    TableColumn<Location, Integer> locationX,
                                    TableColumn<Location, Integer> locationY, String systemSymbol, String type) {

        locationName.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().name));
        locationSymbol.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().symbol));
        locationType.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().type));
        locationX.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().x));
        locationY.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().y));

        location.getItems().clear();

        location.getItems().addAll(Handler.getLocation(
                spaceMaker.getNearbyLocation(spaceMaker.getToken(), systemSymbol, type).getJSONArray("locations")));

    }

    public static void loadMarketLocation(TableView<MarketPlace> marketLocation,
                                          TableColumn<MarketPlace, Integer> marketP,
                                          TableColumn<MarketPlace, Integer> marketQ,
                                          TableColumn<MarketPlace, String> marketS,
                                          TableColumn<MarketPlace, Integer> marketV,
                                          String systemSymbol) {

        marketP.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().pricePerUnit));
        marketQ.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().quantityAvailable));
        marketS.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().symbol));
        marketV.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().volumePerUnit));

        marketLocation.getItems().clear();

        if(spaceMaker.viewMarketDetails(spaceMaker.getToken(), systemSymbol).toString().contains("error")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, spaceMaker.viewMarketDetails(spaceMaker.getToken(), systemSymbol).getJSONObject("error").getString("message"));
            alert.show();
        } else {
            JSONObject obj = spaceMaker.viewMarketDetails(spaceMaker.getToken(), systemSymbol).getJSONObject("location");
            marketLocation.getItems().addAll(Handler.getMarketLocation(obj).marketplace);
        }

    }

    public static void loadShip(TableView<Ship> ship,
                                TableColumn<Ship, String> shipClass,
                                TableColumn<Ship, String> shipMan,
                                TableColumn<Ship, Integer> shipCa,
                                TableColumn<Ship, Integer> shipPl,
                                TableColumn<Ship, Integer> shipSp,
                                TableColumn<Ship, String> shipTy,
                                TableColumn<Ship, Integer> shipWe,
                                String classs) {

        shipClass.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().Class));
        shipMan.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().manufacturer));
        shipCa.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().maxCargo));
        shipPl.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().plating));
        shipSp.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().speed));
        shipTy.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().type));
        shipWe.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().weapons));

        ship.getItems().clear();

        ship.getItems().addAll(Handler.getShips(
                spaceMaker.getShipsInfo(spaceMaker.getToken(), classs).getJSONArray("ships")));

    }


}
