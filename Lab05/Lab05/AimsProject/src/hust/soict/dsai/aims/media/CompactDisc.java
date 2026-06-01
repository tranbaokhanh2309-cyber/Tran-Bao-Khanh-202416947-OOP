package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.err.println("Track not found: " + track.getTitle());
        }
    }

    public int getLength() {
        int total = 0;
        for (Track t : tracks) total += t.getLength();
        return total;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + getTitle());
            System.out.println("Artist: " + artist);
            Iterator iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "CompactDisc [title=" + getTitle() + ", category=" + getCategory()
                + ", cost=" + getCost() + ", artist=" + artist + ", tracks=" + tracks + "]";
    }
}
