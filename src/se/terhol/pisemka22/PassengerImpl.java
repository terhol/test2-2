package se.terhol.pisemka22;

/**
 * Passenger.
 *
 * @author Ludek Bartek
 */
public class PassengerImpl implements Passenger {
    private String passportNumber;

    /**
     * @param passportNumber passport number
     * @throws NullPointerException if passport number is null
     */
    public PassengerImpl(String passportNumber) {
        if (passportNumber == null) {
            throw new NullPointerException("passportNumber");
        }
        this.passportNumber = passportNumber;
    }

    @Override
    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return passportNumber;
    }
}
