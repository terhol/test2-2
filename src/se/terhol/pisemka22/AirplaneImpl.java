package se.terhol.pisemka22;

/**
 * @author Tereza Holm
 */
public class AirplaneImpl implements Airplane {
    Passenger[] seatList;
    int capacity;

    public AirplaneImpl(int capacity) {
        if (capacity <= 0) {
            throw new IndexOutOfBoundsException();
        }
        this.capacity = capacity;
        this.seatList = new PassengerImpl[capacity];


    }

    @Override
    public Passenger getPassenger(int seat) {
        if(seat < 0 || seat >= this.getCapacity()) {
            throw new IndexOutOfBoundsException();
        }
        return seatList[seat];
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getPassengerReservation(Passenger pas) throws ReservationException {
        if(pas == null) {
            throw new ReservationException();
        }
        int isFound = -1;
        for(int i = 0; i<this.getCapacity(); i++) {
            if (seatList[i] != null && seatList[i].equals(pas)) {
                isFound = i;
            }
        }

        if (isFound < 0) {
            throw new ReservationException("No such passenger");
        }
        return isFound;
    }

    @Override
    public void makeReservation(Passenger pas) throws ReservationException {

        int freeSeat = -1;
        for(int i = 0; i<this.getCapacity(); i++) {
            if(this.seatList[i] == null){
                freeSeat = i;
                seatList[freeSeat] = pas;
                return;
            }
        }
        if (freeSeat == -1){
            throw new ReservationException("Airplane is full");
        }
        if(this.getPassengerReservation(pas) >= 0) {
            throw new ReservationException("Duplicate reservation");
        }



    }

    @Override
    public void cancelReservation(Passenger pas) throws ReservationException {
        int seatNumber = this.getPassengerReservation(pas);
        if (seatNumber < 0) {
            throw new ReservationException("No such passenger");
        }

        seatList[seatNumber] = null;

    }
}
