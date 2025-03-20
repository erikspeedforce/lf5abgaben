/*
Fahrkartenautomat Übungsprojekt
@author Erik Ramani(FI-B-41)
@version A2.6, A3.3, A3.4, A3.5, A4.3, A4.5
 */

import java.util.Arrays;
import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;

        int anzahlTickets;

        // Geldbetrag eingeben
        System.out.print("Zu zahlender Betrag (Euro): ");
        zuZahlenderBetrag = tastatur.nextDouble();

        //Ticketgrenzen
        if (zuZahlenderBetrag < 0 || zuZahlenderBetrag > 10) {
            System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt.");
            zuZahlenderBetrag = 1;
        }

        System.out.print("Anzahl der Tickets: ");
        anzahlTickets = tastatur.nextInt();

        //Ticketgrenzen
        if (anzahlTickets < 0 || anzahlTickets > 10) {
            System.out.println("Fehlerhafte Eingabe - Ticketanzahl wird auf 1 gesetzt.");
            anzahlTickets = 1;
        }





        // Geldeinwurf
        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;


        Double[] akzeptierendesgeld = {0.05, 0.1, 0.2, 0.5,1.0,2.0,5.0,10.0,20.0};

        zuZahlenderBetrag *= anzahlTickets;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = (zuZahlenderBetrag - eingezahlterGesamtbetrag);
            System.out.printf("Noch zu zahlen: %.2f \n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            if (Arrays.asList(akzeptierendesgeld).contains(eingeworfeneMuenze)) {
                eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
            } else {
                System.out.println(">> Kein gültiges Zahlungsmittel <<");
                continue;
            }
        }

        // Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // Rückgeldberechnung und -ausgabe
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt:");
            rueckgabebetrag += 0.01;
            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag = rueckgabebetrag - 2.0;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = rueckgabebetrag - 1.0;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.5;

            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.2;

            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.1;

            }
            while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.05;

            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }
}

