package entities;

/**
 *
 * @author Yohan Romero
 */
public class Route {

    private Passenger passenger;
    private String movements;

    /**
     * This
     *
     * @param passenger The passenger asigned to this route
     * @param movements A string that represents the sequence of movements
     */
    public Route(Passenger passenger, String movements) {
        this.passenger = passenger;
        this.movements = movements;
    }

    /**
     *
     * @return The driver asigned
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     *
     * @param passenger The passenger to be assigned
     */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     *
     * @return The sequence of movements
     */
    public String getMovements() {
        return movements;
    }

    /**
     *
     * @param movements The sequence of movements
     */
    public void setMovements(String movements) {
        this.movements = movements;
    }
}
