import java.util.*;

class wspolrzedne {

    Random liczba=new Random();
    double x=0,y=0;

    public void generuj(){
        x=liczba.nextDouble();
        y=liczba.nextDouble();

    }

    public double obliczDystans(){
        return Math.sqrt((x * x) + (y * y));
    }

}

class Start{


        public static void main(String args[] ){
        int i=100000000;
        double wszystkieProby=0.0,trafienia=0.0;

        for(int j=0;j<i;j++){
            wspolrzedne costam= new wspolrzedne();
            costam.generuj();

            if(costam.obliczDystans()<=1.0){
                trafienia++;
            }
            wszystkieProby++;
        }
       // System.out.println("trafienia to: "+trafienia);
       // System.out.println("proby: "+wszystkieProby);


        double wynik=trafienia/wszystkieProby*4.0;
        System.out.println("Wynik to: "+wynik);

      }
}