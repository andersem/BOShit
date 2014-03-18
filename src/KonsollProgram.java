import java.util.*;


public class KonsollProgram extends Oblig4kl20 {

    int valg;
    LegeBeholder legeBeholder = new LegeBeholder();
    PersonBeholder personBeholder = new PersonBeholder(10);
    LegemiddelBeholder<Legemiddel> legemiddelBeholder = new LegemiddelBeholder(10);
    EnkelReseptListe reseptBeholder = new EnkelReseptListe();
    Scanner input = new Scanner(System.in);

    public void meny() {
        startPrint();
        valg = input.nextInt();
        if (valg == 1) {
            opprettLegemiddel();
        }
        if (valg == 2) {
            opprettLege();
        }
        if (valg == 3) {
            opprettPerson();
        }
        if (valg == 4) {
            opprettResept();
        }
        if (valg == 5) {
            hentResept();
        }
        if (valg == 6) {
            System.out.println("Ikke implementert enda.");
//            skrivUtInfo();
        }
        if (valg == 7) {
            System.out.println("Ikke implementert enda.");
        }
        if (valg == 8) {
            System.out.println("Ikke implementert enda.");
        }
        if (valg == 9) {
            System.out.println("Ikke implementert enda.");
        } else {
            System.out.println("Ugyldig valg, prøv igjen.");
            meny();
        }

    }

    public void opprettAlt() {
        Person donald = new Personprodusent("Donald", true).nyPerson();
        Person onkelskrue = new Personprodusent("Onkel Skrue", true).nyPerson();
        Lege mikke = new Lege("Mikke", true, true, 10);
        Lege dolly = new Lege("Dolly", true, true, 10);
        Legemiddel mcDuck = Legemiddelprodusent.nyttLegemiddel("McDuck", 10000.00, "Salve", 1, "A", 1);

        Resept r1 = Reseptprodusent.nyResept(true, 3, mikke, donald, mcDuck);
        Resept r2 = Reseptprodusent.nyResept(true, 3, dolly, onkelskrue, mcDuck);

        legeBeholder.settInnElement(mikke);
        legeBeholder.settInnElement(dolly);
        personBeholder.settInnObjekt(donald, 0);
        personBeholder.settInnObjekt(onkelskrue, 0);
        legemiddelBeholder.settInnObjekt(mcDuck, 0);
        reseptBeholder.settInnSist(r1);
        reseptBeholder.settInnSist(r2);

    }

    public void startPrint() {
        System.out.println("\nVelkommen til ditt reseptprogram: \n");
        System.out.println("Velg ordre 1 - 9");
        System.out.println("1. Opprett legemiddel");
        System.out.println("2. Opprett lege");
        System.out.println("3. Opprett person");
        System.out.println("4. Opprett resept");
        System.out.println("5. Hent resept");
        System.out.println("6. Skriv ut info om legemidler, leger og personer");
        System.out.println("7. Skriv ut info om en gitt person(Ved personnummer)");
        System.out.println("8. Skriv ut info om leger, deres avtaler og resepter");
        System.out.println("9. Skriv ut info om personer, inkl. resepter");
        System.out.print("Ditt om valg: ");
    }

    public void opprettLegemiddel() {
        String navn;
        double pris;
        String fysiskFormat;
        int mengde;
        String type;
        int egenskap;

        System.out.println("Du har valgt å opprette et legemiddel.");
        System.out.print("Legemiddelets navn: ");
        navn = input.next();
        input.nextLine();
        System.out.print("Legemiddelets pris: ");
        while (!input.hasNextDouble()) {
            System.out.print("Ikke riktig input, skriv et tall: ");
            input.next();
        }
        pris = input.nextDouble();
        input.nextLine();
        System.out.print("Legemiddelets format: ");
        fysiskFormat = input.nextLine();
        System.out.print("Mengde legemiddel: ");
        while (!input.hasNextInt()) {
            System.out.print("Ikke riktig input, skriv et tall: ");
            input.next();
        }
        mengde = input.nextInt();
        System.out.print("Legemiddeltype: ");
        type = input.next();
        input.nextLine();
        if (type.equals("A") || type.equals("B")) {
            System.out.println("Legemiddelets styrke: ");
            while (!input.hasNextInt()) {
                System.out.print("Ikke riktig input, skriv et tall: ");
                input.next();
            }
            egenskap = input.nextInt();
            input.nextLine();
            Legemiddel legemiddel = Legemiddelprodusent.nyttLegemiddel(navn, pris, fysiskFormat, mengde, type, egenskap);
        } else {
            Legemiddel legemiddel = Legemiddelprodusent.nyttLegemiddel(navn, pris, fysiskFormat, mengde, type);
        }
        System.out.println("Du har nå opprettet " + navn + " som legemiddel i systemet \n");

        meny();
    }


    public void opprettLege() {
        String navn;
        boolean spesialist = false;
        boolean avtaleLege = false;
        int avtaleNummer;
        Lege lege;

        System.out.println("Du har valgt å opprette en lege.");
        System.out.print("Legens navn: ");
        input.nextLine();
        navn = input.nextLine();

        System.out.print("Er legen spesialist? y/n: ");
        if (input.nextLine().equals("y")) {
            spesialist = true;
        }
        System.out.print("Har legen en avtale med kommunen? y/n: ");
        if (input.nextLine().equals("y")) {
            avtaleLege = true;
            System.out.print("Hva er legens avtalenummer?");
            while (!input.hasNextInt()) {
                System.out.print("Ugyldig input, skriv et tall: ");
                input.next();
            }
            avtaleNummer = input.nextInt();
            lege = new Lege(navn, spesialist, avtaleLege, avtaleNummer);
        } else {
            lege = new Lege(navn, spesialist);


        }
        legeBeholder.settInnElement(lege);

        System.out.println("\nDu har nå opprettet " + navn + " som lege i systemet\n");
        meny();
    }

    public void opprettPerson() {
        String navn;
        boolean mann = false;
        String kjonn;


        System.out.println("Du har valgt å opprette en person.");
        System.out.print("Personens navn: ");
        input.nextLine();
        navn = input.nextLine();
        System.out.print("Personens kjønn: ");
        kjonn = input.nextLine();
        if (kjonn.toLowerCase().equals("mann")) {
            mann = true;
        }
        Person person = new Personprodusent(navn, mann).nyPerson();
        personBeholder.settInnObjekt(person, personBeholder.antall);
        System.out.println("Du har n� opprettet personen " + navn + " i systemet.\n");
        meny();
    }

    public void opprettResept() {
        boolean blaa = false;
        int reit;
        String farge;
        Lege lege = null;
        Person person = null;
        Legemiddel legemiddel = null;


        System.out.println("Du har valgt � opprette en resept");

        System.out.print("Reseptens farge: ");
        farge = input.nextLine();
        if (farge.toLowerCase().equals("bl�") || farge.toLowerCase().equals("blaa")) {
            blaa = true;
        }
        input.nextLine();

        System.out.print("Antall mulige bruk av resept: ");
        reit = input.nextInt();
        input.nextLine();

        System.out.print("Reseptens utsteder: ");
        String utsteder = input.nextLine();
        Iterator<Lege> itr = legeBeholder.iterator();
        while (itr.hasNext()) {
            if (!itr.next().hentNavn().equals(utsteder)) {
                System.out.println("Legen finnes ikke, du sendes tilbake\n.");
                meny();
            } else {
                lege = legeBeholder.finnElement(utsteder);
            }
        }

        System.out.print("Reseptinnehaver: ");
        String innehaver = input.nextLine();
        Iterator<Person> itrP = personBeholder.iterator();
        while (itrP.hasNext()) {
            if (!itrP.next().hentNavn().equals(innehaver)) {//
                System.out.println("Personen finnes ikke i systemet, prøv på nytt.");
            } else {
                person = (Person) personBeholder.finnObjektFraNokkel(innehaver);

            }

        }

        System.out.print("Legemiddel: ");
        String lmiddel = input.nextLine();
        Iterator<Legemiddel> itrL = legemiddelBeholder.iterator();

        while (itrL.hasNext()) {
            if (!itrL.next().hentNavn().equals(lmiddel)) {
                System.out.println("Legemiddelet finnes ikke i systemet, pr�v p� nytt");
            } else {
                legemiddel = (Legemiddel) legemiddelBeholder.finnObjektFraNokkel(lmiddel);
            }

        }
        Resept resept = Reseptprodusent.nyResept(blaa, reit, lege, person, legemiddel);
        System.out.println("Du har nå opprettet resepten " + resept + ".\n");
        meny();
    }

    public void hentResept() {
        Resept resept;
        int personNummer;
        int reseptNummer;

        System.out.println("Du har valgt � hente ut en resept.");
        System.out.print("Skriv inn personnummeret: ");
        personNummer = input.nextInt();
        System.out.println("");
        System.out.print("Skriv inn reseptens nummer: ");
        reseptNummer = input.nextInt();
        System.out.println("");

        //TODO Finne resepten fra reseptNummer && personNummer
        if (reseptBeholder.finnElementFraNummer(reseptNummer) == reseptBeholder.finnElementFraPersonNummer(personNummer)) {
            if (reseptBeholder.finnElementFraNummer(reseptNummer) == null) {
                System.out.println("Ugyldig nummer, ingen resept under dette nummer.");
            } else {
                reseptBeholder.finnElementFraNummer(reseptNummer).brukResept();
            }
        }

        meny();


    }
    //TODO valg 6
    private void skrivUtInfo() {
        //for-each løkke til å gå igjennom

        for (Legemiddel legemiddel : legemiddelBeholder) {
            legemiddel.hentEgenskap();
        }


    }

//TODO Siste funksjoner
}
