package hu.szamalk.modell;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Szak{
    private String nev;
    private transient UUID ID;
    private List<String> tantargyak;


    public Szak(String sor){
        String[] adatok = sor.split(";");
        String nev = adatok[0];
        this.nev = nev;
        String tantargyakSor = adatok[1];
        String[] tantargyak = tantargyakSor.split(";");
        this.tantargyak = new ArrayList<>();
        for (String tantargy : tantargyak){
            this.tantargyak.add(tantargy);
        }
        idGeneral();
    }

    public Szak(String nev, String tantargy){
        this(nev, new ArrayList<>());
        tantargyak.add(tantargy);
    }

    public Szak(String nev, List<String> tantargyak) {
        this.nev = nev;
        this.tantargyak = tantargyak;
        idGeneral();
    }

    private void idGeneral() {
        ID = UUID.randomUUID();
    }

    void szakKiirasa(){
        String fileNev = "targyak.dat";
        tantargyak = new ArrayList<>();
        Tantargy tantargy1 = new Tantargy("info", "Halász Gergő", "nem", 5, 1);
        try(ObjectOutputStream szakKi = new ObjectOutputStream(new FileOutputStream(fileNev))){
            szakKi.writeObject(tantargy1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void szakBeolvasasa(){
        String fileNev = "targyak.dat";
        try(ObjectInputStream szakBe = new ObjectInputStream(new FileInputStream(fileNev))){
            Szak szak = (Szak) szakBe.readObject();
            szak.idGeneral();
            System.out.println("beolvasott szak:");
            System.out.println(szak);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private List<Tantargy> getTargyakNevSzerint(){
        List<Tantargy> nevek = new ArrayList<>();
        Tantargy t1 = new Tantargy("nev1", "tan1", "nem", 5, 1);
        Tantargy t2 = new Tantargy("anev2", "tan2", "nem", 5, 1);
        nevek.add(t1);
        nevek.add(t2);
        nevek.sort(Tantargy.rendezNev());
        return nevek;
    }

    private List<Tantargy> getTargyakKreditSzerint(){
        List<Tantargy> kreditek = new ArrayList<>();
        Tantargy t1 = new Tantargy("nev1", "tan1", "nem", 5, 1);
        Tantargy t2 = new Tantargy("anev2", "tan2", "nem", 10, 1);
        kreditek.add(t1);
        kreditek.add(t2);
        kreditek.sort(Tantargy.rendezKredit());
        return kreditek;
    }

    void statisztika(){
        String fileNev = "statisztika.txt";
        String tartalom = "különböző tárgy: " + kulonbozoTargyak();
        tartalom += "\n Vizsga tárgyak: \n";
        try {
            Files.write(Path.of(fileNev), tartalom.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Set<String> kulonbozoTargyak(){
        Set<String> kulonTargyak = new HashSet<>();
        tantargyak.forEach(sor ->{
            String[] tomb = sor.split(";");

        });
//        for(Tantargy targy : tantargyak){
//
//        }

        return kulonTargyak;
    }
}
