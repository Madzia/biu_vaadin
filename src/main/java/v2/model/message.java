package v2.model;

import java.util.Date;

public class message {

    private String author;
    private String text;
    private Date timeStamp;

    public message(String author, String text, Date timeStamp) {
        this.author = author;
        this.text = text;
        this.timeStamp = timeStamp;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
