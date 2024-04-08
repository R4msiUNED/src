package es.uned.lsi.eped.pract2023_2024;

public class Query implements QueryIF {

    private String title;
    private String author;
    private String genre;
    private String album;
    private int minYear;
    private int maxYear;
    private int minDur;
    private int maxDur;

    public Query(String title, String author, String genre, String album, int minYear, int maxYear, int minDur,
            int maxDur) {
        this.title = title.toLowerCase();
        this.author = author.toLowerCase();
        this.genre = genre.toLowerCase();
        this.album = album.toLowerCase();
        this.minYear = minYear;
        this.maxYear = maxYear;
        this.minDur = minDur;
        this.maxDur = maxDur;
    }

    // por defecto
    public Query() {
        this.title = "";
        this.author = "";
        this.genre = "";
        this.album = "";
        this.minYear = -1;
        this.maxYear = -1;
        this.minDur = -1;
        this.maxDur = -1;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbum() {
        return album;
    }

    public int getMin_year() {
        return minYear;
    }

    public int getMax_year() {
        return maxYear;
    }

    public int getMin_duration() {
        return minDur;
    }

    public int getMax_duration() {
        return maxDur;
    }


}
