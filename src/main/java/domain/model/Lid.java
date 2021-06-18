package domain.model;

public class Lid {
    String naam;
    String voornaam;
    String email;
    int leeftijd;
    String straat;
    int huisnummer;
    int busnummer;
    String Stad;

    public Lid(String voornaam, String naam, String email, int leeftijd, String straat, int huisnummer, int busnummer, String stad) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.email = email;
        this.leeftijd = leeftijd;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.busnummer = busnummer;
        this.Stad = stad;

    }
    public Lid(String voornaam, String naam, String email, int leeftijd, String straat, int huisnummer, String stad) {
        this.voornaam = voornaam;
        this.naam = naam;
        this.email = email;
        this.leeftijd = leeftijd;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.Stad = stad;


    }
    public Lid() {

    }
    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }


    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getEmail() {
        return email;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getStraat() {
        return straat;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public int getBusnummer() {
        return busnummer;
    }

    public String getStad() {
        return Stad;
    }

    public boolean heeftEmail(String email) {
        return this.email.equals(email);
    }

    public void setNaam(String naam) {
        if (naam == null ||naam.isBlank()) {
            throw new IllegalArgumentException("Geen geldige naam");
        }
        this.naam = naam;
    }

    public void setVoornaam(String voornaam) {
        if (voornaam == null ||voornaam.isBlank())
        {
            throw new IllegalArgumentException("Geen geldige voornaam");
        }
        this.voornaam = voornaam;
    }

    public void setEmail(String email) {
        if (email == null ||email.isBlank() || !isValidEmailAddress(email))
        {
            throw new IllegalArgumentException("Geen geldige email");
        }
        this.email = email;
    }

    public void setLeeftijd(int leeftijd) {
        if (leeftijd < 0 || leeftijd > 150)
        {
            throw new IllegalArgumentException("Geen geldige leeftijd");
        }
        this.leeftijd = leeftijd;
    }

    public void setStraat(String straat) {
        if (straat == null ||straat.isBlank())
        {
            throw new IllegalArgumentException("Geen geldige straat");
        }
        this.straat = straat;
    }

    public void setHuisnummer(int huisnummer) {
        if (huisnummer < 0 || huisnummer > 5000){
            throw new IllegalArgumentException("Geen geldige huisnummer");
        }
        this.huisnummer = huisnummer;
    }

    public void setBusnummer(int busnummer) {
        if (busnummer < 0 || busnummer > 100)
        {
            throw new IllegalArgumentException("Geen geldige busnummer");
        }
        this.busnummer = busnummer;
    }

    public void setStad(String stad) {
        if ((stad == null ||stad.isBlank()))
        {
            throw new IllegalArgumentException("Geen geldige stad");
        }
        Stad = stad;
    }
}
