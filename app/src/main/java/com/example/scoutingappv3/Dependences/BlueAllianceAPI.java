package com.example.scoutingappv3.Dependences;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class BlueAllianceAPI {

    private static final String BASE_URL = "https://www.thebluealliance.com/api/v3/";
    private static final String EVENT_KEY = Config.EventCode; // Replace with your actual event key
    private static final String AUTH_KEY = "tD5zTqislusLlVgErcawIdnqG50ziLq3Kqqnl27bw2LxLKenNGO3fXrxFaoIaFmr"; // Replace with your actual TBA API key

    public static String[] getMatchTeams(int matchNumber) {
        try {
            String matchKey = EVENT_KEY + "_qm" + matchNumber;
            URL url = new URL(BASE_URL + "match/" + matchKey);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-TBA-Auth-Key", AUTH_KEY);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();

            JSONObject matchData = new JSONObject(response.toString());
            JSONObject alliances = matchData.getJSONObject("alliances");

            JSONArray redTeams = alliances.getJSONObject("red").getJSONArray("team_keys");
            JSONArray blueTeams = alliances.getJSONObject("blue").getJSONArray("team_keys");

            String[] teams = new String[6];

            // Red alliance: positions 0-2
            for (int i = 0; i < redTeams.length(); i++) {
                teams[i] = redTeams.getString(i);
            }

            // Blue alliance: positions 3-5
            for (int i = 0; i < blueTeams.length(); i++) {
                teams[i + 3] = blueTeams.getString(i);
            }

            return teams;

        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"Error fetching data"};
        }
    }
}
