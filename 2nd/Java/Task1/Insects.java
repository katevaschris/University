package unipi.katevas;
public class Insects extends Animal
{
    public Insects(String Name)
    {
        super(Name);
    }
    public Insects(int Number)
    {
        super(Number);
    }
        
    public static void main(String[] args)
    {
        String Name = "Insects";
        int Number=2;
        Animal Insects = new Animal(Name);
        Animal NInsects = new Animal(Number);
        Insects.PrName();
        NInsects.PrNumber();
    }
}