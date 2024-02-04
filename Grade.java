import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of courses:");
        int n=sc.nextInt();
        System.out.println("Enter the marks obtained out of 100:");
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=sc.nextInt();
        }
       System.out.println("Total Marks Obtained:"+sum);
       int avg=sum/n;
       System.out.println("Average mark:"+avg+"%");
       System.out.print("Your Grade is:");
        if(avg>=90){
            System.out.println(" O - Grade");
        }
        else if (avg>=80 && avg<90) {
            System.out.println(" A+ - Grade");
        }
        else if (avg>=70 && avg<80) {
            System.out.println(" A - Grade");
        }
        else if (avg>=60 && avg<70) {
            System.out.println(" B+ - Grade");
        }
        else if (avg>=50 && avg<60) {
            System.out.println(" B - Grade");
        }
        else if (avg>=40 && avg<50) {
            System.out.println(" C - Grade");
        }
        else if (avg<40) {
            System.out.println(" Sorry You Have Failed...");
        }
        }
    }

