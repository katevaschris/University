package unipi.katevas;
public class Reptiles extends Animal
{
    public Reptiles(String Name)
    {
        super(Name);
    }
    public Reptiles(int Number)
    {
        super(Number);
    }
        
    public static void main(String[] args)
    {
        String Name = "Reptiles";
        int Number=1;
        Animal Reptiles = new Animal(Name);
        Animal NReptiles = new Animal(Number);
        Reptiles.PrName();
        NReptiles.PrNumber(); 
    }
}