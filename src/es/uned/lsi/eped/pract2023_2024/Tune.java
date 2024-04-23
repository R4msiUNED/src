package es.uned.lsi.eped.pract2023_2024;

public class Tune implements TuneIF{

    private String title;
    private String author;
    private String genre;
    private String album;
    private int year;
    private int duration;

    public Tune(String title, String author, String genre, String album, int year, int duration) {
        this.title = title.toLowerCase();
        this.author = author.toLowerCase();
        this.genre = genre.toLowerCase();
        this.album = album.toLowerCase();
        this.year = year;
        this.duration = duration;
    }

    @Override
    public boolean match(QueryIF q) {
        boolean matchTitle,matchAuthor,matchGenre,matchAlbum,matchMinYear,matchMaxYear,matchMaxDur,matchMinDur;

        matchTitle=q.getTitle().equals("") || q.getTitle().equals(this.title);
        matchAuthor=q.getAuthor().equals("")||q.getAuthor().equals(this.author);
        matchGenre=q.getGenre().equals("")||q.getGenre().equals(this.genre);
        matchAlbum=q.getAlbum().equals("")||q.getAlbum().equals(this.album);
        matchMinDur=q.getMin_duration()==-1||this.duration>=q.getMin_duration();
        matchMaxDur=q.getMax_duration()==-1||this.duration<=q.getMax_duration();
        matchMinYear=q.getMin_year()==-1||this.year>=q.getMin_year();
        matchMaxYear=q.getMax_year()==-1||this.year<=q.getMax_year();

        return matchTitle && matchAlbum && matchAuthor && matchGenre && matchMinDur && matchMaxDur && matchMinYear && matchMaxYear;
    }

}
