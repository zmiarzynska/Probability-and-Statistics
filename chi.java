import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import static org.apache.commons.math3.special.Gamma.trigamma;

public class chi{
    int N=3;
    double n=3;
    Random liczba=new Random();

 public double boxMuller(){
     double x = liczba.nextDouble();;
     double y = liczba.nextDouble();

     return Math.sqrt(-2*Math.log(x))*Math.cos(2*Math.PI*y);
 }



   public double chiMuller()
    {
        double y = 0;

        for(int i = 0; i < N; i++){
            double x = boxMuller();
            y = y + (x*x);
        }
        return y;
    }

    double gestosc(double x)
    {
        return (Math.pow(x/2,(n/2)-1)*Math.exp(-x/2))/(2*trigamma(n/2));

    }

}



class Start {


    public static void main(String args[] ) throws FileNotFoundException {
        chi obiekt=new chi();
        double zmienna;
        PrintWriter zapis = new PrintWriter("chi.txt");
        for(int i=0;i<100;++i){
                zmienna=obiekt.chiMuller();
                zapis.println(zmienna+ " "+ obiekt.gestosc(zmienna));


        }
        zapis.close();

    }
}
