/*
     Zadatak je kreirati program za ispis statistike bodova na tečaju. Program prima bodove [0-100] kao ulaz,
     na temelju čega ispisuje statistiku ocjena. Program se prekida kada korisnik unese broj -1. Brojevi koji
     nisu unutar intervala se ignoriraju pri izračunavanu.

     Prošireni program izračunava i prosjek bodova za bodove koji daju prolaznu ocjenu, te postotak prolaznosti
     ispita, ali i ocjenovnu distribuciju
     Prolazna ocjena postiže se osvajanjem najmanje 50 bodova. Pretpostavka je da korisnik uvijek unese barem
     jedan cijeli broj unutar intervala.
 */



import java.util.Scanner;

public class GradeDistribution {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter points totals, -1 stops:");
        //varijabla za pohranu broja osvojenih bodova, pri unosu cijelog broja iz intervala se poveaava za vrijednost
        //tog broja
        int sum=0;
        //brojač, pri unosu cijelog broja iz intervala se povecava za 1
        int count=0;
        ///varijabla za pohranu broja osvojenih PROLAZNIH [50-100] bodova
        int sumOfPassing=0;
        //brojač koji se povecava za 1 pri unosu cijelog broja iz intervala prolaznih bodova
        int countOfPassing=0;
        //varijable koje će pohranjivati * ovisno o osovjenim bodovima, te će biti dio distribucije ocjena
        String grade0="";
        String grade5="";
        String grade4="";
        String grade3="";
        String grade2="";
        String grade1="";
        
        while(true){
            String input = scanner.nextLine();
            int value = Integer.valueOf(input);
            //unos -1 prekida prograg
            if (value==-1){
                break;
            }

            if (value>=0 && value<=100){
                sum+=value;
                count++;
            }
            if (value>=50 && value<=100){
                sumOfPassing+=value;
                countOfPassing++;
            }
            //dio za ocjenovnu distribuciju, ovisno o broju bodova pored osvojene ocjene se dodaje *
            if (value>=0 && value<50){
                grade0=grade0+"*";
            }else if(value>=50 && value<60){
                grade1=grade1+"*";
            }else if(value>=60 && value<70){
                grade2=grade2+"*";
            }else if(value>=70 && value<80){
                grade3=grade3+"*";
            }else if(value>=80 && value<90){
                grade4=grade4+"*";
            }else if(value>=90 && value<=100){
                grade5=grade5+"*";
            }

        }
        //ispis prosjeka svih unesenih bodova unutar intervala [0-100]
        //koristimo tip double, pri izračunu prosjeka kao rezultat više nemamo cijeli broj
        System.out.println("Point average (all): "+(double)sum/count);
        //ispis prosjeka svih unesenih PROLAZNIH bodova unutar intervala [50-100]
        System.out.println("Point average (passing): "+(double)sumOfPassing/countOfPassing);
        //ispis postotka prolaznosti ispita
        System.out.println("Pass percentage: "+ ((double)countOfPassing/count)*100);
        //ispis distribucije ocjena
        System.out.println("Grade distribution: ");
        System.out.println("5: "+grade5);
        System.out.println("4: "+grade4);
        System.out.println("3: "+grade3);
        System.out.println("2: "+grade2);
        System.out.println("1: "+grade1);
        System.out.println("0: "+grade0);

    }
}
