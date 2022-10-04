package MiniProject;

import java.util.*;
import java.io.IOException;

//Class of the dictionary containing the array of 26 trees
public class Dictionary
{
    Scanner read = new Scanner(System.in);

    // Array of WordTree 
    public WordTree WordList[] = new WordTree[26];
    public int ListSize[];

    public Dictionary()
    {
        ListSize = new int[26];

        for(char namecount=97;namecount<=122;namecount++)  
        {
            String name = namecount+"";
            WordList[namecount-97]=new WordTree(name);
            ListSize[namecount-97]=0;
        }
    }

    // The method for adding new word and meaning to the dictionary
    public void getWordMeaning() throws IOException
    {
        String word,meaning;
        System.out.print("Enter Word : ");
        word = read.nextLine();
        System.out.print("Enter its meaning : ");
        meaning = read.nextLine();
        WordList[getIndex(word)].addEntry(word,meaning);
        ListSize[getIndex(word)]++;

    }

    public void deleteWordMeaning() throws NullPointerException, IOException
    {
        String word;
        System.out.print("Enter word : ");
        word = read.nextLine();
        WordList[getIndex(word)].deleteEntry(word);
        ListSize[getIndex(word)]--;
        System.out.print("\nDeleting.");
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
        System.out.println("\n" + word + " deleted.");
    }

    //The method for finding the meaning in the dicitonary
    public void findMeaning() throws NullPointerException, IOException
    {
        String word;
        System.out.print("Enter word : ");
        word=read.nextLine();
        System.out.print("\nSearching.");
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
        System.out.println("\n" + word + " : " + WordList[getIndex(word)].findEntry(word));
    }

    //The method for displaying the correct words for a letter
    public void displayWordTree() throws java.io.IOException
    {
        char letter;
        System.out.print("Enter Letter : ");
        letter = read.next().charAt(0);
        if(letter>=65&&letter<=90)
        {
            System.out.println("\nThe words starting with "+letter+" are as follows : ");
            WordList[letter-65].displayTree();
        }
        else if (letter>=97&&letter<=122)
        {
            System.out.println("The words starting with "+letter+" are as follows : ");
            WordList[letter-97].displayTree();
        }
        else
        {
          System.out.println("\nNot a valid input\n");
        }
    }

    // Displays the entire dictionary
    public void displayWordList()
    {
        System.out.print("\nDisplaying.");
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
      System.out.println("\nThe contents of the Dictionary are : \n");
      for (int index=0;index<=25;index++)
        if (ListSize[index]>0)
          WordList[index].displayTree();     
    }

    // The method for updating the meaning of existing words
    public void updateWordTree()
    {
        String word;
        String word2;

        System.out.print("\nEnter word you want to update the meaning of : ");
        word = read.nextLine();
        System.out.print("\nEnter new meaning of that word : ");
        word2 = read.nextLine();

        WordList[getIndex(word)].updateEntry(word,word2);
        System.out.print("\nUpdating.");
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
        System.out.println("\n" + word + " updated");

    }


    // Method of getting the number of entries in the dictionary
    public void getNodeCount() throws IOException
    {
        System.out.println();
        System.out.print("Enter a letter : ");
        char letter=read.next().charAt(0);
        if (letter>=65&&letter<=90)
           System.out.println("Entries for "+letter+": "+ListSize[letter-65]);
        else if (letter>=97&&letter<=122)
           System.out.println("Entries for "+letter+": "+ListSize[letter-97]);
        else
           System.out.println("\nInvalid input, try again!\n");   
    }

    // The method for getting the index of the word
    public int getIndex(String word)
    {
      int firstchar=word.charAt(0);
      if (firstchar>=65&&firstchar<=90)
         return (firstchar-65);
      else if (firstchar>=97&&firstchar<=122)
         return (firstchar-97);
      else
      {
        System.out.println("\nNot a valid input\n");
        return -1;
      }
    }
}
