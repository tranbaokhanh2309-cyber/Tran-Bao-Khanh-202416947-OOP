package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, float cost){
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost){
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}
