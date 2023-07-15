import java.util.*;
public class empp_leave{

    int empno;
    String empname;
    double basic;
    int total_leave;
    double DA, HRA, gross_sal, gross;
    int leaves;
    
int extra_days;    
double cut;

    void input(int i)
    {
        empno=i;
        DA=(basic*120)/100;
        HRA=(basic*20)/100;
        gross_sal=(DA+HRA+basic);
        gross=gross_sal;
        total_leave=12;
    }
    void display(int days)
    {
        System.out.println(" Employee_number:  "+empno+"   ");
        System.out.println(" Employee_name:  "+empname+"   ");
        System.out.println(" Employee_salary:  "+basic);
        DA=(basic*120)/100;
        HRA=(basic*20)/100;
        gross_sal=(DA+HRA+basic);
        gross=gross_sal;
        System.out.println(" Employee_gross_salary:  "+gross_sal+"   ");
        total_leave=12;
        if(days<=total_leave)
    {
        System.out.println(" Leave with pay");

        total_leave=total_leave-days;
        System.out.println(" Remaining leaves:  "+total_leave);
        System.out.println(" Final_salary:  "+gross_sal+"   ");
    }
        else
    {
        extra_days=days-total_leave;
        total_leave=0;
        cut=basic*extra_days/30;
        gross_sal=gross_sal-cut;
        System.out.println(" Leave with pay");
        System.out.println(" Remaining leaves:  "+total_leave);
        System.out.println(" Leave without pay");
        System.out.println(" Number of Leaves without pay:  "+extra_days);
        System.out.println(" Deduct_salary:  "+cut+"   ");
        System.out.println(" Final_salary:  "+gross_sal+"   ");
    }
    }     public static void clear()
{
    System.out.println("\033\143");
}

    static void leave_app(empp_leave obj)
    {         clear();
        Scanner sc=new Scanner(System.in);
        System.out.print(" Enter the days of leave : ");

     obj.leaves = sc.nextInt();   
     obj.display(obj.leaves);
    }
    static void table(empp_leave[] obj,int n)
    {
        System.out.println("\n\n S_no.\t"+"Employee_Name\t"+"Gross_Salary\t"+"Remaining Leaves\t"+"Next_month_pay\n\n");
        for(int i=0;i<n;i++)
        {
            System.out.println("  "+obj[i].empno+"    \t"+obj[i].empname +"\t\t"+obj[i].gross+"    \t        "+obj[i].total_leave+"       \t   "+obj[i].gross_sal);
        }
    }

    public static void main(String [] args)
    {         clear();
        empp_leave[] obj=new empp_leave[100];         Scanner sc=new Scanner(System.in);         char scan;         int i=0;         do
    {
        obj[i]=new empp_leave();
        clear();
        System.out.println(" Employee No."+(i+1)+" :--");
        System.out.print(" Enter the name of employee : ");
        obj[i].empname=sc.next();
        System.out.print(" Enter the salary of employee : ");
        obj[i].basic=sc.nextDouble();
        System.out.print(" Do You Want To Enter Further Record? (Y/N) : ");

         scan=sc.next().charAt(0);
        obj[i].input(i+1);
        i++;
    }while(scan=='Y'||scan=='y');
        String emp;int ch=0;
        do {             clear();
        System.out.println(" Application for leave ");
        System.out.print("\n Enter the Name of Employee : ");
        emp=sc.next();
        for(int j=0;j<i;j++)
        {                 ch=0;
            if(emp.equals(obj[j].empname))
        {
            leave_app(obj[j]);
            break;
        }
            else                     ch=1;
        }
        if(ch==1)
            System.out.println(" Employee Not Found");
            System.out.print("\n Do You Want To Apply for Another Leave Application? (Y/N) : ");
        scan=sc.next().charAt(0);         }
        while(scan=='Y'||scan=='y');
        clear();
        table(obj,i);

System.out.println("\n\n\n");
    }
}
