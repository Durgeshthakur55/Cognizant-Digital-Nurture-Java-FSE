class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("A new Logger instance has been created.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class LoggerTest {
    public static void main(String[] args) {
        System.out.println("--- Starting Singleton Test ---");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("User logged in.");

        System.out.println("\n--- Verification ---");
        System.out.println("Logger 1 Memory ID: " + logger1.hashCode());
        System.out.println("Logger 2 Memory ID: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables refer to the exact same Logger instance!");
        } else {
            System.out.println("FAIL: Multiple instances were created.");
        }
    }
}
