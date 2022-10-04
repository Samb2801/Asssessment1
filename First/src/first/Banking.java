package first;



import java.util.Scanner; 
class Bank {  
	
	Scanner sc = new Scanner(System.in);
    private String accno;  
    private String name;  
    private String acc_type;  
    private long balance;  
      
   
    public boolean transfer_Amount(String sec_Acc ) {
   	 long amt;  
        System.out.println("Enter the amount you want to Transfer: ");  
        amt = sc.nextLong(); 
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after Transfer amount: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
        } 
        
        System.out.println("After receiving amount account details");
        if (accno.equals(sec_Acc)) {  
   		 balance = balance + amt; 
   		 showAccount();
            return (true);  
        }  
        return (false);
        
   }
    public boolean transfer_Amount1(String sec_Acc ) {
    	long amt = 0;
    	 if (accno.equals(sec_Acc)) {  
    		 balance = balance + amt; 
    		 showAccount();
             return (true);  
         }  
         return (false);  
         
       }
    
    public boolean searching(String ac_no) {  
        if (accno.equals(ac_no)) {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    }  
    
    public void withdrawal_Amount() {  
        long amt;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amt = sc.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
        }  
    }
    
    public void openNewAccount() {  
        System.out.print("Enter Account No: ");  
        accno = sc.next();  
        System.out.print("Enter Account type: ");  
        acc_type = sc.next();  
        System.out.print("Enter Name: ");  
        name = sc.next();  
        System.out.print("Enter Balance: ");  
        balance = sc.nextLong();  
    }  
   
    public void showAccount() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + accno);  
        System.out.println("Account type: " + acc_type);  
        System.out.println("Balance: " + balance);  
    }  
 
    public void deposit() {  
        long amt;  
        System.out.println("Enter the amount you want to deposit: ");  
        amt = sc.nextLong();  
        balance = balance + amt;  
    }  
    
}  
public class Banking {  
    public static void main(String arg[]) {  
        Scanner sc = new Scanner(System.in);  
         
        Banking b =new Banking();
        System.out.print("How many new account do you want to create: ");  
        int n = sc.nextInt();  
        Bank C[] = new Bank[n];  
        for (int i = 0; i < C.length; i++) {  
            C[i] = new Bank();  
            C[i].openNewAccount();  
        }  
 
        int ch;  
        do {  
        	System.out.println("\n***Welcome***");
            System.out.println("\n *IDFC Banking Application*");  
            System.out.println("1. Display details of account  \n 2. Search account \n 3. Deposit Amount \n 4. Withdraw Amount \n 5. Transfer Amount \n 6.Exit ");  
            System.out.println("Enter your choice: ");  
            ch = sc.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (int i = 0; i < C.length; i++) {  
                            C[i].showAccount();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Enter account no. you want to search: ");  
                        String ac_no = sc.next();  
                        boolean found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].searching(ac_no);  
                            if (found) {  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account not found..!!");  
                        }  
                        break;  
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].searching(ac_no);  
                            if (found) {  
                                C[i].deposit();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account not found..!!");  
                        }  
                        break;  
                    case 4:  
                        System.out.print("Enter Account No : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].searching(ac_no);  
                            if (found) {  
                                C[i].withdrawal_Amount();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break; 
                    case 5:
                    	System.out.print("Enter Account No : ");  
                        ac_no = sc.next();
                        found = false;
                        System.out.print("Enter Account No to which do you want to transfer amount : ");  
                        String sec_Acc = sc.next();
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].searching(ac_no);  
                            if (found) {  
                                C[i].transfer_Amount(sec_Acc);  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        
       
                        
                        break;
                    case 6:  
                        System.out.println("See you soon...");  
                        break;  
                }  
            }  
            while (ch != 6);  
        }  
    }