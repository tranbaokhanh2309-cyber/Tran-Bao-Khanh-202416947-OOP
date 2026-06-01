package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Media implements Playable {
    private int length;
    private String director;

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        this.length = 0;
        this.director = "Unknown";
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public int getLength() { return length; }
    public String getDirector() { return director; }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + length);
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc [title=" + getTitle() + ", category=" + getCategory()
                + ", cost=" + getCost() + ", director=" + director + ", length=" + length + "]";
    }
}
