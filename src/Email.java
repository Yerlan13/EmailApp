import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String deparment;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "lovecompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


        this.deparment = setDepartment();


        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);


        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + deparment + "." + companySuffix;

    }

    private String setDepartment() {
        System.out.print("New worker: "+ firstName + ". \n DEPARTMENT CODES:\n 1 For Sales\n 2 For Development\n 3 For Accounting\n 4 For None");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "account";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUWYZ0123456789";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return " DISPLAY NAME: " + firstName + " " + lastName +
                "\n COMPANY EMAIL: " + email +
                "\n MAILBOX CAPACIRY: " + mailboxCapacity + " mb";
    }
}