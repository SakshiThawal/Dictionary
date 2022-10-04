package MiniProject;

/* 
The WordTree class contains the construtors for the functionality
of the dictionary. 
It displays, finds, insert,update and deletes tree nodes.

*/

class TreeNode
{
    String Word;
    String Meaning;
    TreeNode Left;
    TreeNode Right;

    // Constructor of tree node taking two parameters
    public TreeNode(String Word,String Meaning)
    {
        this.Word = Word;
        this.Meaning = Meaning;
        this.Left = null;
        this.Right = null;
    }
}

// Class of WordTree
public class WordTree
{
    TreeNode Root;

    String Name;
    static int index;

    static
    {
       index = 0;
    }

    public WordTree(String Name)
    {
       this.Name = Name;
    }

    // Constructor for adding word into the tree
    public void addEntry(String Word,String Meaning)
    {
        Root = addNewNode(Root,Word,Meaning);
    }

    // Method for adding new node to the tree
    private TreeNode addNewNode(TreeNode node,String word,String meaning)
    {
        if (node==null)
            return new TreeNode(word,meaning);
        else if (node.Word.compareToIgnoreCase(word)<=0)
        {
            node.Left=addNewNode(node.Left,word,meaning);
            return node;
        }
        else
        {
            node.Right=addNewNode(node.Right,word,meaning);
            return node;
        }
    }

    // Construtor for finding an word and its meaning in a tree
    public String findEntry(String word) throws NullPointerException
    {
        TreeNode tempnode=new TreeNode("","");
        find(Root,word,tempnode);
        return tempnode.Meaning;
    }

    // Meaning for finding word and its meaning
    private void find(TreeNode node,String word,TreeNode temp) throws NullPointerException
    {
        try
        {
            if(node.Word.compareToIgnoreCase(word)==0)
            {
                temp.Word=node.Word;
                temp.Meaning=node.Meaning;       
                temp.Left=node.Left;
                temp.Right=node.Right;    
            }
            else if (node.Word.compareToIgnoreCase(word)>0)
                find(node.Right,word,temp);
            else if (node.Word.compareToIgnoreCase(word)<0)
                find(node.Left,word,temp);
        }
        catch(Exception e)
        {
            temp.Word=temp.Meaning="No match found";
            temp.Right=temp.Left=null;
        }
    }

    // Constructor for deleting word and its meaning in the tree
    public void deleteEntry(String word) throws NullPointerException
    {
      delete(Root,word);
      System.gc();
    }

    // Method for deleting word and its meaning
    private void delete(TreeNode node,String word) throws NullPointerException
    {
        try
        {
            if (node.Word.compareToIgnoreCase(word)==0)
                node.Word=node.Meaning="";
            else if (node.Word.compareToIgnoreCase(word)>0)
                delete(node.Right,word);
            else if (node.Word.compareToIgnoreCase(word)<0)
                delete(node.Left,word);
        }
        catch(Exception e)
        {
            System.out.println("No match found");
        }

    }

    // Constructor for updating the meanind
    public void updateEntry(String word, String newWord) throws NullPointerException
    {
        update(Root,word,newWord);
    }

    // Method for updating the menaing of the word
    private void update(TreeNode node,String word, String newWord) throws NullPointerException
    {
        try
        {
            if (node.Word.compareToIgnoreCase(word)==0)
                node.Meaning=newWord;
            else if (node.Word.compareToIgnoreCase(word)>0)
                update(node.Right,word,newWord);
            else if (node.Word.compareToIgnoreCase(word)<0)
                update(node.Left,word,newWord);
        }
        catch(Exception e)
        {
            System.out.println("No match found");
        }

    }

    // Constructor for displaying all the words in the tree
    public void displayTree()
    {
        display(Root);
    }

    // Method for displaying all the words in the tree
    private void display(TreeNode node)
    {
        if (node==null)
           return;
        else
        {
            display(node.Right);
            if (node.Word!="" || node.Meaning!="")
                System.out.println(node.Word+" : "+node.Meaning);
                display(node.Left);
        }
    }
}



