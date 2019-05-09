import java.util.HashMap;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Poisson {

    Random liczba=new Random();

  public   double u=0,y=0;
  public  double p,q,s;
  public int k=0;
  public   final static double lambda=4.0;
    Poisson(){
        q=Math.exp(-lambda);
        p=q;
        s=q;
    }
    public void generuj(){
        u=liczba.nextDouble();

    }



}
class liczenie{
    public double rozkladPoissona(double liczba){
        double silnia=1;
        double cosinnego=liczba;

        while(liczba>1){


            silnia*=liczba;
            liczba--;
        }

        return Math.pow(4,cosinnego)*Math.exp(-4)/silnia;

    }
}

class Start {


    public static void main(String args[] ) throws FileNotFoundException{
        HashMap<Integer,Integer> mapa=new HashMap<Integer,Integer>();
        int N=1000000;
        double n=1000000;
        Integer liczba=new Integer(1);

      for(int i=0;i<N;++i){
          Poisson rozklad=new Poisson();
          rozklad.generuj();
          while(rozklad.u>rozklad.s){
              rozklad.k++;
              rozklad.p*=rozklad.lambda/rozklad.k;
              rozklad.s+=rozklad.p;
          }

          if(mapa.containsKey(rozklad.k)){
              int cos=mapa.get(rozklad.k);
              cos++;
              mapa.put(rozklad.k,cos);
          }
          else{
              mapa.put(rozklad.k,1);
          }

      }
        PrintWriter zapis = new PrintWriter("poisson.txt");
      for(int i=0;i<15;++i){
          if(mapa.containsKey(i)) {
              zapis.println(i+" "+ (mapa.get(i))/n);

          }
      }
        zapis.close();



        liczenie nowy=new liczenie();
        PrintWriter zapis2 = new PrintWriter("FunkcjaPoisson.txt");

        for(int i=0;i<15;++i){
            if(mapa.containsKey(i)) {
                zapis2.println(i+" "+nowy.rozkladPoissona(i));

            }
        }
        zapis2.close();


    }
}