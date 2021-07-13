package t3spacetrader.SpaceTrader;

import org.json.JSONObject;

public class SpaceMaker {

    private final SpaceTrader space;
    private static SpaceMaker maker;

    private String username = "";
    private String token = "";
    private boolean isSave = false;


    private SpaceMaker(boolean isOnline) {
        if(isOnline) {
            this.space = new SpaceTraderOnline();
        } else {
            this.space = new SpaceTraderOffline();
        }
    }

    public static SpaceMaker getMaker() {
        return  maker;
    }

    public static void init(String args) {
        if("offline".equals(args)){
            maker = new SpaceMaker(false);
        } else {
            maker = new SpaceMaker(true);
        }
    }

    public void setSave(boolean isSave) {
        this.isSave = isSave;
    }

    public boolean getSave() {
        return this.isSave;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return this.username;
    }

    public String getToken() {
        return this.token;
    }

    public JSONObject getStatus() {
        return space.getStatus();
    }

    public JSONObject getUserToken(String name) {
        return space.getUserToken(name);
    }

//======== below is required feature=======
    public JSONObject getUserInfo(String token, String username) {
        return space.getUserInfo(token, username);
    }

    public JSONObject getLoansInfo(String token) {
        return space.getLoansInfo(token);
    }

    public JSONObject obtainLoan(String token, String username, String type) {
        return space.obtainLoan(token, username, type);
    }

    public JSONObject payOffLoan(String token, String username, String loanID) {
        return space.payOffLoan(token, username, loanID);
    }

    public JSONObject getShipsInfo(String token, String Class) {
        return space.getShipsInfo(token, Class);
    }

    public JSONObject purchaseShip(String token, String username, String type, String location) {
        return space.purchaseShip(token, username, type, location);
    }

    public JSONObject purchaseGoods(String token, String username, String shipID, String good, String quantity) {
        return space.purchaseGoods(token, username, shipID, good, quantity);
    }

    public JSONObject viewMarketDetails(String token, String marketSymbol) {
        return space.viewMarketDetails(token, marketSymbol);
    }

    public JSONObject getNearbyLocation(String token, String systemSymbol, String type) {
        return space.getNearbyLocation(token, systemSymbol, type);
    }

    public JSONObject createFlightPlan(String token, String username, String shipID, String destiantion) {
        return space.createFlightPlan(token, username, shipID, destiantion);
    }

    public JSONObject viewFlightPan(String token, String username, String flightPlanID) {
        return space.viewFlightPan(token, username, flightPlanID);
    }

    public JSONObject sellGoods(String token, String username, String shipID, String good, String quantity) {
        return space.sellGoods(token, username, shipID, good, quantity);
    }


}
