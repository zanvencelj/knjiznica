package my.vanted.untitled;

public class Knjiga {
    // avtor, naslov, jezik, kljucne besede,
    private String avtor;
    private String naslov;
    private String jezik;
    private String kljucne_besede;

    public Knjiga(String av, String na, String je, String kb){
        this.avtor = av;
        this.naslov = na;
        this.jezik = je;
        this.kljucne_besede = kb;
    }

    public String getAvtor() {
        return avtor;
    }


    public String[] get(){
        return new String[]{this.avtor, this.naslov, this.jezik, this.kljucne_besede};
    }

    public void set(String av, String na, String je, String kb) {
        this.avtor = av;
        this.naslov = na;
        this.jezik = je;
        this.kljucne_besede = kb;
    }
}
