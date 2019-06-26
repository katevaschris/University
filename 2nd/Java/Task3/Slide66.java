class Slide66
{
    //Default type of class
    class A extends Slide66
    {
        int a = 0;
    }

    protected class B
    {
        //Nested class is going to be protected
    }

    public class C extends Slide66
    {
       int c = 2;
    }

    public static void main(String[] args)
    {
        Slide66.A obj = new Slide66.A();
        Slide66.C obj3 = new Slide66.C();
        System.out.println(Slide66.A.obj + Slide66.C.obj3);
    }
}