package fa.training.entities;

import java.util.Date;

public class Magazine extends Publication{

    private String author;
    private Integer volumn, edition;

    public Magazine() {
    }

    public Magazine(Integer publicationYear, String publisher, Date publicationDate, String author, Integer volumn, Integer edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volumn = volumn;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getVolumn() {
        return volumn;
    }

    public void setVolumn(Integer volumn) {
        this.volumn = volumn;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "author='" + author + '\'' +
                ", volumn=" + volumn +
                ", edition=" + edition +
                ", publicationYear=" + getPublicationYear() +
                ", publisher='" + getPublisher() + '\'' +
                ", publicationDate=" + getPublicationDate() +
                '}';
    }

    @Override
    void display() {
        System.out.println(this.toString());
    }
}
