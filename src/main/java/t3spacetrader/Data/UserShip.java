package t3spacetrader.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserShip {

    public List<Cargo> cargo;
    @SerializedName("class")
    public String clas;
    public String id;
    @SerializedName("location")
    public String loc;
    public String manufacturer;
    public int maxCargo;
    public int plating;
    public int spaceAvailable;
    public int speed;
    @SerializedName("type")
    public String typ;
    public int weapons;

}
