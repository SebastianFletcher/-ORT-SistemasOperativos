public class Process 
{
    private String name;
    private Program program;
    private User user;
    private int runningProgram;
    private int processLength;
    private ProcessState status;

    //Constructor
    public Process()
    {

    }

    public Process(String name, Program program, User user)
    {
        this.name = name;
        this.program = program;
        this.user = user;
        this.runningProgram = 0;
        this.processLength = program.getInstructions().length;
        this.status = ProcessState.Waiting;
    }

    //Getters & Setters
    //Name
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    //Program
    public Program getProgram()
    {
        return this.program;
    }
    public void setProgram(Program program)
    {
        this.program = program;
        this.processLength = program.getInstructions().length;
    }

    //User
    public User getUser()
    {
        return this.user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    
    //Running Program
    public int getRunningProcess()
    {
        return this.runningProgram;
    }
    public void setRunningProcess(int process)
    {
        this.runningProgram = process;
    }

    //Process Status
    public ProcessState getProcessStatus()
    {
        return this.status;
    }
    public void setProcessStatus(ProcessState state)
    {
        this.status = state;
    }

    //Methods
    public void nextProcess() 
    {
        this.runningProgram ++;
    }

    public boolean finished()
    {
        return this.runningProgram >= this.processLength;
    }

    @Override
    public String toString()
    {
        return "Proceso: " + this.getName() + "\n" + 
                "Programa: " + this.getProgram().toString() + "\n" + 
                "Usuario :" + this.getUser().getName();
    }
}
