package t3spacetrader.SpaceTrader;

import org.json.JSONObject;

public interface SpaceTrader {

    JSONObject getStatus();

    JSONObject getUserToken(String name);

    JSONObject getUserInfo(String token, String username);

    JSONObject getLoansInfo(String token);

    JSONObject obtainLoan(String token, String username, String type);

    JSONObject payOffLoan(String token, String username, String loanID);

    JSONObject getShipsInfo(String token, String Class);

    JSONObject purchaseShip(String token, String username, String type, String location);

    JSONObject purchaseGoods(String token, String username, String shipID, String good, String quantity);

    JSONObject viewMarketDetails(String token, String marketSymbol);

    JSONObject getNearbyLocation(String token, String systemSymbol, String type);

    JSONObject createFlightPlan(String token, String username, String shipID, String destiantion);

    JSONObject viewFlightPan(String token, String username, String flightPlanID);

    JSONObject sellGoods(String token, String username, String shipID, String good, String quantity);

}
