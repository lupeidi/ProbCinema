package Domain;

public class Movie {
    private String id;
    private String title;
    private int releaseYear;
    private double price;
    private boolean airing;
    private int bonusPoints;

    public Movie(String id, String title, int releaseYear, double price, boolean airing) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
        this.airing = airing;
        this.bonusPoints = (int) (this.price / 10);

    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                ", airing=" + airing +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAiring() {
        return airing;
    }

    public void setAiring(boolean airing) {
        this.airing = airing;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }
}
