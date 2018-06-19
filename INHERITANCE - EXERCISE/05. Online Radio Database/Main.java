import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Playlist playlist = new Playlist();
        int songsCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < songsCount; i++) {
            String[] songInfo = input.readLine().split(";");
            try {
                playlist.addSong(songInfo);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        playlist.printPlaylistInfo();
    }




}
