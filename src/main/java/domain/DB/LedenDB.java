package domain.DB;

import domain.model.Lid;

import java.util.ArrayList;
import java.util.Map;

public class LedenDB {
    private ArrayList<Lid> leden = new ArrayList<>();

    public LedenDB() {
        this.addLid(new Lid("Emile", "Hermans", "e.h@gmail.com", 19, "Blauwenhoek", 106, "Londerzeel"));
        this.addLid(new Lid ("Emile", "Hermans", "r0839357@student.ucll.be", 19, "Ergens", 26, "Anders"));
        this.addLid(new Lid ("Emile", "Hermans", "emile@gmail.com", 19, "Ergens", 26,1, "Anders"));
    }

    public ArrayList<Lid> getLeden() {
        return leden;
    }

    public Lid zoekLid(String naam, String voornaam) {
        for (Lid lid : leden) {
            if (lid.getNaam().equals(naam) && lid.getVoornaam().equals(voornaam)) {
                return lid;
            }
        }
        return null;
    }

    public void addLid(Lid lid) {
        if (lid == null)
            throw new IllegalArgumentException("Vul alle nodige velden in aub.");
        if (vind(lid.getNaam()) != null)
            throw new IllegalArgumentException("Je mag een lid maar één keer toevoegen.");
        leden.add(lid);
    }

    public void verwijder(String email) {
        System.out.println("Verwijder nu");
        leden.remove(vind(email));
        System.out.println("lid verwijderd");
    }

    public Lid vind(String email) {
        if (email == null) {
            System.out.println("E-mail is null");
            throw new IllegalArgumentException("Email mag niet leeg zijn");
        }
        for (Lid lid : leden) {
            if (lid.heeftEmail(email)) {
                System.out.println("Lid gevonden");
                return lid;
            }
        }
        System.out.println("Lid niet gevonden");
        return null;
    }
    public int getSize(){
        return leden.size();
    }


}
