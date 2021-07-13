package t3spacetrader.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ship {
    @SerializedName("class")
    public String Class;
    public String manufacturer;
    public int maxCargo;
    public int plating;
    public List<PurchaseLocation> purchaseLocations;
    public int speed;
    public String type;
    public int weapons;
}
