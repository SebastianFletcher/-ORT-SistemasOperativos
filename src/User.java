import java.util.ArrayList;

public class User 
{    
    private String name;
    private ArrayList<Program> allowedPrograms;
    private ArrayList<Resource> allowedResources;
    
    //Constructors
    public User()
    {
        
    }

    public User(String name) 
    {
        this.name = name;
    }

    public User(String name, ArrayList<Program> programs, ArrayList<Resource> resources)
    {
        this.name = name;
        this.allowedPrograms = programs;
        this.allowedResources = resources;
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

    //Allowed Programs
    public ArrayList<Program> getAllowedPrograms()
    {
        return this.allowedPrograms;
    }
    public void setAllowedPrograms(ArrayList<Program> programs)
    {
        this.allowedPrograms = programs;
    }

    //Allowed Resources
    public void setAllowedResources(ArrayList<Resource> resources)
    {
        this.allowedResources = resources;
    }
    public ArrayList<Resource> getAllowedResources()
    {
        return this.allowedResources;
    }

    public boolean hasProgramPermissions(Program program)
    {
        return this.getAllowedPrograms() != null &&
                !this.getAllowedPrograms().isEmpty() && 
                this.getAllowedPrograms().contains(program);
    }

    public boolean hasResourcePermissions(Resource resource)
    {
        return this.getAllowedResources() != null &&
                !this.getAllowedResources().isEmpty() && 
                this.getAllowedResources().contains(resource);
    }

    //Methods
    @Override
    public String toString()
    {
        String user = this.getName() + "\n";

        user += "Recursos: \n";
        for(Resource r : this.getAllowedResources())
            user += "+ " + r.getName() + "\n";

        user += "Programas: \n";
        for(Program p : this.getAllowedPrograms())
            user += "- " + p.toString() + "\n";

        return user;
    }
}
