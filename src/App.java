import java.util.ArrayList;

public class App {

    // Recursos
    final static Resource printer = new Resource("Impresora");
    final static Resource screen = new Resource("Pantalla");
    final static Resource keyboard = new Resource("Teclado");

    final static Console console = new Console();
    final static Register register = new Register();

    public static void main(String[] args) throws Exception {
        ArrayList<Process> processes = new ArrayList<Process>();

        Program pOne = register.createProgram();
        Program pTwo = register.createProgram();
        Program pThree = register.createProgram();

        User uOne = register.registerUser(printer, screen, keyboard, pOne, pTwo, pThree);
        User uTwo = register.registerUser(printer, screen, keyboard, pOne, pTwo, pThree);
        User uThree = register.registerUser(printer, screen, keyboard, pOne, pTwo, pThree);

        Process prOne = register.createProcess(pOne, pTwo, pThree, uOne, uTwo, uThree);
        Process prTwo = register.createProcess(pOne, pTwo, pThree, uOne, uTwo, uThree);
        Process prThree = register.createProcess(pOne, pTwo, pThree, uOne, uTwo, uThree);

        processes.add(prOne);
        processes.add(prTwo);
        processes.add(prThree);

        // Ejecución
        while (!processes.isEmpty()) {
            for (Process p : processes) {
                //Chequeo para desbloquar proceso
                if(p.getProcessStatus() == ProcessState.Blocked){
                    String instruction = String.valueOf(p.getProgram().getInstructions()[p.getRunningProcess()]);
                    Resource resource = getResouce(instruction);
                    if(resource.getResourceStatus() == ResourceState.Waiting){
                        p.setProcessStatus(ProcessState.Running);
                    }
                    else{
                        continue;
                    }
                }
                p.setProcessStatus(ProcessState.Running);
                int timeOut = 20;

                if(!p.getUser().hasProgramPermissions(p.getProgram()))
                {
                    processes.remove(p);
                    console.Error("El usuario " + p.getUser().getName() + " no tiene permiso para ejecutar el programa del proceso " + p.getName());
                    break;
                }

                if (p.finished()) {
                    processes.remove(p);
                    break;
                }

                console.Info("El proceso: " + p.getName() + " tiene el procesador.");

                while (timeOut > 0) {
                    if (timeOut <= 0) {
                        console.Info("TimeOut");
                        break;
                    }

                    if (p.finished()) {
                        console.Success("El proceso " + p.getName() + " finalizó la ejecución");
                        break;
                    }

                    String instruction = String.valueOf(p.getProgram().getInstructions()[p.getRunningProcess()]);
                    Resource resource;

                    console.Debug("Operacion: " + instruction);

                    switch (instruction) {
                        case "A":
                        case "D":
                        case "G":
                            resource = getResouce(instruction);

                            if (!p.getUser().hasResourcePermissions(resource)) {
                                console.Error(
                                        "El usuario " + p.getUser().getName() + " no tiene permisos sobre el recurso "
                                                + resource.getName() + ". Se corta la ejecucion.");
                                p.setRunningProcess(p.getProgram().getInstructions().length);
                                break;
                            } else {
                                if (resource.getResourceStatus() != ResourceState.Waiting) {
                                    console.Error(
                                            "El proceso " + p.getName() + " intenta acceder a un recurso en uso. Se bloquea.");        
                                    p.setProcessStatus(ProcessState.Blocked);        
                                    timeOut = 0;
                                    p.setRunningProcess(p.getRunningProcess() - 1);
                                } else {
                                    resource.setResourceStatus(ResourceState.Running);
                                    timeOut -= 4;
                                }
                            }
                            break;
                        case "B":
                        case "E":
                        case "H":
                            resource = getResouce(instruction);
                            if (resource.getResourceStatus() == ResourceState.Waiting)
                                console.Info("No se inicio el recurso");

                            timeOut -= 2;
                            break;
                        case "C":
                        case "F":
                        case "I":
                            resource = getResouce(instruction);
                            resource.setResourceStatus(ResourceState.Waiting);
                            timeOut -= 3;
                            break;
                        case "O":
                            timeOut -= 4;
                            break;
                        case "P":
                            timeOut -= 3;
                            break;
                        case "Q":
                            timeOut -= 5;
                            break;
                        default:
                            console.Error("Instruccion invalida: " + instruction);
                            break;
                    }
                    p.nextProcess();
                }
                if (timeOut <= 0)
                    console.Info("TimeOut");
                p.setProcessStatus(ProcessState.Waiting);
            }
        }
        console.Success("Procesos finalizados correctamente");
    }

    private static Resource getResouce(String res) {
        if (res.equals("A") || res.equals("B") || res.equals("C"))
            return printer;
        else if (res.equals("D") || res.equals("E") || res.equals("F"))
            return screen;
        else // (res.equals("G") || res.equals("H") || res.equals("I"))
            return keyboard;
    }
}
