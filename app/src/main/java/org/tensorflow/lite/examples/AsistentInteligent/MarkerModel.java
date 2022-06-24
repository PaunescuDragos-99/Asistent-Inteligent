package org.tensorflow.lite.examples.AsistentInteligent;

import java.io.Serializable;

public class MarkerModel implements Serializable {
    private String MarkerName;
    private String MarkerInfo;

    private String MarkerKey;

    public MarkerModel() {
    }

    public String getMarkerName() {
        return MarkerName;
    }

    public void setMarkerName(String markerName) {
        MarkerName = markerName;
    }

    public String getMarkerInfo() {
        return MarkerInfo;
    }

    public void setMarkerInfo(String markerInfo) {
        MarkerInfo = markerInfo;
    }

    public String getMarkerKey() {
        return MarkerKey;
    }

    public void setMarkerKey(String markerKey) {
        MarkerKey = markerKey;
    }
}