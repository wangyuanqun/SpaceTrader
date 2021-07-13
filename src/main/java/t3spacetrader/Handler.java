package t3spacetrader;

import t3spacetrader.Data.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Handler {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static List<Loan> getLoan(JSONArray arr) {
        return gson.fromJson(arr.toString(), new TypeToken<List<Loan>>() {}.getType());
    }

    public static UserInfo getUserInfo(JSONObject obj) {
        return gson.fromJson(obj.toString(), UserInfo.class);
    }

    public static List<Location> getLocation(JSONArray arr) {
        return gson.fromJson(arr.toString(), new TypeToken<List<Location>>() {}.getType());
    }

    public static MarketLocation getMarketLocation(JSONObject obj) {
        return gson.fromJson(obj.toString(), MarketLocation.class);
    }

    public static List<Ship> getShips(JSONArray arr) {
        return gson.fromJson(arr.toString(), new TypeToken<List<Ship>>() {}.getType());
    }

    public static FlightPlan getFlightPlan(JSONObject obj) {
        return gson.fromJson(obj.toString(), FlightPlan.class);
    }

}
