public class tema1 {
    public static void main() {
        /*
        Creează variabile pentru: varsta unui student, inaltimea acestuia, daca este prezent la curs.
        Afiseaza datele prin mesaje/propozitii.
         */
        int varstaStudent = 20;
        double inaltimeStudent = 1.81;
        boolean prezentLaCurs = false;

        System.out.println("Varsta studentului: " + varstaStudent);
        System.out.println("Inaltimea studentului: " + inaltimeStudent);
//        System.out.println("Este studentul prezent la curs? " + prezentLaCurs);
        if (prezentLaCurs) {
            System.out.println("Studentul este prezent la curs");
        } else {
            System.out.println("Studentul nu este prezent la curs");
        }

        System.out.println();


        /*
        Crează doua variabile int si una double. Calculeaza suma celor doua valori int. Calculeaza media dintre toate 3.
        */
        int primulNumar = 23;
        int alDoileaNumar = 45;
        double alTreileaNumar = 2.09;

//        System.out.println(primulNumar + alDoileaNumar);
//        System.out.println((primulNumar + alDoileaNumar + alTreileaNumar)  / 3);

        int produsulADouaNumere = primulNumar + alDoileaNumar;
        double mediaNumerelor = (produsulADouaNumere + alTreileaNumar) / 3;

        System.out.println("Produsul primelor 2 numere: " + produsulADouaNumere);
        System.out.println("Media celor 3 numere: " + mediaNumerelor);
        System.out.println();


        /*
        Creaza o variabila pentru varsta. Dacă persoana are 18 sau mai mult, afișează: “Acces permis”, altfel “Acces interzis”.
         */
        int varsta = 17;

        System.out.println("Afiseaza nivelul de acces");

        if (varsta >= 18) {
            System.out.println("Acces permis");
        } else {
            System.out.println("Acces interzis");
        }

        System.out.println();


        /*
        Calculeaza suma numerelor de la 20 la 50
         */
        int sumaNumerelor = 0;
        for (int i = 20; i <= 50; i ++) {
            sumaNumerelor += i;
        }

        System.out.println("Calculeaza suma numerelor de la 20 la 50");
        System.out.println("Suma numerelor de la 20 la 50 este: " + sumaNumerelor);
        System.out.println();


        /*
        Afișează numerele de la 10 la 1 folosind while.
         */
        int start = 10;
        int stop = 1;

        System.out.println("Afișează numerele de la 10 la 1 folosind while:");

        while (start >= stop) {
            System.out.print(start + " ");
            start--;
        }

        System.out.println();
    }
}
