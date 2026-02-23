public class tema1_continuare {

    // Creează o metodă care afișează: “Invat Java!”
    public static void mesaj() {
        System.out.println("Invat Java!");
    }


    // Creaza o metoda cu 2 parametrii int, care returneaza produsul celor doi parametrii.
    public static int produs(int x, int y) {
        return x * y;
    }


    // Calculează suma numerelor pare de la 1 la 50. Crează o metoda care returneaza rezultatul.
    public static int sumaSir(int start, int stop) {
        int sum = 0;
        while (start <= stop) {
            if (start % 2 == 0) {
                sum += start;
            }
            start++;
        }
        return sum;
    }


    // Creaza o metoda cu 3 parametrii. Returneaza media celor trei parametrii.
    public static int mediaATreiNumere(int a, int b, int c) {
        return (a + b + c) / 3;
    }


    //  Creeaza o metoda care primeste 2 parametrii: start si end.
    //  Afiseaza toate numerele cuprinse intre aceste doua numere.
    public static void afisareaUnuiSir(int start, int end) {
        if (start <= end) {
            while (start <= end) {
                System.out.print(start + " ");
                start++;
            }
        } else {
            System.out.println("Primul numar trebuie sa fie mai mic decat al doilea numar");
        }

    }



    public static void main() {
        mesaj();
        System.out.println();

        int suma = produs(10, 23);
        System.out.println("Produsul a doua numere: " + suma);
        System.out.println();

        int sumaSirului = sumaSir(1, 50);
        System.out.println("Suma numerelor pare de la 1 la 50: " + sumaSirului);
        System.out.println();

        int mediaNumerelor = mediaATreiNumere(1, 2,3);
        System.out.println("Media a trei numere: " + mediaNumerelor);
        System.out.println();

        System.out.println("Afisarea numerelor dintr-un sir");
        afisareaUnuiSir(10, 23);
        System.out.println();
    }
}
