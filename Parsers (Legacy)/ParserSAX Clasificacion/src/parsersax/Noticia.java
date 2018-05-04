/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsersax;

/**
 *
 * @author danie
 */
public class Noticia {
    private String title;
    private String link;
    private String pubDate;
    private String guid;
    private String creator;
    private String date;
    private String source;

    public Noticia() {
    }
   
    public Noticia(String title, String link, String pubDate, String guid, String creator, String date, String source) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.guid = guid;
        this.creator = creator;
        this.date = date;
        this.source = source;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    } 
    
        public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Detalles de la noticia - ");
        sb.append("Título:" + getTitle());
        sb.append(", ");
        sb.append("Link:" + getLink());
        sb.append(", ");
        sb.append("Fecha publicación:" + getPubDate());
        sb.append(", ");
        sb.append("GUID:" + getGuid());
        sb.append(", ");
        sb.append("Creador:" + getCreator());
        sb.append(", ");
        sb.append("Fecha:" + getDate());
        sb.append(", ");
        sb.append("Fuente:" + getSource());
        sb.append(".");

        return sb.toString();
    }
    
}