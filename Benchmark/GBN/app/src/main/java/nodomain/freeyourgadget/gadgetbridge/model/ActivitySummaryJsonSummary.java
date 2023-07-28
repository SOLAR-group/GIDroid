package nodomain.freeyourgadget.gadgetbridge.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiActivitySummaryParser;
import nodomain.freeyourgadget.gadgetbridge.entities.BaseActivitySummary;

public class ActivitySummaryJsonSummary {
    private static final Logger LOG = LoggerFactory.getLogger(ActivitySummaryJsonSummary.class);
    private JSONObject groupData;
    private JSONObject summaryData;
    private JSONObject summaryGroupedList;
    private BaseActivitySummary baseActivitySummary;

    public ActivitySummaryJsonSummary(BaseActivitySummary baseActivitySummary){
        this.baseActivitySummary=baseActivitySummary;
    }

    private JSONObject setSummaryData(BaseActivitySummary item){
        String summary = getCorrectSummary(item);
        JSONObject jsonSummary = getJSONSummary(summary);
        if (jsonSummary != null) {
            //add additionally computed values here

            if (item.getBaseAltitude() != null && item.getBaseAltitude() != -20000) {
                JSONObject baseAltitudeValues;
                try {
                    baseAltitudeValues = new JSONObject();
                    baseAltitudeValues.put("value", item.getBaseAltitude());
                    baseAltitudeValues.put("unit", "meters");
                    jsonSummary.put("baseAltitude", baseAltitudeValues);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            if (jsonSummary.has("distanceMeters") && jsonSummary.has("activeSeconds")) {
                JSONObject averageSpeed;
                try {
                    JSONObject distanceMeters = (JSONObject) jsonSummary.get("distanceMeters");
                    JSONObject activeSeconds = (JSONObject) jsonSummary.get("activeSeconds");
                    double distance = distanceMeters.getDouble("value");
                    double duration = activeSeconds.getDouble("value");
                    averageSpeed = new JSONObject();
                    averageSpeed.put("value", distance / duration);
                    averageSpeed.put("unit", "meters_second");
                    jsonSummary.put("averageSpeed", averageSpeed);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonSummary;
    }

    public JSONObject getSummaryData(){
        //returns json with summaryData
        if (summaryData==null) summaryData=setSummaryData(baseActivitySummary);
        return summaryData;
    }

    private String getCorrectSummary(BaseActivitySummary item){
        if (item.getRawSummaryData() != null) {
            ActivitySummaryParser parser = new HuamiActivitySummaryParser(); // FIXME: if something else than huami supports that make sure to have the right parser
            item = parser.parseBinaryData(item);
        }
        return item.getSummaryData();
    }

    private JSONObject getJSONSummary(String sumData){
        JSONObject summarySubdata = null;
        if (sumData != null) {
            try {
                summarySubdata = new JSONObject(sumData);
            } catch (JSONException e) {
            }
        }
        return summarySubdata;
    }

    public JSONObject getSummaryGroupedList() {
        //returns list grouped by activity groups as per createActivitySummaryGroups
        if (summaryData==null) summaryData=setSummaryData(baseActivitySummary);
        if (summaryGroupedList==null) summaryGroupedList=setSummaryGroupedList(summaryData);
        return summaryGroupedList;
    }
    private JSONObject setSummaryGroupedList(JSONObject summaryDatalist){
        this.groupData = createActivitySummaryGroups(); //structure for grouping activities into groups, when vizualizing

        if (summaryDatalist ==null ) return null;
        Iterator<String> keys = summaryDatalist.keys();
        JSONObject list=new JSONObject();

        while (keys.hasNext()) {
            String key = keys.next();
            try {
                JSONObject innerData = (JSONObject) summaryDatalist.get(key);
                Object value = innerData.get("value");
                String unit = innerData.getString("unit");
                String group = getGroup(key);

                if (!list.has(group)) {
                    list.put(group,new JSONArray());
                }

                JSONArray tmpl = (JSONArray) list.get(group);
                JSONObject innernew = new JSONObject();
                innernew.put("name", key);
                innernew.put("value", value);
                innernew.put("unit", unit);
                tmpl.put(innernew);
                list.put(group, tmpl);
            } catch (JSONException e) {
                LOG.error("SportsActivity", e);
            }
        }
        return list;
    }

    private String getGroup(String searchItem) {
        String defaultGroup = "Activity";
        if (groupData == null) return defaultGroup;
        Iterator<String> keys = groupData.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            try {
                JSONArray itemList = (JSONArray) groupData.get(key);
                for (int i = 0; i < itemList.length(); i++) {
                    if (itemList.getString(i).equals(searchItem)) {
                        return key;
                    }
                }
            } catch (JSONException e) {
                LOG.error("SportsActivity", e);
            }
        }
        return defaultGroup;
    }
    private JSONObject createActivitySummaryGroups(){
        String groupDefinitions = "{'Strokes':['averageStrokeDistance','averageStrokesPerSecond','strokes'], " +
                "'Swimming':['swolfIndex','swimStyle'], " +
                "'Elevation':['ascentMeters','descentMeters','maxAltitude','minAltitude','averageAltitude', 'baseAltitude','ascentSeconds','descentSeconds','flatSeconds','ascentDistance','descentDistance','flatDistance'], " +
                "'Speed':['averageSpeed','maxSpeed','minSpeed','averageKMPaceSeconds','minPace','maxPace','averageSpeed2','averageCadence','maxCadence','minCadence'], " +
                "'Activity':['distanceMeters','steps','activeSeconds','caloriesBurnt','totalStride'," +
                "'averageHR','maxHR','minHR','averageStride','maxStride','minStride'], " +
                "'Laps':['averageLapPace','laps']}";
        JSONObject data = null;
        try {
            data = new JSONObject(groupDefinitions);
        } catch (JSONException e) {
            LOG.error("SportsActivity", e);
        }
        return data;
    }

}
