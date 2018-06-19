public class InvalidSongLengthException extends InvalidSongException {

    public InvalidSongLengthException() {
        this(Config.INVALID_SONG_LENGTH_EXCEPTION_MESSAGE);
    }

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
