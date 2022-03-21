package my.vanted.untitled;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Knjiga> knjige = new ArrayList<>();
    static List<Publikacija> publikacije = new ArrayList<>();
    static List<Kartografsko> kartografske = new ArrayList<>();
    static List<Zvocno> zvocne = new ArrayList<>();

    public static void beriVse(){
        String row;
        try {
            BufferedReader fr = new BufferedReader(new FileReader("data.txt"));
            while((row = fr.readLine()) != null) {
                String[] data = row.split(";");
                switch (data[0]){
                    case "knjiga" -> knjige.add(new Knjiga(data[1], data[2], data[3], data[4]));
                    case "publikacija" -> publikacije.add(new Publikacija(data[1], data[2], data[3], data[4]));
                    case "kartografsko" -> kartografske.add(new Kartografsko(data[1], data[2], data[3], data[4]));
                    case "zvocno" -> zvocne.add(new Zvocno(data[1], data[2], data[3], data[4]));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zapisiVse(){
        try {
            FileWriter fw = new FileWriter("data.txt");
            for (Knjiga knjiga : knjige) {
                fw.write("knjiga;");
                fw.write(knjiga.get()[0] + ";");
                fw.write(knjiga.get()[1] + ";");
                fw.write(knjiga.get()[2] + ";");
                fw.write(knjiga.get()[3] + ";");
                fw.write("\n");
            }
            for (Publikacija publikacija : publikacije) {
                fw.write("publikacija;");
                fw.write(publikacija.get()[0] + ";");
                fw.write(publikacija.get()[1] + ";");
                fw.write(publikacija.get()[2] + ";");
                fw.write(publikacija.get()[3] + ";");
                fw.write("\n");
            }
            for (Kartografsko kartografsko : kartografske) {
                fw.write("kartografsko;");
                fw.write(kartografsko.get()[0] + ";");
                fw.write(kartografsko.get()[1] + ";");
                fw.write(kartografsko.get()[2] + ";");
                fw.write(kartografsko.get()[3] + ";");
                fw.write("\n");
            }
            for (Zvocno zvocno : zvocne) {
                fw.write("zvocno;");
                fw.write(zvocno.get()[0] + ";");
                fw.write(zvocno.get()[1] + ";");
                fw.write(zvocno.get()[2] + ";");
                fw.write(zvocno.get()[3] + ";");
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // (knjiga (turisticni vodic, roman, slikanica,
        // itd.), periodicna publikacija (casopis, revija, strip, itd.), kartografsko gradivo (zemljevid, atlas),
        //zvocno gradivo (DVD, zgoscenka, kaseta, vinilka, itd.)
        beriVse();

        String tip, avtor, naslov, jezik, klj;
        int id;

        Scanner read = new Scanner(System.in);
        while(true){
            System.out.println("\n Kaj hočeš? \n" +
                    "\"nic\" - Zapri program.\n" +
                    "\"novo\" - Vnos nove knjige. \n" +
                    "\"beri\" - Izpis knjige iz knjižnice");
            switch (read.nextLine()) {
                case "nic" -> {
                    zapisiVse();
                    System.out.println("Adijo");
                    System.exit(0);
                }
                case "novo" -> {
                    System.out.println("Tip: ");
                    tip = read.nextLine();
                    System.out.print("\nAvtor: ");
                    avtor = read.nextLine();
                    System.out.print("Naslov: ");
                    naslov = read.nextLine();
                    System.out.print("Jezik: ");
                    jezik = read.nextLine();
                    System.out.print("Ključne besede: ");
                    klj = read.nextLine();
                    switch (tip){
                        case "knjiga": knjige.add(new Knjiga(avtor, naslov, jezik, klj));
                        case "publikacija": publikacije.add(new Publikacija(avtor, naslov, jezik, klj));
                        case "kartografsko": kartografske.add(new Kartografsko(avtor, naslov, jezik, klj));
                        case "zvocno": zvocne.add(new Zvocno(avtor, naslov, jezik, klj));
                    }

                }
                case "beri" -> {
                    System.out.println("Tip: \n" +
                            "- \"knjiga\"\n" +
                            "- \"publikacija\"\n" +
                            "- \"kartografsko\"\n" +
                            "- \"zvocno\"");
                    switch (read.nextLine()){
                        case("knjiga") -> {
                            System.out.print("id knjige: ");
                            id = read.nextInt();
                            if (id < knjige.size()) {
                                System.out.println("Avtor: " + knjige.get(id).get()[0]);
                                System.out.println("Naslov: " + knjige.get(id).get()[1]);
                                System.out.println("Jezik: " + knjige.get(id).get()[2]);
                                System.out.println("Ključne Besede: " + knjige.get(id).get()[3]);
                                read.nextLine();
                            } else {
                                System.out.println("Poskusi ponovno in vpiši pravilni ID!");
                                read.nextLine();
                            }
                        }
                        case("publikacija") -> {
                            System.out.print("id publikacije: ");
                            id = read.nextInt();
                            if (id < knjige.size()) {
                                System.out.println("Avtor: " + publikacije.get(id).get()[0]);
                                System.out.println("Naslov: " + publikacije.get(id).get()[1]);
                                System.out.println("Jezik: " + publikacije.get(id).get()[2]);
                                System.out.println("Ključne Besede: " + publikacije.get(id).get()[3]);
                                read.nextLine();
                            } else {
                                System.out.println("Poskusi ponovno in vpiši pravilni ID!");
                                read.nextLine();
                            }
                        }
                        case("kartografsko") -> {
                            System.out.print("id kartografskega gradiva: ");
                            id = read.nextInt();
                            if (id < knjige.size()) {
                                System.out.println("Avtor: " + kartografske.get(id).get()[0]);
                                System.out.println("Naslov: " + kartografske.get(id).get()[1]);
                                System.out.println("Jezik: " + kartografske.get(id).get()[2]);
                                System.out.println("Ključne Besede: " + kartografske.get(id).get()[3]);
                                read.nextLine();
                            } else {
                                System.out.println("Poskusi ponovno in vpiši pravilni ID!");
                                read.nextLine();
                            }
                        }
                        case("zvocno") -> {
                            System.out.print("id zvocnega gradiva: ");
                            id = read.nextInt();
                            if (id < knjige.size()) {
                                System.out.println("Avtor: " + zvocne.get(id).get()[0]);
                                System.out.println("Naslov: " + zvocne.get(id).get()[1]);
                                System.out.println("Jezik: " + zvocne.get(id).get()[2]);
                                System.out.println("Ključne Besede: " + zvocne.get(id).get()[3]);
                                read.nextLine();
                            } else {
                                System.out.println("Poskusi ponovno in vpiši pravilni ID!");
                                read.nextLine();
                            }
                        }
                    }
                }
                default -> {
                    System.out.println("nekaj izberi!");
                    read.nextLine();
                }
            }

            System.out.println("\nNadaljuj? y/n");
            if ("y".equals(read.nextLine())) {
                System.out.println("oki");
            } else {
                zapisiVse();
                System.out.println("Adijo");
                System.exit(0);
            }
        }
    }
}
