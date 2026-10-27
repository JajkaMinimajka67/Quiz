package com.example.quiz;

public class Pytanie {
    private long idZdjecia;
    private String trescPytania;
    private boolean poprawnaOdpowiedz;
    private boolean czyPoprawnie;

    public Pytanie(long idZdjecia, String trescPytania, boolean poprawnaOdpowiedz) {
        this.idZdjecia = idZdjecia;
        this.trescPytania = trescPytania;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }

    public long getIdZdjecia() {
        return idZdjecia;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public boolean isPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }

    public boolean isCzyPoprawnie() {
        return czyPoprawnie;
    }

    public void setCzyPoprawnie(boolean czyPoprawnie) {
        this.czyPoprawnie = czyPoprawnie;
    }
}
