package hust.soict.dsai.aims.media;

public abstract class Media {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, float cost) {
        this(title, "Unknown", cost);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.title);
    }

    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
    }
}
