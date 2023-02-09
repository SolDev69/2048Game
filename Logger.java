import java.sql.Date;
//import java.time.Instant;

public class Logger {
    static void log(int message) {
        System.out.println(message);
    }
    static void log(String message) {
        System.out.println("[" +
                //Date.from(Instant.ofEpochMilli(System.currentTimeMillis()))
                "Game"
                + "] " + message);
    }
}