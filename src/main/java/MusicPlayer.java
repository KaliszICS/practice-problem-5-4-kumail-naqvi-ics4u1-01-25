public class MusicPlayer implements Player {
    private boolean onOff;
    private String[] musicList;
    private String currentSong;
    private int volume;

    private int currentIndex;

    public MusicPlayer(String[] musicList) {
        this.musicList = (musicList == null) ? new String[0] : musicList;
        this.volume = 0;
        this.onOff = false;
        this.currentSong = "";
        this.currentIndex = 0;
    }

    @Override
    public void start() {
        if (!onOff) {
            onOff = true;
            if (musicList.length > 0) {
                currentIndex = 0;
                currentSong = musicList[0];
            } else {
                currentSong = "";
            }
        }
    }

    @Override
    public void stop() {
        if (onOff) {
            onOff = false;
            currentSong = "";
        }
    }
    public boolean getOnOff() {
        return onOff;
    }
    @Override
    public void volumeUp() {
        volume += 1;
    }
    @Override
    public void volumeDown() {
        volume -= 1;
    }
    @Override
    public int getVolume() {
        return volume;
    }

    public void next() {
        if (!onOff || musicList.length == 0) return;
        currentIndex = (currentIndex + 1) % musicList.length;
        currentSong = musicList[currentIndex];
    }

    public void previous() {
        if (!onOff || musicList.length == 0) return;
        currentIndex = (currentIndex - 1 + musicList.length) % musicList.length; 
        currentSong = musicList[currentIndex];
    }
    public String getCurrentSong() {
        return currentSong;
    }
}