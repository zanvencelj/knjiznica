package my.vanted.untitled;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // (knjiga (turisticni vodic, roman, slikanica,
        // itd.), periodicna publikacija (casopis, revija, strip, itd.), kartografsko gradivo (zemljevid, atlas),
        //zvocno gradivo (DVD, zgoscenka, kaseta, vinilka, itd.)

        try {
            FileWriter fw = new FileWriter("data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String[]> knjige = new ArrayList<String[]>();
        String[] publikacije = {};
        String[] kartografsko = {};
        String[] zvocno = {};

        Knjiga knjiga = new Knjiga();
        knjiga.set("Tin", "Vni je toplo", "metliščina", "Tintin, You, Lokvica");
        String[] knjigaInfo = knjiga.get();

        knjige.add(knjiga.get());

        System.out.println("Avtor: " + knjige.get(0)[0]);
        System.out.println("Naslov: " + knjige.get(0)[1]);
        System.out.println("Jezik: " + knjige.get(0)[2]);
        System.out.println("Ključne Besede: " + knjige.get(0)[3]);

        String avtor, naslov, jezik, klj;
        int id;

        Scanner read = new Scanner(System.in);
        while(true){
            System.out.flush();
            System.out.println("Kaj hočeš?\n" +
                    "\"nic\" - Zapri program.\n" +
                    "\"novo\" - Vnos nove knjige.");
            String action = read.nextLine();
            switch (action){
                case "nic": System.out.println("Adijo"); System.exit(0); break;
                case "novo":
                    System.out.print("Avtor: ");
                    avtor = read.nextLine();
                    System.out.print("Naslov: ");
                    naslov = read.nextLine();
                    System.out.print("Jezik: ");
                    jezik = read.nextLine();
                    System.out.print("Ključne besede: ");
                    klj = read.nextLine();
                    knjiga.set(avtor, naslov, jezik, klj);
                    knjige.add(knjiga.get());
                    break;
                case "beri":
                    System.out.print("id knjige: ");
                    id = read.nextInt();
                    if(id < knjige.size()){
                        System.out.println("Avtor: " + knjige.get(id)[0]);
                        System.out.println("Naslov: " + knjige.get(id)[1]);
                        System.out.println("Jezik: " + knjige.get(id)[2]);
                        System.out.println("Ključne Besede: " + knjige.get(id)[3]);
                    } else System.out.println("Poskusi ponovno in vpiši pravilni ID!");
                    break;
                default: System.out.println("nekaj napis!");
            }
        }
    }
}
