public class Song {

    private static final int MAX_SONG_LENGTH = 14 * 60 + 59;

    private String artistName;
    private String name;
    private int minutes;
    private int seconds;

    public Song() {
    }

    public Song(String artistName, String name, int minutes, int seconds) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setName(name);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        if (!isLengthValid()) {
            throw new InvalidSongLengthException();
        }
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName == null || artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws InvalidSongNameException {
        if (name == null || name.length() < 3 || name.length() > 30) {
            throw new InvalidSongNameException();
        }
        this.name = name;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) throws InvalidSongLengthException {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException();
        }
        if (!isLengthValid()) {
            throw new InvalidSongLengthException();
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int seconds) throws InvalidSongLengthException {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException();
        }
        if (!isLengthValid()) {
            throw new InvalidSongLengthException();
        }
        this.seconds = seconds;
    }

    public int getTotalSongLength() {
        return this.getMinutes() * 60 + this.getSeconds();
    }

    private boolean isLengthValid() {
        return this.getTotalSongLength() <= MAX_SONG_LENGTH;
    }
}
