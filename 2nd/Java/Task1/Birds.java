package unipi.katevas;
public class Birds extends Animal
{
    public Birds(String Name)
    {
        super(Name);
    }
    public Birds(int Number)
    {
        super(Number);
    }
    public static void main(String[] args)
    {
        String Name = "Birds";
        int Number=3;
        Animal Birds = new Animal(Name);
        Animal NBirds = new Animal(Number);
        Birds.PrName();
        NBirds.PrNumber();
    }
}