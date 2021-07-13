package t3spacetrader.SpaceTrader;
import org.json.JSONObject;

public class SpaceTraderOffline implements SpaceTrader {

    private String name = "";
    private String token = "01-23-45-67-89";

    public SpaceTraderOffline() {}

    @Override
    public JSONObject getStatus() {
        return new JSONObject().put("status", "You are offline.");
    }

    @Override
    public JSONObject getUserToken(String name) {
        if(this.name.equals(name)) {
            return new JSONObject().put("error", "Username already exist.");
        }
        this.name = name;
        return new JSONObject().put("token", "01-23-45-67-89");
    }

    @Override
    public JSONObject getUserInfo(String token, String username)  {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }
        return new JSONObject("{\n" +
                "  \"user\": {\n" +
                "    \"credits\": 0,\n" +
                "    \"loans\": [\n{\n" +
                "        \"due\": \"2021-03-10T00:39:03.890Z\",\n" +
                "        \"id\": \"cklzuwr840088jpvqhvyrgk73\",\n" +
                "        \"repaymentAmount\": 168000,\n" +
                "        \"status\": \"PAID\",\n" +
                "        \"type\": \"STARTUP\"\n" +
                "      }\n],\n" +
                "    \"ships\": [\n{\n" +
                "        \"cargo\": [\n" +
                "          {\n" +
                "            \"good\": \"FUEL\",\n" +
                "            \"quantity\": 4,\n" +
                "            \"totalVolume\": 4\n" +
                "          }\n" +
                "        ],\n" +
                "        \"class\": \"MK-I\",\n" +
                "        \"id\": \"cklzv1dih0238jpvqvr19pk62\",\n" +
                "        \"location\": \"OE-PM\",\n" +
                "        \"manufacturer\": \"Jackshaw\",\n" +
                "        \"maxCargo\": 100,\n" +
                "        \"plating\": 5,\n" +
                "        \"spaceAvailable\": 96,\n" +
                "        \"speed\": 2,\n" +
                "        \"type\": \"JW-MK-I\",\n" +
                "        \"weapons\": 5\n" +
                "      }\n],\n" +
                "    \"username\": \"space-trader\"\n" +
                "  }\n" +
                "}");
    }

    @Override
    public JSONObject getLoansInfo(String token) {
        if(!this.token.equals(token)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }
        JSONObject obj = new JSONObject("{\n" +
                "  \"loans\": [\n" +
                "    {\n" +
                "      \"amount\": 200000,\n" +
                "      \"collateralRequired\": false,\n" +
                "      \"rate\": 40,\n" +
                "      \"termInDays\": 2,\n" +
                "      \"type\": \"STARTUP\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        return obj;
    }

    @Override
    public JSONObject obtainLoan(String token, String username, String type) {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }
        return new JSONObject("{\n" +
                "  \"credits\": 200000,\n" +
                "  \"loan\": {\n" +
                "    \"due\": \"2021-04-21T07:01:42.868Z\",\n" +
                "    \"id\": \"ckno92mhi0049iiopc2kmylkz\",\n" +
                "    \"repaymentAmount\": 280000,\n" +
                "    \"status\": \"CURRENT\",\n" +
                "    \"type\": \"STARTUP\"\n" +
                "  }\n" +
                "}");
    }


    @Override
    public JSONObject payOffLoan(String token, String username, String loanID) {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }
        return new JSONObject("{\n" +
                "  \"user\": {\n" +
                "    \"credits\": 32000,\n" +
                "    \"loans\": [\n" +
                "      {\n" +
                "        \"due\": \"2021-03-10T00:39:03.890Z\",\n" +
                "        \"id\": \"cklzuwr840088jpvqhvyrgk73\",\n" +
                "        \"repaymentAmount\": 168000,\n" +
                "        \"status\": \"PAID\",\n" +
                "        \"type\": \"STARTUP\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"ships\": [\n" +
                "      {\n" +
                "        \"cargo\": [\n" +
                "          {\n" +
                "            \"good\": \"FUEL\",\n" +
                "            \"quantity\": 4,\n" +
                "            \"totalVolume\": 4\n" +
                "          }\n" +
                "        ],\n" +
                "        \"class\": \"MK-I\",\n" +
                "        \"id\": \"cklzv1dih0238jpvqvr19pk62\",\n" +
                "        \"location\": \"OE-PM\",\n" +
                "        \"manufacturer\": \"Jackshaw\",\n" +
                "        \"maxCargo\": 100,\n" +
                "        \"plating\": 5,\n" +
                "        \"spaceAvailable\": 96,\n" +
                "        \"speed\": 2,\n" +
                "        \"type\": \"JW-MK-I\",\n" +
                "        \"weapons\": 5\n" +
                "      }\n" +
                "    ],\n" +
                "    \"username\": \"space-trader\"\n" +
                "  }\n" +
                "}");
    }

    @Override
    public JSONObject getShipsInfo(String token, String Class) {
        if(!this.token.equals(token)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }
        return new JSONObject("{\n" +
                "  \"ships\": [\n" +
                "    {\n" +
                "      \"class\": \"MK-I\",\n" +
                "      \"manufacturer\": \"Gravager\",\n" +
                "      \"maxCargo\": 300,\n" +
                "      \"plating\": 10,\n" +
                "      \"purchaseLocations\": [\n" +
                "        {\n" +
                "          \"location\": \"OE-PM-TR\",\n" +
                "          \"price\": 184000\n" +
                "        },\n" +
                "        {\n" +
                "          \"location\": \"OE-NY\",\n" +
                "          \"price\": 184000\n" +
                "        }\n" +
                "      ],\n" +
                "      \"speed\": 1,\n" +
                "      \"type\": \"GR-MK-I\",\n" +
                "      \"weapons\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"class\": \"MK-I\",\n" +
                "      \"manufacturer\": \"Jackshaw\",\n" +
                "      \"maxCargo\": 100,\n" +
                "      \"plating\": 5,\n" +
                "      \"purchaseLocations\": [\n" +
                "        {\n" +
                "          \"location\": \"OE-PM-TR\",\n" +
                "          \"price\": 94000\n" +
                "        },\n" +
                "        {\n" +
                "          \"location\": \"OE-NY\",\n" +
                "          \"price\": 94000\n" +
                "        }\n" +
                "      ],\n" +
                "      \"speed\": 2,\n" +
                "      \"type\": \"JW-MK-I\",\n" +
                "      \"weapons\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"class\": \"MK-I\",\n" +
                "      \"manufacturer\": \"Electrum\",\n" +
                "      \"maxCargo\": 100,\n" +
                "      \"plating\": 5,\n" +
                "      \"purchaseLocations\": [\n" +
                "        {\n" +
                "          \"location\": \"OE-NY\",\n" +
                "          \"price\": 302400\n" +
                "        }\n" +
                "      ],\n" +
                "      \"speed\": 2,\n" +
                "      \"type\": \"EM-MK-I\",\n" +
                "      \"weapons\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    @Override
    public JSONObject purchaseShip(String token, String username, String type, String location) {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }

        return new JSONObject("{\n" +
                "  \"credits\": 178875,\n" +
                "  \"ship\": {\n" +
                "    \"cargo\": [],\n" +
                "    \"class\": \"MK-I\",\n" +
                "    \"id\": \"ckno9324k0079iiop71j5nrob\",\n" +
                "    \"location\": \"OE-PM-TR\",\n" +
                "    \"manufacturer\": \"Jackshaw\",\n" +
                "    \"maxCargo\": 50,\n" +
                "    \"plating\": 5,\n" +
                "    \"spaceAvailable\": 50,\n" +
                "    \"speed\": 1,\n" +
                "    \"type\": \"JW-MK-I\",\n" +
                "    \"weapons\": 5,\n" +
                "    \"x\": 23,\n" +
                "    \"y\": -28\n" +
                "  }\n" +
                "}");
    }

    @Override
    public JSONObject purchaseGoods(String token, String username, String shipID, String good, String quantity) {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }

        return new JSONObject("{\n" +
                "  \"credits\": 178725,\n" +
                "  \"order\": {\n" +
                "    \"good\": \"METALS\",\n" +
                "    \"pricePerUnit\": 3,\n" +
                "    \"quantity\": 30,\n" +
                "    \"total\": 90\n" +
                "  },\n" +
                "  \"ship\": {\n" +
                "    \"cargo\": [\n" +
                "      {\n" +
                "        \"good\": \"FUEL\",\n" +
                "        \"quantity\": 20,\n" +
                "        \"totalVolume\": 20\n" +
                "      },\n" +
                "      {\n" +
                "        \"good\": \"METALS\",\n" +
                "        \"quantity\": 30,\n" +
                "        \"totalVolume\": 30\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class\": \"MK-I\",\n" +
                "    \"id\": \"ckne4w8me01141ds62dnui0c8\",\n" +
                "    \"location\": \"OE-PM-TR\",\n" +
                "    \"manufacturer\": \"Jackshaw\",\n" +
                "    \"maxCargo\": 50,\n" +
                "    \"plating\": 5,\n" +
                "    \"spaceAvailable\": 0,\n" +
                "    \"speed\": 1,\n" +
                "    \"type\": \"JW-MK-I\",\n" +
                "    \"weapons\": 5,\n" +
                "    \"x\": 23,\n" +
                "    \"y\": -28\n" +
                "  }\n" +
                "}");
    }

    @Override
    public JSONObject viewMarketDetails(String token, String marketSymbol) {
        if(!this.token.equals(token)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }

        return new JSONObject("{\n" +
                "  \"location\": {\n" +
                "    \"marketplace\": [\n" +
                "      {\n" +
                "        \"pricePerUnit\": 4,\n" +
                "        \"quantityAvailable\": 406586,\n" +
                "        \"symbol\": \"METALS\",\n" +
                "        \"volumePerUnit\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"pricePerUnit\": 231,\n" +
                "        \"quantityAvailable\": 5407,\n" +
                "        \"symbol\": \"MACHINERY\",\n" +
                "        \"volumePerUnit\": 4\n" +
                "      },\n" +
                "      {\n" +
                "        \"pricePerUnit\": 8,\n" +
                "        \"quantityAvailable\": 406586,\n" +
                "        \"symbol\": \"CHEMICALS\",\n" +
                "        \"volumePerUnit\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"pricePerUnit\": 1,\n" +
                "        \"quantityAvailable\": 462806,\n" +
                "        \"symbol\": \"FUEL\",\n" +
                "        \"volumePerUnit\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"pricePerUnit\": 127,\n" +
                "        \"quantityAvailable\": 19961,\n" +
                "        \"symbol\": \"SHIP_PLATING\",\n" +
                "        \"volumePerUnit\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"pricePerUnit\": 30,\n" +
                "        \"quantityAvailable\": 403,\n" +
                "        \"symbol\": \"DRONES\",\n" +
                "        \"volumePerUnit\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"pricePerUnit\": 1283,\n" +
                "        \"quantityAvailable\": 8738,\n" +
                "        \"symbol\": \"SHIP_PARTS\",\n" +
                "        \"volumePerUnit\": 5\n" +
                "      }\n" +
                "    ],\n" +
                "    \"name\": \"Tritus\",\n" +
                "    \"symbol\": \"OE-PM-TR\",\n" +
                "    \"type\": \"MOON\",\n" +
                "    \"x\": 21,\n" +
                "    \"y\": -26\n" +
                "  }\n" +
                "}");
    }

    @Override
    public JSONObject getNearbyLocation(String token, String systemSymbol, String type) {
        if(!this.token.equals(token)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }

        return new JSONObject("{\n" +
                "  \"locations\": [\n" +
                "    {\n" +
                "      \"name\": \"Carth\",\n" +
                "      \"symbol\": \"OE-CR\",\n" +
                "      \"type\": \"PLANET\",\n" +
                "      \"x\": 16,\n" +
                "      \"y\": 17\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Koria\",\n" +
                "      \"symbol\": \"OE-KO\",\n" +
                "      \"type\": \"PLANET\",\n" +
                "      \"x\": -48,\n" +
                "      \"y\": -7\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Ucarro\",\n" +
                "      \"symbol\": \"OE-UC\",\n" +
                "      \"type\": \"PLANET\",\n" +
                "      \"x\": -75,\n" +
                "      \"y\": 82\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Prime\",\n" +
                "      \"symbol\": \"OE-PM\",\n" +
                "      \"type\": \"PLANET\",\n" +
                "      \"x\": 20,\n" +
                "      \"y\": -25\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    @Override
    public JSONObject createFlightPlan(String token, String username, String shipID, String destiantion) {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }

        return new JSONObject("{\n" +
                "  \"flightPlan\": {\n" +
                "    \"arrivesAt\": \"2021-03-08T06:41:19.658Z\",\n" +
                "    \"departure\": \"OE-PM-TR\",\n" +
                "    \"destination\": \"OE-PM\",\n" +
                "    \"distance\": 1,\n" +
                "    \"fuelConsumed\": 1,\n" +
                "    \"fuelRemaining\": 19,\n" +
                "    \"id\": \"ckm07t6ki0038060jv7b2x5gk\",\n" +
                "    \"shipId\": \"ckm07ezq50354ti0j1drcey9v\",\n" +
                "    \"terminatedAt\": null,\n" +
                "    \"timeRemainingInSeconds\": 67\n" +
                "  }\n" +
                "}");
    }

    @Override
    public JSONObject viewFlightPan(String token, String username, String flightPlanID) {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }
        return new JSONObject("{\n" +
                "  \"flightPlan\": {\n" +
                "    \"arrivesAt\": \"2021-03-08T06:41:19.658Z\",\n" +
                "    \"departure\": \"OE-PM-TR\",\n" +
                "    \"destination\": \"OE-PM\",\n" +
                "    \"distance\": 1,\n" +
                "    \"fuelConsumed\": 1,\n" +
                "    \"fuelRemaining\": 19,\n" +
                "    \"id\": \"ckm07t6ki0038060jv7b2x5gk\",\n" +
                "    \"shipId\": \"ckm07ezq50354ti0j1drcey9v\",\n" +
                "    \"terminatedAt\": \"2021-03-08T06:41:18.752Z\",\n" +
                "    \"timeRemainingInSeconds\": 0\n" +
                "  }\n" +
                "}");
    }

    @Override
    public JSONObject sellGoods(String token, String username, String shipID, String good, String quantity) {
        if(!this.token.equals(token) || !this.name.equals(username)) {
            return new JSONObject().put("error", "Invalid token or Username");
        }
        return new JSONObject("{\n" +
                "  \"credits\": 178935,\n" +
                "  \"order\": {\n" +
                "    \"good\": \"METALS\",\n" +
                "    \"pricePerUnit\": 7,\n" +
                "    \"quantity\": 30,\n" +
                "    \"total\": 210\n" +
                "  },\n" +
                "  \"ship\": {\n" +
                "    \"cargo\": [\n" +
                "      {\n" +
                "        \"good\": \"FUEL\",\n" +
                "        \"quantity\": 18,\n" +
                "        \"totalVolume\": 18\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class\": \"MK-I\",\n" +
                "    \"id\": \"ckne4w8me01141ds62dnui0c8\",\n" +
                "    \"location\": \"OE-PM\",\n" +
                "    \"manufacturer\": \"Jackshaw\",\n" +
                "    \"maxCargo\": 50,\n" +
                "    \"plating\": 5,\n" +
                "    \"spaceAvailable\": 32,\n" +
                "    \"speed\": 1,\n" +
                "    \"type\": \"JW-MK-I\",\n" +
                "    \"weapons\": 5,\n" +
                "    \"x\": 20,\n" +
                "    \"y\": -25\n" +
                "  }\n" +
                "}");
    }
}
