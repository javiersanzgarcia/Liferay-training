package com.jsanz.rest.library.model;

import com.jsanz.library.model.Library;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class LibraryDTO {

    private long ISBN;
    private String title;
    private String writer;
    private Date publication;

    // Important !!!! Must exist an empty constructor cos CXF Apache can instantiate the object properly
    public LibraryDTO() {
    }

    public LibraryDTO(Library library) {
        ISBN = library.getISBN();
        title = library.getTitle();
        writer = library.getWriter();
        if (library.getPublication() == null) {
            publication = library.getPublication();
        } else {
            publication = new Date();
        }
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "LibraryDTO{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", publication=" + publication +
                '}';
    }
}
