package bankapp.models;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static final Logger logger = Logger.getLogger(Log.class.getName());

    public Log() {
        try {
            FileHandler fileHandler = new FileHandler("program.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
    
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
    
            // Opcional: desabilita o log na console
            Logger rootLogger = Logger.getLogger("");
            rootLogger.setLevel(Level.OFF);
    
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Não foi possível configurar o log", e);
        }
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warning(String message) {
        logger.warning(message);
    }

    public void severe(String message) {
        logger.severe(message);
    }

    public void log(Level level, String message, Throwable thrown) {
        logger.log(level, message, thrown);
    }
}
