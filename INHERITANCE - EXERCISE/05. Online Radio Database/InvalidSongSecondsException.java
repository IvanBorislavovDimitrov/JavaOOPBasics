public class InvalidSongSecondsException extends InvalidSongLengthException {

    public InvalidSongSecondsException() {
        this(Config.INVALID_SONG_SECONDS_EXCEPTION_MESSAGE);
    }

    public InvalidSongSecondsException(String message) {
        super(message);
    }

}
