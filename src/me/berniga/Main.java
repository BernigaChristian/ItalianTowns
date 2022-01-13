package me.berniga;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scan=new Scanner(System.in);
    public static int searchTown(Town[] italianTowns)   throws  TownNotFoundException{
        System.out.print("\tType the name of the town: ");
        String data=scan.nextLine();
        for(Town t:italianTowns)
            if(t.getName().equalsIgnoreCase(data))  return t.getInhabitants();
        throw new TownNotFoundException();
    }

    public static ArrayList<String> searchByRange(Town[] italianTowns)  throws NoTownsInRangeException{
        ArrayList<String> towns=new ArrayList<String>();
        int[] num=new int[2];
        for(int i=0;i<2;i++) {
            System.out.print("\tType the number of inhabitants: ");
            num[i]=Integer.parseInt(scan.nextLine());
        }
        int min=Math.min(num[0],num[1]),max=Math.max(num[0],num[1]);
        for(Town t:italianTowns)
            if(t.getInhabitants()<max&&t.getInhabitants()>min)  towns.add(t.getName());
        if(towns.size()>0)  return towns;
        throw new NoTownsInRangeException();
    }

    public static String fiscalCode(Town[] italianTowns){
        String data="";
        System.out.print("\tType your surname: ");
        data+=(scan.nextLine().toUpperCase()+";");
        System.out.print("\tType your name: ");
        data+=(scan.nextLine().toUpperCase()+";");
        System.out.print("\tType your year of birth: ");
        data+=(scan.nextLine()+";");
        System.out.print("\tType your month of birth: ");
        data+=(scan.nextLine().toLowerCase()+";");
        System.out.print("\tType your day of birth: ");
        data+=(scan.nextLine()+";");
        System.out.print("\tType your gender: ");
        data+=(scan.nextLine().toUpperCase()+";");
        System.out.print("\tType your town of birth: ");
        data+=(scan.nextLine()+";");
        System.out.print("\tType your province of birth: ");
        data+=(scan.nextLine());
        String[] info=data.split(";");
        System.out.println(Arrays.toString(info));
        FiscalCode fiscalCode=new FiscalCode(info,italianTowns);
        return fiscalCode.toString();
    }

    public static void main(String[] args) {
	    Town[] italianTowns= new Town[8092];
        try {
            int i=0;
            Scanner scanner=new Scanner(new File("listacomuni.txt"));
            while(scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                italianTowns[i++]=new Town(data[0],data[1],data[2],data[3],data[4],data[5],data[6],Integer.parseInt(data[7]));
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
        System.out.println("OPTION LIST\n1) shows the number of inhabitants of a selected town\n2) shows the Towns that have the number of inhabitants between selected range\n");
        boolean option=true;
        //int choice;
        Scanner input=new Scanner(System.in);
        do{
            System.out.print("Type your choise: ");
            switch(Integer.parseInt(input.nextLine())){
                case 1:
                    try{
                        System.out.println("this town has "+searchTown(italianTowns)+" inhabitants");
                    }catch(TownNotFoundException e) {System.out.println(e);}
                    break;
                case 2:
                    try{
                        ArrayList<String> towns=searchByRange(italianTowns);
                        for(String town:towns)
                            System.out.println(town);
                    }catch(NoTownsInRangeException e) {System.out.println(e);}
                    break;
                case 3:
                    System.out.println(fiscalCode(italianTowns));
                    break;
                default:    option=false;
            }
        }while(option);
    }
}
