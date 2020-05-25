package string;

import java.util.Locale;

/**
 * Zastosowanie: Tworzenie stringów sparametryzowanych ze zmiennych
 *
 * system.out.printf() - drukowanie formatowanego stringa
 * String.format() - formwatowanie nowego stringa
 *
 * %c - char
 * %d - int, short, long, byte
 *      możliwe jest dodawanie ilości zer przed liczbą
 *      np. %02d - co da nam liczbę dwucyfrową z jednym zerem z przodu
 * %f - float, double
 *      float i double mają możliwość ograniczenia do ilości cyfr po przecinku np. %.5f
 * %s - stringi
 * %n - znak nowej linii
 *
 * Source: 'JetBrains Academy: https://hyperskill.org/learn/step/7046
 */
public class FormatExamples {

    /**
     * Przykład dla drukowania sformatowanego stringa - printf()
     */
    static class Printf {
        public static void main(String[] args) {
            System.out.printf("%s ma %.2f długości i spala %f litrów na %d km", "Syrena", 4.040, 8.1, 100);
            // Syrena ma 4,04 długości i spala 8,100000 litrów na 100 km
        }
    }

    /**
     * Przykład dla sformatowanego nowego stringa - .format()
     */
    static class FormatString {
        public static void main(String[] args) {
            String syrena = String.format("%s ma %.2f długości i spala %f litrów na %d km", "Syrena", 4.040, 8.1, 100);
            System.out.println(syrena);
            // Syrena ma 4,04 długości i spala 8,100000 litrów na 100 km
        }
    }

    /**
     * Przykład parametryzowania stringa dla różnych typów zmiennych
     */
    static class Zmienne {
        public static void main(String[] args){
            String name = "Mój samochód to %c%c%c %s.%n";
            String produced ="Wyprodukowany w %dr. ";
            String length = "Jego długość to %.2fm.%n";
            int year = 1980;
            String time = "Włączyłem go dziś o %02d:%02d.";
            System.out.println(String.format(name + produced + length + time, 'F', 'S', 'M', "Syrena", year, 4.04d, 1, 5));
            /*
            Mój samochód to FSM Syrena.
            Wyprodukowany w 1980r. Jego długość to 4,04m.
            Włączyłem go dziś o 01:05.
             */
        }
    }

    /**
     * Formatowanie stringów z ustawieniami regionalnymi
     */
    static class UstawieniaRegionalne {
        public static void main(String[] args) {
            float expectedLat = 50.102985f;
            float expectedLng = -1.111111f;
            System.out.println("----- Formatowanie współrzędnych geograficznych dla ustawień angielskich -----");
            String englishCords = String.format(Locale.ENGLISH, "%.5f, %.5f", expectedLat, expectedLng);
            System.out.println(englishCords);
            // 50.10299, -1.11111
            System.out.println("----- Formatowanie współrzędnych geograficznych dla ustawień francuskich (w tym polskich) -----");
            String frenchCords = String.format(Locale.FRANCE, "%.5f, %.5f", expectedLat, expectedLng);
            System.out.println(frenchCords);
            // 50,10299, -1,11111
        }
    }
}
