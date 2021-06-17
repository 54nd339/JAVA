import java.util.*;
class TTT{
    static Scanner sc=new Scanner(System.in);
    static TTT ob=new TTT();
    static int ctr=0;
    static String p1="",p2="";
    void print(String ar[][]){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                System.out.print(ar[i][j]+"\t");
            System.out.println();
        }
        System.out.println();
    }
    String check(String ch){
        String win="";
        if(ch.equals("  X"))      {ctr++;win=p1;}
        else if(ch.equals("  O")) {ctr++;win=p2;}
        return win;
    }
    String check(String ar[][]){
        String win="";
        if(ar[0][0].equals(ar[1][1])&&ar[1][1].equals(ar[2][2]))
            win=ob.check(ar[1][1]);
        else if(ar[0][2].equals(ar[1][1])&&ar[1][1].equals(ar[2][0]))
            win=ob.check(ar[1][1]);
        else if(ar[0][2].equals(ar[1][2])&&ar[1][2].equals(ar[2][2]))
            win=ob.check(ar[1][2]);
        else if(ar[0][1].equals(ar[1][1])&&ar[1][1].equals(ar[2][1]))
            win=ob.check(ar[1][1]);
        else if(ar[0][0].equals(ar[1][0])&&ar[1][0].equals(ar[2][0]))
            win=ob.check(ar[1][0]);
        else if(ar[1][0].equals(ar[1][1])&&ar[1][1].equals(ar[1][2]))
            win=ob.check(ar[1][1]);
        else if(ar[0][0].equals(ar[0][1])&&ar[0][1].equals(ar[0][2]))
            win=ob.check(ar[0][1]);    
        else if(ar[2][0].equals(ar[2][1])&&ar[2][1].equals(ar[2][2]))
            win=ob.check(ar[2][1]);
        else
            win="none";
        return win;
    }
    void input(String ar[][],String p){
        int r=0,c=0;char ch=' ';
        if(p.equals(p1))
        ch='X';
        else
        ch='O';
        System.out.println(p+"'s Turn :");
        while(true){
            System.out.print("Enter your row no. : ");
            r=sc.nextInt();
            System.out.print("Enter your column no. : ");
            c=sc.nextInt();
            if(r>2||c>2)
            {System.out.println("Wrong Input!Try Again : ");continue;}
            System.out.println();
            if(ar[r][c].equals("  O")||ar[r][c].equals("  X"))
                System.out.println("Already Used. Try Again : ");
            else {
                ar[r][c]="  "+ch;break;
            }
        }
    }
    public static void main(String args[]){
        String ar[][]=new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                ar[i][j]="\""+i+","+j+"\"";
        }
        while(true){
            System.out.print("Enter The name of player 1 : ");
            p1=sc.next();
            System.out.print("Enter The name of player 2 : ");
            p2=sc.next();
            if(p1.equalsIgnoreCase(p2)){
                System.out.println("Both names are same. Plz Re-Enter The names : ");
                continue;
            }
            else break;
        }
        System.out.println();
        ob.print(ar);
        for(int i=0;i<9;i++){
            String win="";
            if(i%2==0)
                ob.input(ar,p1);
            else
                ob.input(ar,p2);
            ob.print(ar);
            if(i>3)
            win=ob.check(ar);
            if(win.equals(p1)||win.equals(p2)){
                System.out.println("Winner : "+win.toUpperCase());
                break;
            }
        }
        if(ctr==0)System.out.println("No one Wins.");
    }
}