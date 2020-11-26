public class Console {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public Console(){}

    public void Message(String msg)
    {
        System.out.println(ANSI_WHITE + msg + ANSI_RESET);
    }

    public void Info(String msg)
    {
        System.out.println(ANSI_CYAN + msg + ANSI_RESET);
    }

    public void Debug(String msg)
    {
        System.out.println(ANSI_YELLOW + msg + ANSI_RESET);
    }

    public void Success(String msg)
    {
        System.out.println(ANSI_GREEN + msg + ANSI_RESET);
    }

    public void Error(String msg)
    {
        System.out.println(ANSI_RED + msg + ANSI_RESET);
    }

    public void PrintInstructions()
    {
        System.out.print(ANSI_BLUE);

        System.out.println("A - Pedir impresora");
        System.out.println("B - Usar impresora");
        System.out.println("C - Devolver impresora");
        System.out.println("D - Pedir pantalla");
        System.out.println("E - Usar pantalla");
        System.out.println("F - Devolver pantalla");
        System.out.println("G - Pedir teclado");
        System.out.println("H - Usar teclado");
        System.out.println("I - Devolver teclado");
        System.out.println("O - Ejecutar operacion O");
        System.out.println("P - Ejecutar operacion P");
        System.out.println("Q - Ejecutar operacion Q");

        System.out.println(ANSI_RESET);   
    }

    public void PrintResources()
    {
        System.out.print(ANSI_BLUE);

        System.out.println("1 - Impresora");
        System.out.println("2 - Monitor");
        System.out.println("3 - Teclado");

        System.out.println(ANSI_RESET);   
    }

}
