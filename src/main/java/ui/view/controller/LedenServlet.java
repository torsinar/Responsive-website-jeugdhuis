package ui.view.controller;

import domain.DB.LedenDB;
import domain.model.Lid;
import domain.model.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/LedenServlet")
public class LedenServlet extends HttpServlet {
    private LedenDB databank = new LedenDB(); //Verwijzen naar StudentDB databank

    public LedenServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie theme = getCookieWithKey(request, "theme");

        request.setAttribute("requestCookie", theme==null?"Light":theme.getValue());
        String command = request.getParameter("command");
        if (command == null )
            command = "";
        String destination;
        switch (command) {
            case "home":
                destination = goHome();
                break;
            case "leden":
                destination = leden(request, response);
                break;
            case "add":
                destination = getWordLid(request, response);
                break;
            case "deleteConfirmation":
                destination = getDeleteConfirmation();
                break;
            case "zoek":
                destination = "Zoek.jsp";
                break;
            case "gevonden":
                destination = getLid(request);
                break;
            case "delete":
                destination = delete(request, response);
                break;
            case "doUpdate":
                destination = doUpdate(request, response);
                break;
            case "update":
                destination = goUpdate(request, response);
                break;
                // verwijzen naar de methode changeTheme waar we de cookie zullen aanmaken en laten werken.
            case "changeTheme":
                destination = changeTheme(request, response, theme);
                break;
            case "wordLid":
                destination = "wordLid.jsp";
                break;
            case "logboek":
                destination = "log.jsp";
                break;
            default:
                destination = goHome();
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }


    private String doUpdate(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        if (email == null ||email.trim().isEmpty()) {
            return leden(request, response);
        }
        Lid lid = databank.vind(email);
        if(lid == null) {
            return leden(request, response);
        }
        //fake lid aanmaken
        Lid tempLid = new Lid();

        ArrayList<String> errors = new ArrayList<String>();

        setVnaam(tempLid, request, errors);
        setAnaam(tempLid, request, errors);
        setLeeftijd(tempLid, request, errors);
        setStraat(tempLid, request, errors);
        setHuisnummer(tempLid, request, errors);
        setBus(tempLid, request, errors);
        setStad(tempLid, request, errors);

        if (errors.size() == 0) {
            //parrameters veranderen naar echte lid

            lid.setVoornaam(tempLid.getVoornaam());
            lid.setNaam(tempLid.getNaam());
            lid.setLeeftijd(tempLid.getLeeftijd());
            lid.setHuisnummer(tempLid.getHuisnummer());
            lid.setStraat(tempLid.getStraat());
            lid.setStad(tempLid.getStad());
            lid.setBusnummer(tempLid.getBusnummer());

            return leden(request, response);
        }else {
            request.setAttribute("errors", errors);
            request.setAttribute("email", email);
            return "update.jsp";
        }
    }

    private String goUpdate(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        if (email == null ||email.trim().isEmpty()) {
            return leden(request, response);
        }
        Lid lid = databank.vind(email);
        if(lid == null) {
            return leden(request, response);
        }
        String voornaam = request.getParameter("vnaam");
        String naam = request.getParameter("anaam");
        String leeftijd = request.getParameter("leeftijd");
        String straat = request.getParameter("straat");
        String huisnummer = request.getParameter("huisnummer");
        String busnummer = request.getParameter("bus");
        String stad = request.getParameter("stad");

        request.setAttribute("vnaam", voornaam);
        request.setAttribute("anaam", naam);
        request.setAttribute("email", email);
        request.setAttribute("leeftijd", leeftijd);
        request.setAttribute("straat", straat);
        request.setAttribute("huisnummer", huisnummer);
        request.setAttribute("bus", busnummer);
        request.setAttribute("stad", stad);

        return "update.jsp";
    }

    private String goHome() {
        return "index.jsp";
    }

    private String getLid(HttpServletRequest request) {
        System.out.println("Lid zoeken");
        String destination;
        String email = request.getParameter("email");
        if (email == null || email.trim().isEmpty()) {
            destination = "LidNietGevonden.jsp";
        } else {
            Lid lid = databank.vind(email.trim());
            if(lid == null) {
                destination = "LidNietGevonden.jsp";
            } else {

                //Oproepen naar de methode voor mijn sessie opdracht
                logboekLijst(request, lid.getEmail());

                request.setAttribute("vnaam", lid.getVoornaam());
                request.setAttribute("anaam", lid.getNaam());

                destination = "GevondenLid.jsp";
                String string = "Voornaam: " + lid.getVoornaam() + ", Naam: " + lid.getNaam() + ", E-mail: " + lid.getEmail() + ", Leeftijd: " + lid.getLeeftijd() + ", Straat: " + lid.getStraat() + ", Huisnummer: " + lid.getHuisnummer() + ", Busnummer: " + lid.getBusnummer() + ", Stad: " + lid.getStad();

                request.setAttribute("string", string);
            }
        }
        return destination;
    }



    private String delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Verwijder lid");
        String email = request.getParameter("email");

        databank.verwijder(email);
        return leden(request, response);
    }

    private String getDeleteConfirmation() {
        return "deleteConfirmation.jsp";
    }




    private String leden(HttpServletRequest request, HttpServletResponse response) {

        if (databank.getSize() != 0) {
            request.setAttribute("alleLeden", databank.getLeden());
            request.setAttribute("gemLeeftijd", getGemLeeftijd(request));
        }

        return "leden.jsp";
    }

    private double getGemLeeftijd(HttpServletRequest request) {
        request.setAttribute("alleLeden", databank.getLeden());
        ArrayList<Lid> leden = (ArrayList<Lid>) request.getAttribute("alleLeden");
        int tot = 0;
        for (Lid lid : leden) {
            tot += lid.getLeeftijd();
        }
        return tot / leden.size();
    }

    private String getWordLid(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        Lid lid = new Lid();
        setVnaam(lid, request, errors);
        setAnaam(lid, request, errors);
        setEmail(lid, request, errors);
        setLeeftijd(lid, request, errors);
        setStraat(lid, request, errors);
        setHuisnummer(lid, request, errors);
        setBus(lid, request, errors);
        setStad(lid, request, errors);
        for(Lid l: databank.getLeden()){

            if (l.getEmail().equals(lid.getEmail())){

                errors.add("Dit lid bestaat al");

            }

        }
        if (errors.size() == 0) {
            try {
                databank.addLid(lid);
                return leden(request, response);
            }
            catch (IllegalArgumentException exc) {
                request.setAttribute("error", exc.getMessage());
                return "wordLid.jsp";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "wordLid.jsp";
        }
    }

    private void setVnaam(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        String vnaam = request.getParameter("vnaam");
        try {
            lid.setVoornaam(vnaam);
            request.setAttribute("vnaamPreviousValue", vnaam);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setAnaam(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        String anaam = request.getParameter("anaam");
        try {
            lid.setNaam(anaam);
            request.setAttribute("anaamPreviousValue", anaam);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setEmail(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            lid.setEmail(email);
            request.setAttribute("emailPreviousValue", email);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setLeeftijd(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        int leeftijd;
        try {
            leeftijd = Integer.parseInt(request.getParameter("leeftijd"));
            lid.setLeeftijd(leeftijd);
            request.setAttribute("leeftijdPreviousValue", leeftijd);

        }
        catch (NumberFormatException exc) {
            errors.add("Vul een leeftijd in");
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setStraat(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        String straat = request.getParameter("straat");
        try {
            lid.setStraat(straat);
            request.setAttribute("straatPreviousValue", straat);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setHuisnummer(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        int huisnummer;
        try {
            huisnummer = Integer.parseInt(request.getParameter("huisnummer"));
            lid.setHuisnummer(huisnummer);
            request.setAttribute("huisnummerPreviousValue", huisnummer);
        }
        catch (NumberFormatException exc) {
            errors.add("Vul een huisnummer in");
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());

        }
    }

    private void setBus(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        int busnummer;
        if(!request.getParameter("bus").isBlank()){
            busnummer = Integer.parseInt(request.getParameter("bus"));
            try {
                lid.setBusnummer(busnummer);
                request.setAttribute("busnummerPreviousValue", busnummer);
            }
            catch (IllegalArgumentException exc) {
                errors.add(exc.getMessage());
            }
        }
    }

    private void setStad(Lid lid, HttpServletRequest request, ArrayList<String> errors) {
        String stad = request.getParameter("stad");
        try {
            lid.setStad(stad);
            request.setAttribute("stadPreviousValue", stad);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }
    //Cookie opdracht:
    private String changeTheme(HttpServletRequest request, HttpServletResponse response, Cookie theme) {
        //default theme is light mode
        String currentTheme = "Light";

        if (theme!=null) {
            currentTheme = theme.getValue();
        }

        //Light heeft index 0 in de array en Dark heeft index 1;
        //Als index al 1 is en het thema wordt veranderd, dan zal de index weet naar 0 gezet worden
        String[] themes = {"Light", "Dark"};
        int index = Arrays.asList(themes).indexOf(currentTheme);
        if(index==1) {
            index = 0;
        }else {
            index += 1;
        }
        String newTheme = themes[index];
        Cookie c = new Cookie("theme", newTheme);
        response.addCookie(c);

        //Dark of Light zal ook meeggegeven worden naar de jsp pagina's, zo kan je steeds in de footer zien in welke mode je huidig bent
        if (newTheme.equals("Light")) {
            request.setAttribute("requestCookie", "Light");
        } else {
            request.setAttribute("requestCookie", "Dark");
        }
        return goHome();
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }


    //Sessie opdracht:
    private void logboekLijst(HttpServletRequest request, String zoek) {
        //session aanmaken
        HttpSession session = request.getSession();
        LocalTime time = LocalTime.now();
        if (session.getAttribute("logboek") == null){
            //Er is een klasse Log aangemaakt waarin tijd en opgezochte email wordt terug gegeven.
            Log l = new Log(time, zoek);
            ArrayList<Log>logboek = new ArrayList<>();
            //sessie toevoegen aan logboek
            logboek.add(l);
            session.setAttribute("logboek", logboek);
        }
        else{
            //Anders vorige logs opvragen en nieuwe log toevoegen
            ArrayList<Log> logboek = (ArrayList<Log>)session.getAttribute("logboek");
            Log l = new Log(time,zoek);
            logboek.add(l);
            session.setAttribute("logboek", logboek);
        }



    }






    


}

