import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playlist {

    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void addSong(String[] songInfo) throws InvalidSongException {
        String artistName = songInfo[0];
        String songName = songInfo[1];

        String[] songLength = songInfo[2].split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(songLength[0]);
            seconds = Integer.parseInt(songLength[1]);
        } catch (NumberFormatException e) {
            throw new InvalidSongLengthException();
        }

        Song song = new Song(artistName, songName, minutes, seconds);

        this.addSong(song);
    }

    public void printPlaylistInfo() {
        int totalSongTime = this.songs.stream().mapToInt(Song::getTotalSongLength).sum();
        int hours = totalSongTime / 3600;
        int minutes = totalSongTime / 60 % 60;
        int seconds = totalSongTime % 60;

        System.out.println(String.format("Songs added: %d", this.songs.size()));
        System.out.println(String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds));
    }
}
