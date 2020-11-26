public class Resource 
{
    private ResourceState status;
    private String name;

    //Constructor
    public Resource(String name) 
    {
        this.name = name;
        this.status = ResourceState.Waiting;
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
    
    //State
    public ResourceState getResourceStatus()
    {
        return this.status;
    }
    public void setResourceStatus(ResourceState status)
    {
        this.status = status;
        System.out.println("Recurso: " + this.name + " Estado: " + this.status);
    }
}
