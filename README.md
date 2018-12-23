# Test 2-1
Second test version 2 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description (Czech language only)


Rozhraní ani třídu `Demo` neměňte, pokud to přímo nevyžaduje zadání!
Metody NEMUSÍTE dokumentovat pomocí JavaDoc komentářů. Používejte
zásadně privátní atributy.

-   Upravte třídu `PassengerImpl` tak, aby byli dva pasažéři stejní,
    pokud mají stejné číslo pasu.
-   Vytvořte **hlídanou** výjimku `ReservationException`. Výjimka bude
    mít dva konstruktory: bezparametrický a s textovým popisem chyby.
-   Vytvořte třídu `AirplaneImpl` implementující rozhraní `Airplane`.
    Implementace bude používat **pole** (nikoliv kolekce). Kapacita
    letadla je dána parametrem konstruktoru. Pokud je zadaná hodnota
    menší nebo rovna nule, vyhodí konstruktor vhodnou výjimku.
-   __Metody `cancelReservation()` a `makeReservation()` budou
    využívat metodu `getPassengerReservation()` pro zjištění, jestli má
    pasažér rezervaci a na které sedadlo__

Třída `Demo` slouží pro vaši kontrolu funkčnosti kódu a obsahuje také
logiku volání metod. Správný výstup by měl vypadat následovně:

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