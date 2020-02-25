package app.controle.principal;

import app.controle.log.AbstractLogger;
import app.controle.log.ConsoleLogger;
import app.controle.log.ErrorLogger;
import app.controle.log.FileLogger;

public class App {
    private static AbstractLogger getChainOfLoggers1() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        
        return errorLogger;
    }

    private static AbstractLogger getChainOfLoggers2() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        
        errorLogger.setNextLogger(consoleLogger);
        consoleLogger.setNextLogger(fileLogger);
        
        return errorLogger;
    }
    private static AbstractLogger getChainOfLoggers3() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        
        consoleLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fileLogger);
        
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain1 = getChainOfLoggers1();
        System.out.println("Teste Padrao Cadeia de Responsabilidades (Chain of Responsibility) 1");
        loggerChain1.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain1.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
        loggerChain1.logMessage(AbstractLogger.ERROR, "This is an error information.");
        System.out.println("");

        AbstractLogger loggerChain2 = getChainOfLoggers2();
        System.out.println("Teste Padrao Cadeia de Responsabilidades (Chain of Responsibility) 2");
        loggerChain2.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain2.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
        loggerChain2.logMessage(AbstractLogger.ERROR, "This is an error information.");
        System.out.println("");

        AbstractLogger loggerChain3 = getChainOfLoggers3();
        System.out.println("Teste Padrao Cadeia de Responsabilidades (Chain of Responsibility) 3");
        loggerChain3.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain3.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
        loggerChain3.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}