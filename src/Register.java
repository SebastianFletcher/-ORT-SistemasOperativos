import java.util.ArrayList;
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class Register 
{
    Console console = new Console();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

    public Program createProgram()
    {
        console.Info("Indique las instrucciones separadas por coma: ");
        console.PrintInstructions();
        String instructions = "";

        try
        {
            instructions = reader.readLine();
        }
        catch(Exception e)
        {
            console.Error(e.toString());
        }

        Program program = new Program(instructions.toUpperCase().split(","));
        console.Debug(program.toString());

        return program;
    }

    public User registerUser(Resource printer, Resource screen, Resource kb, Program pOne, Program pTwo, Program pThree)
    {
        User user = new User();
        
        console.Info("Ingresar Usuario:");
        
        try
        {
            console.Info("Ingrese nombre: ");
            user.setName(reader.readLine());

            console.Info("Seleccione los Recursos habilitados: ");
            console.PrintResources();
            String selectedResources = reader.readLine();
            ArrayList<Resource> resources = new ArrayList<Resource>();
           
            if(selectedResources.contains("1"))
                resources.add(printer);
            if(selectedResources.contains("2"))
                resources.add(screen);
            if(selectedResources.contains("3"))
                resources.add(kb);
            
            user.setAllowedResources(resources);

            console.Info("Seleccione los Programas habilitados: ");
            console.Info("1- " + pOne.toString());
            console.Info("2- " + pTwo.toString());
            console.Info("3- " + pThree.toString());

            String selectedPrograms = reader.readLine();
            ArrayList<Program> programs = new ArrayList<Program>();

            if(selectedPrograms.contains("1"))
                programs.add(pOne);
            if(selectedPrograms.contains("2"))
                programs.add(pTwo);
            if(selectedPrograms.contains("3"))
                programs.add(pThree);

            user.setAllowedPrograms(programs);
        }
        catch(Exception e)
        {
            console.Error(e.toString());
        }
        
        console.Debug(user.toString());
        return user;
    }

    public Process createProcess(Program pOne, Program pTwo, Program pThree, User uOne, User uTwo, User uThree)
    {
        Process process = new Process();

        try
        {
            console.Info("Indique nombre del Proceso: ");
            process.setName(reader.readLine());

            console.Info("Indique el Programa a ejecutar: ");
            console.Info("1- " + pOne.toString());
            console.Info("2- " + pTwo.toString());
            console.Info("3- " + pThree.toString());
            String prog = reader.readLine().substring(0, 1);

            if(prog.equals("1"))
                process.setProgram(pOne);
            else if(prog.equals("2"))
                process.setProgram(pTwo);
            else
                process.setProgram(pThree);
         
            console.Info("Indique el Usuario: ");
            console.Info("1- " + uOne.getName());
            console.Info("2- " + uTwo.getName());
            console.Info("3- " + uThree.getName());
            String user = reader.readLine().substring(0, 1);

            if(user.equals("1"))
                process.setUser(uOne);
            else if(user.equals("2"))
                process.setUser(uTwo);
            else
                process.setUser(uThree);
        }
        catch(Exception e)
        {
            console.Error(e.toString());
        }

        console.Debug(process.toString());

        return process;
    }
}
