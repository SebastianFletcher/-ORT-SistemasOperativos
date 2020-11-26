public class Program 
{
    private String[] instructions;

    //Constructor
    public Program(String[] instructions)
    {
        this.instructions = instructions;
    }

    //Getters & Setters
    //Instructions
    public String[] getInstructions()
    {
        return this.instructions;
    }
    public void setInstructions(String[] instructions)
    {
        this.instructions = instructions;
    }

    //Methods
    @Override
    public String toString()
    {
        String instructionsList = "";

        for(String instruction : this.instructions)
            instructionsList += instruction + ",";

        return instructionsList.substring(0, instructionsList.length() -1);
    }
}
