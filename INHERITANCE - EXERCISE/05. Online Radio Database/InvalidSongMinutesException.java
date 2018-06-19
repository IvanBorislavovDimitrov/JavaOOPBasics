public class InvalidSongMinutesException extends InvalidSongLengthException {

    public InvalidSongMinutesException() {
        this(Config.INVALID_SONG_MINUTES_EXCEPTION_MESSAGE);
    }

    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
