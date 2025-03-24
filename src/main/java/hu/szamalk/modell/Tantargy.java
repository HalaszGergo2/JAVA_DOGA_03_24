package hu.szamalk.modell;

import java.text.Collator;
import java.util.Comparator;

public class Tantargy implements Comparable<Tantargy>{
    private String nev, tanar, csak_vizsga;
    private int kredit, felev;

    public Tantargy(String nev, String tanar, String csak_vizsga, int kredit, int felev) {
        this.nev = nev;
        this.tanar = tanar;
        this.csak_vizsga = csak_vizsga;
        this.kredit = kredit;
        this.felev = felev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTanar() {
        return tanar;
    }

    public void setTanar(String tanar) {
        this.tanar = tanar;
    }

    public String getCsak_vizsga() {
        return csak_vizsga;
    }

    public void setCsak_vizsga(String csak_vizsga) {
        this.csak_vizsga = csak_vizsga;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    public int getFelev() {
        return felev;
    }

    public void setFelev(int felev) {
        this.felev = felev;
    }

    @Override
    public String toString() {
        return "Tantargy{" +
                "nev='" + nev + '\'' +
                ", tanar='" + tanar + '\'' +
                ", csak_vizsga='" + csak_vizsga + '\'' +
                ", kredit=" + kredit +
                ", felev=" + felev +
                '}';
    }

    @Override
    public int compareTo(Tantargy masik) {
        Collator coll = Collator.getInstance();
        return coll.compare(this.nev, masik.nev);
    }

    public static NevComparator rendezNev(){
        return new NevComparator();
    }

    public static KreditComparator rendezKredit(){
        return new KreditComparator();
    }

    private static class NevComparator implements Comparator<Tantargy>{
        @Override
        public int compare(Tantargy o1, Tantargy o2) {
            Collator coll = Collator.getInstance();
            return coll.compare(o1.nev, o2.nev);
        }
    }


    private static class KreditComparator implements Comparator<Tantargy>{

        @Override
        public int compare(Tantargy o1, Tantargy o2) {
            return o1.kredit - o2.kredit;
        }
    }
}
