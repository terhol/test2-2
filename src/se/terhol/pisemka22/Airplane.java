package se.terhol.pisemka22;

/**
 * Airplane with given number of seats.
 *
 * @author Ludek Bartek
 */
public interface Airplane {
    /**
     * Returns passenger having reservation on the given seat.
     *
     * @param seat seat number (>= 0)
     * @return passenger having reservation on the given seat or null
     * @throws IndexOutOfBoundsException if the seat number is out of the array size
     */
    public Passenger getPassenger(int seat);

    /**
     * @return airplane capacity
     */
    public int getCapacity();

    /**
     * Returns seat number of given passenger.
     *
     * @param pas passenger
     * @return seat number >= 0
     * @throws ReservationException with "No such passenger" decription if there is
     *                              no reservation in the plane for given passenger or if the passenger is null
     */
    public int getPassengerReservation(Passenger pas) throws ReservationException;

    /**
     * Makes reservation of a seat. Every passenger can have only one
     * reservation in the plane.
     *
     * @param pas reserving passenger
     * @throws ReservationException with the "Airplane is full" description
     *                              if the airplane is full
     * @throws ReservationException with the "Duplicate reservation" description
     *                              if the passsenger already has reservation in the plane
     */
    public void makeReservation(Passenger pas) throws ReservationException;

    /**
     * Canceles reservation.
     *
     * @param pas passenger
     * @throws ReservationException with the "No such passenger" description
     *                              if the passenger has no reservation in the airplane
     */
    public void cancelReservation(Passenger pas) throws ReservationException;
}
