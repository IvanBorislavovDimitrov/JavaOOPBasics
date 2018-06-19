public class InvalidArtistNameException extends InvalidSongException {

    public InvalidArtistNameException() {
        this(Config.INVALID_ARTIST_NAME_EXCEPTION_MESSAGE);
    }

    public InvalidArtistNameException(String message) {
        super(message);
    }
}
