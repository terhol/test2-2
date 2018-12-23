package se.terhol.pisemka22;

/**
 * @author Tereza Holm
 */
public class AirplaneImpl implements Airplane {
    private Passenger[] seatList;
    private int capacity;
    private final int NO_SEAT_CODE = -1;

    public AirplaneImpl(int capacity) {
        if (capacity <= 0) {
            throw new IndexOutOfBoundsException();
        }
        this.capacity = capacity;
        this.seatList = new PassengerImpl[capacity];
    }

    @Override
    public Passenger getPassenger(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= this.getCapacity()) {
            throw new IndexOutOfBoundsException();
        }
        return seatList[seatNumber];
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getPassengerReservation(Passenger passenger) throws ReservationException {
        if (passenger == null) {
            throw new ReservationException();
        }

        int reservedSeat = getReservedSeatIfExist(passenger);

        if (reservedSeat == NO_SEAT_CODE) {
            throw new ReservationException("No such passenger");
        }

        return reservedSeat;
    }

    @Override
    public void makeReservation(Passenger passenger) throws ReservationException {
        int freeSeat = this.getFreeSeatIfExist();

        if (freeSeat == NO_SEAT_CODE) {
            throw new ReservationException("Airplane is full");
        }

        if (getReservedSeatIfExist(passenger) != NO_SEAT_CODE) {
            throw new ReservationException("Duplicate reservation");
        }

        seatList[freeSeat] = passenger;
    }

    @Override
    public void cancelReservation(Passenger passenger) throws ReservationException {
        int seatNumber = getPassengerReservation(passenger);
        if (seatNumber < 0) {
            throw new ReservationException("No such passenger");
        }

        seatList[seatNumber] = null;
    }

    /**
     * Returns reserved seat if exist (every passenger can have max one seat reserved).
     *
     * @param passenger passenger who maybe has some seat reserved
     * @return number of a reserved seat if exists, NO_SEAT_CODE otherwise
     */
    private int getReservedSeatIfExist(Passenger passenger) {
        for (int i = 0; i < this.getCapacity(); i++) {
            if (seatList[i] != null && seatList[i].equals(passenger)) {
                return i;
            }
        }

        return NO_SEAT_CODE;
    }

    /**
     * Try to return a free seat.
     *
     * @return number of a free seat if exists, NO_SEAT_CODE otherwise
     */
    private int getFreeSeatIfExist() {
        for (int i = 0; i < this.getCapacity(); i++) {
            if (this.seatList[i] == null) {
                return i;
            }
        }

        return NO_SEAT_CODE;
    }
}
