package models;

public class Navegation {
    private String url;

    public Navegation(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Navegation{" +
                "url='" + url + '\'' +
                '}';
    }
}
