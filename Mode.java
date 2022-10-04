package MiniProject;

package Driver.java;

import java.io.IOException;
import java.util.*;

public class Mode 
{
    Scanner sc = new Scanner(System.in);
    String email;
    String password;

    private static boolean hasNum = false;
    private static boolean hasUpper = false;
    private static boolean hasLower = false;
    private static boolean hasEmail = false;
    private static boolean haslength = false;

    Dictionary dict = new Dictionary();

    Mode()
    {
        // Default constructor
    }

    public void getEmail()
    {
        // Getting email id
        System.out.print("\nEnter the email : ");
        email = sc.nextLine();
        validateEmail(email); 
    }

    public void getPassword()
    {
        // Getting password
        System.out.print("\nEnter the password : ");
        // char[] text = password.toCharArray();
        // for(char c : text)
        // {
        //     c += '*';
        //     System.out.print(c);
        // }
        password = sc.nextLine();
        validatePassword(password);
    }

    // Method to check validation of email
    public void validateEmail(String validate)
    {
        while(!hasEmail)
        {
            for(int i=0; i<validate.length(); i++)
            {
                // Email must contains @ and .com
                if(email.charAt(0)!='@' && email.contains("@") && email.endsWith(".com"))
                {
                    hasEmail = true;
                }
            }

            if(hasEmail)
            {
                System.out.print("\n");
            }
            else if(!hasEmail)
            {
                // if false then again call for email
                System.out.print("\nEmail must contains @ or .com in your email.\n");
                getEmail();               
            }

        }        
    }

    // Method to check validation of password
    public void validatePassword(String validate)
    {
        char c ;

        while(!(haslength && hasUpper && hasUpper && hasLower && hasNum))
        {
            for(int i=0; i<validate.length(); i++)
            {
                c = validate.charAt(i);

                if(validate.length() > 8)   // Password must be greater than 8 characters
                {
                    haslength = true;
                }
                if(Character.isUpperCase(c))  // Password must contains atleast 1 uppercase letter.
                {
                    hasUpper = true;
                }
                if(Character.isLowerCase(c)) // Password must contains atleast 1 lowercase letters.
                {
                    hasLower = true;
                }
                if(Character.isDigit(c))  // Password must contains atleast 1 digit.
                {
                    hasNum = true;
                }  
            }

            if(haslength && hasUpper && hasUpper && hasLower && hasNum)
            {
                System.out.print("\nYour password and email is strong.\n");
            }
                
            if(!haslength)
            {
                System.out.print("\nPassword must contains 8 letters\n");
                getPassword();
            }
            else if(!hasUpper)
            {
                System.out.print("\nPassword must contains atleast 1 uppercase letter.\n");
                getPassword();
            }
            else if(!hasLower)
            {
                System.out.print("\nPassword must contains atleast 1 lowercase letters.\n");
                getPassword();
            }
            else if(!hasNum)
            {
                System.out.print("\nPassword must contains atleast 1 digit.\n");
                getPassword();
            }
        }
    }

    // Method for choosing the mode
    public void mode() throws IOException
    {
        char choice;
        do
        {
            // Menu for mode of login
            System.out.print("\n>>>>>>>>>>MODE>>>>>>>>>>");
            System.out.print("\n\tA.Administration Mode");
            System.out.print("\n\tU.User Mode");
            System.out.print("\n\tX.EXIT");
            System.out.print("\nChoose the mode : ");
            choice = sc.next().charAt(0);
            System.out.print("\n");
            sc.nextLine();

            switch(choice)
            {
                case 'X' : case 'x' : System.out.print("\nYOU HAVE BEEN SUCCESSFULLY LOGGED OUT.");
                                      System.out.print("\nTHANK YOU FOR USING THE DICTIONARY, GOOD-BYE!\n");
                                      System.exit(0);

                // For admin mode
                case 'A' : case 'a' : System.out.print("\n**************WELCOME TO ADMINISTRATION MODE**************");
                                      admin();
                break;

                // For user mode
                case 'U' : case 'u' : System.out.print("\n**************WELCOME TO USERMODE**************");
                                      user();
                break;

                default : System.out.print("\nIncorrect input, Try again.\n");    
            }     
        }while(true);
    }

    void adminMenu() 
    {
        System.out.print("\n>>>>>>>>>>>>>>>>>>>>WELCOME TO DICTIONARY>>>>>>>>>>>>>>>>>>>>");
        System.out.println("\n");
        System.out.println("'I'. FOR INSERTING NEW WORD-MEANING");
        System.out.println("'F'. FOR FINDING A MEANING");
        System.out.println("'D'. DELETE WORDS IN THE DICTIONARY");
        System.out.println("'U'. UPDATE WORDS IN THE DICTIONARY");
        System.out.println("'V'. TO VIEW A WORDS IN THE DICTIONARY");
        System.out.println("'E'. TO VIEW THE ENTIRE DICTIONARY");
        System.out.println("'T'. TO VIEW THE ENTRIES OF WORDS IN THE DICTIONARY");
        System.out.println("'X'. EXIT");

    }

    // Method for admin mode
    public void admin() throws IOException 
    {
        boolean isCorrect = false;
        
        System.out.print("\n\t**************LOGIN AS ADMIN**************");
        System.out.println();

        while(isCorrect!=true)
        {
            getEmail(); // getting email 
            getPassword(); // getting password

            if(email.equals("Admin2464@gmail.com")) // Checking email 
            {
                if(password.equals("AdminPass143")) // Checking password
                {
                    System.out.print("\nLogging in.");
                    for(int i = 0; i < 5; i++)
                    {
                        System.out.print(".");
                        try 
                        {
                            Thread.sleep(500);
                        } 
                        catch(InterruptedException e) 
                        {
                           System.out.println(e);
                        }
                    }
                    System.out.print("\nYou are successfully logged in as admin.\n");
                    isCorrect = true;
                }
                else
                {
                    System.out.print("\nPassword is worong! ");  
                }
            }
            else
            {
                int exit = 0;
                System.out.print("\nEmail and password are wrong!");

                // To redirected to the menu if they don't know the email and password
                System.out.print("\nYou want to continue? (0-NO / 1-YES) : "); 
                exit = sc.nextInt(); 
                sc.nextLine();
                if(exit == 1)
                {
                   continue;
                }
                else if(exit == 0)
                {
                    getEmail();
                    getPassword();
                }
            }
        }

        if(isCorrect==true)
        {
            // After successfully logged in.
            do
            {
                char option;

                // Menu for administration mode
                adminMenu();   

                System.out.println();
                System.out.print("Enter an option : ");
                option=sc.next().charAt(0);
                sc.nextLine();
                System.out.println();

                switch(option)
                {
                    case 'I' : case 'i' : dict.getWordMeaning();
                    break;

                    case 'F' : case 'f' : dict.findMeaning(); 
                    break;

                    case 'D' : case 'd' : dict.deleteWordMeaning();
                    break;

                    case 'U' : case 'u' : dict.updateWordTree();
                    break;

                    case 'V' : case 'v' : dict.displayWordTree(); 
                    break;

                    case 'E' : case 'e' : dict.displayWordList(); 
                    break;

                    case 'T' : case 't' : dict.getNodeCount(); 
                    break;

                    case 'X': case 'x' : System.out.print("\nYOU HAVE BEEN SUCCESSFULLY LOGGED OUT AS ADMIN.");
                                         System.out.print("\nTHANK YOU FOR USING THE DICTIONARY, GOOD-BYE!\n");
                                         mode();

                    default: System.out.println("\nIncorrect input, try again.\n");
                }
            }while(true);
        }
        else 
        {
            // If log in was unsuccesful then redirected to the mode menu
            mode();
        }
    } 

    void signin()
    {
        System.out.print("\n\t**************SIGN IN AS USER**************");
        getEmail(); 
        getPassword();

        System.out.print("\nYou are successfully sign in.");
    }

    void userMenu() 
    {
        System.out.print("\n>>>>>>>>>>>>>>>>>>>>WELCOME TO DICTIONARY>>>>>>>>>>>>>>>>>>>>\n");
        System.out.println("F. FOR FINDING A MEANING");
        System.out.println("V. TO VIEW A WORDS IN THE DICTIONARY");
        System.out.println("E. TO VIEW THE ENTIRE DICTIONARY");
        System.out.println("T. TO VIEW THE ENTRIES OF WORDS IN THE DICTIONARY");
        System.out.println("X. EXIT");
    }

    // Method for user mode
    public void user() throws IOException
    {
        boolean isCorrect = false;

        // Sigining as user
        signin();

        String userEmail = email;
        String userPassword = password;        

        // Log in as user
        System.out.print("\n\t**************LOGIN AS USER**************\n");
        System.out.println();
        while(isCorrect!=true)
        {
            getEmail();      // Getting email
            getPassword();  // Getting password

            if(email.equals(userEmail))
            {
                if(password.equals(userPassword))
                {
                    System.out.print("\nLogging in.");
                    for(int i = 0; i < 5; i++)
                    {
                        System.out.print(".");
                        try 
                        {
                            Thread.sleep(500);
                        } 
                        catch(InterruptedException e) 
                        {
                           System.out.println(e);
                        }
                    }
                    System.out.print("\nYou are successfully logged in.\n");
                    isCorrect = true;
                }
                else
                {
                    System.out.print("\nPassword is worong! ");  
                }
            }
            else
            {
                int exit = 0;
                System.out.print("\nEmail and password are wrong!");
                System.out.print("\nYou want to continue? (0-NO / 1-YES) : ");
                exit = sc.nextInt(); 
                sc.nextLine();
                if(exit == 1)
                {
                   continue;
                }
                else if(exit == 0)
                {
                    getEmail();
                    getPassword();
                }
               
            }
        }

        if(isCorrect==true)
        {

            do
            {
                char option;

                // Menu for user mode
                userMenu();

                System.out.println();
                System.out.print("Enter an option : ");
                option = sc.next().charAt(0);
                sc.nextLine();

                switch(option)
                {
                    case 'F' : case 'f' : dict.findMeaning(); 
                    break;

                    case 'V' : case 'v' : dict.displayWordTree(); 
                    break;

                    case 'E' : case 'e' : dict.displayWordList(); 
                    break;

                    case 'T' : case 't' : dict.getNodeCount(); 
                    break;

                    case 'X' : case 'x' : System.out.print("\nYOU HAVE BEEN SUCCESSFULLY LOGGED OUT AS USER.");
                                          System.out.print("\nTHANK YOU FOR USING THE DICTIONARY, GOOD-BYE!\n");
                                          mode();

                    default: System.out.println("\nIncorrect input, try again.\n");
                }
            }while(true);
        }
        else
        {
            mode();
        }
    } 
}

