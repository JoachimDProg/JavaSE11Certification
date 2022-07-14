package com.cgi.util;

import java.math.BigDecimal;
import java.util.List;

public class Data {
    public static List<String> consoles = List.of("Super Nintendo", "Playstation 4", "Nintendo", "Game Boy Color", "Nintendo 64",
            "Playstation", "Xbox", "Neo Geo", "Playstation 3", "Nintendo Switch", "Sega Genesis", "Game Boy");

    public static List<Console> consolesMsrp = List.of(
            new Console("Super Nintendo", "Nintendo", BigDecimal.valueOf(139.99)),
            new Console("Playstation 4", "Playstation", BigDecimal.valueOf(249.99)),
            new Console("Nintendo", "Nintendo", BigDecimal.valueOf(129.99)),
            new Console("Game Boy Color", "Portable", BigDecimal.valueOf(69.99)),
            new Console("Nintendo 64", "Nintendo", BigDecimal.valueOf(99.99)),
            new Console("Playstation", "Playstation", BigDecimal.valueOf(99.99)),
            new Console("Xbox", "Other", BigDecimal.valueOf(49.99)),
            new Console("Neo Geo", "Other", BigDecimal.valueOf(299.99)),
            new Console("Playstation 3", "Playstation", BigDecimal.valueOf(149.99)),
            new Console("Nintendo Switch", "Nintendo", BigDecimal.valueOf(299.99)),
            new Console("Sega Genesis", "Other", BigDecimal.valueOf(129.99)),
            new Console("Game Boy", "Portable", BigDecimal.valueOf(59.99))
    );

    // Same console list but using record instead of normal classes
    public static List<ConsoleRecord> consolesMsrpR = List.of(
            new ConsoleRecord("Super Nintendo", "Nintendo", BigDecimal.valueOf(139.99)),
            new ConsoleRecord("Playstation 4", "Playstation", BigDecimal.valueOf(249.99)),
            new ConsoleRecord("Nintendo", "Nintendo", BigDecimal.valueOf(129.99)),
            new ConsoleRecord("Game Boy Color", "Portable", BigDecimal.valueOf(69.99)),
            new ConsoleRecord("Nintendo 64", "Nintendo", BigDecimal.valueOf(99.99)),
            new ConsoleRecord("Playstation", "Playstation", BigDecimal.valueOf(99.99)),
            new ConsoleRecord("Xbox", "Other", BigDecimal.valueOf(49.99)),
            new ConsoleRecord("Neo Geo", "Other", BigDecimal.valueOf(299.99)),
            new ConsoleRecord("Playstation 3", "Playstation", BigDecimal.valueOf(149.99)),
            new ConsoleRecord("Nintendo Switch", "Nintendo", BigDecimal.valueOf(299.99)),
            new ConsoleRecord("Sega Genesis", "Other", BigDecimal.valueOf(129.99)),
            new ConsoleRecord("Game Boy", "Portable", BigDecimal.valueOf(59.99))
    );
}
