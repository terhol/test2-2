# Test 2-1
Second test version 2 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description


Do not change interface or already defined classes, if the task doesn’t require it explicitly! You do not have to document methods by JavaDoc comments. Use private attributes only.

-   Change the `PassengerImpl` class so that two passengers are same if their passport numbers are same.
-   Use **checked** exception ResevationException. This exception will have two constructors: one without parameter and one with textual error description.
-   Create `AirplaneImpl` class which implements `Airplane` interface. Implementation will use **arrays** (not collections). The airplane capacity is given by parameter of constructor. If the number given is less or equal to zero, constructor will throw an exception.
-   **Methods `cancelReservation()` and `makeReservation()` will use `getPassengerResevation()` method for checking if the passenger has a reservation and for which seat.**

`Demo` class is for checking code functionality and also contains logic of method calling. The right output should look like this:

    Rezervace: [0: null 1: null ]
    Rezervace OK.
    Pokus o rezervaci nad kapacitu letu OK.
    Rezervace: [0: A 1: B ]
    Zruseni existujici rezervace OK.
    [0: null 1: B ]
    Zruseni neexistujici rezervace OK
    B ma rezervaci 1
    Snaha o ziskani neexistujici rezervace OK.

## License
MIT
