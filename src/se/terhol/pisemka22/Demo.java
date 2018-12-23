package se.terhol.pisemka22;

public class Demo {
    public static void main(String[] args) {
        Airplane plane = new AirplaneImpl(2);
        Passenger pas1, pas2, pas3;
        pas1 = new PassengerImpl("A");
        pas2 = new PassengerImpl("B");
        pas3 = new PassengerImpl("C");

        System.out.println("Rezervace: " + getReservations(plane));

        try {
            plane.makeReservation(pas1);
            plane.makeReservation(pas2);
            System.out.println("Rezervace OK.");
        } catch (Exception ex) {
            System.err.println("CHYBA: Nastala neocekavana vyjimka pri dobre rezervaci: " + ex);
        }

        try {
            plane.makeReservation(pas3);
            System.err.println("CHYBA: Mela byt vyhozena vyjimka ReservationException.");
        } catch (ReservationException ex) {
            System.out.println("Pokus o rezervaci nad kapacitu letu OK.");
            System.out.println("Rezervace: " + getReservations(plane));
        }

        try {
            plane.cancelReservation(pas1);
            System.out.println("Zruseni existujici rezervace OK.\n" + getReservations(plane));
        } catch (Exception ex) {
            System.err.println("CHYBA: nelze zrusit existujici rezervaci.");
        }

        try {
            plane.cancelReservation(pas3);
            System.err.println("CHYBA: Povedlo se zrusit neexistujici rezervaci.");
        } catch (ReservationException ex) {
            System.out.println("Zruseni neexistujici rezervace OK");
        } catch (Exception ex1) {
            System.err.println("Ruseni neexistujici rezervace: vyvolana neoocekavana vyjimka.\n" + getReservations(plane));
        }

        try {
            int reservation = plane.getPassengerReservation(pas2);
            System.out.println(pas2 + " ma rezervaci " + reservation);
        } catch (Exception ex) {
            System.err.println("CHYBA: neocekavana vyjimka pri snaze o ziskani rezervace.");
        }

        try {
            int reservation = plane.getPassengerReservation(pas1);
            System.err.println("CHYBA: Podarilo se ziskat cislo neexistujici rezervace pro "
                    + pas2 + ": " + reservation);
        } catch (ReservationException ex) {
            System.out.println("Snaha o ziskani neexistujici rezervace OK.");
        }
    }

    private static String getReservations(Airplane airplane) {
        StringBuilder retVal = new StringBuilder("[");
        for (int i = 0; i < airplane.getCapacity(); i++) {
            retVal.append(i + ": " + airplane.getPassenger(i) + " ");
        }
        retVal.append("]");
        return retVal.toString();
    }
}
