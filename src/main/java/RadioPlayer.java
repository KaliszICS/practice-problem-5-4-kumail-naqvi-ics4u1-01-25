public class RadioPlayer implements Player {
    private boolean onOff;
    private double[] stationList;
    private int volume;
    private double station;

    private int stationIndex;

    public RadioPlayer(double[] stationList) {
        this.stationList = (stationList == null) ? new double[0] : stationList;
        this.volume = 0;
        this.onOff = false;
        this.station = 0;
        this.stationIndex = 0;
    }

    @Override
    public void start() {
        if (!onOff) {
            onOff = true;
            if (stationList.length > 0) {
                stationIndex = 0;
                station = stationList[0];
            } else {
                station = 0;
            }
        }
    }

    @Override
    public void stop() {
        if (onOff) {
            onOff = false;
            station = 0;
        }
    }
    public boolean getOnOff() {
        return onOff;
    }
    @Override
    public void volumeUp() {
        volume += 2;
    }
    @Override
    public void volumeDown() {
        volume -= 2;
    }
    @Override
    public int getVolume() {
        return volume;
    }

    public void next() {
        if (!onOff || stationList.length == 0) return;
        stationIndex = (stationIndex + 1) % stationList.length;
        station = stationList[stationIndex];
    }
    public void previous() {
        if (!onOff || stationList.length == 0) return;
        stationIndex = (stationIndex - 1 + stationList.length) % stationList.length;
        station = stationList[stationIndex];
    }
    public double getStation() {
        return station;
    }
}