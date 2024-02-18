package DataStructure;

class Node
{

    boolean isEndOfWord;
    Node[] alphabets = new Node[26];

    Node()
    {

        isEndOfWord = false;
        for (int i =0; i<26; i++)
        {
            alphabets[i] = null;
        }

    }
}



public class Trie {

    static Node root_node;
    public static void main(String[] args) {

        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        root_node = new Node();


        for (int i = 0; i < keys.length ; i++)
            insert(keys[i]);


        if(search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these"))
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their"))
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw"))
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }


    public static void insert(String data)
    {
        Node node = root_node;
        char []key = data.toCharArray();
        for (int i =0 ; i < key.length ; i++)
        {
            if(node.alphabets[key[i]-'a'] == null)
            {
                node.alphabets[key[i]-'a']=new Node();

            }
            node = node.alphabets[key[i]-'a'];
        }

        node.isEndOfWord = true;

    }

    public static boolean search(String key)
    {
      if(key.length()==0)
            return false;

      Node node = root_node;

      for (int i = 0; i < key.length(); i++)
      {
          if(node.alphabets[key.charAt(i) - 'a'] == null )
              return false;

          node = node.alphabets[key.charAt(i) - 'a'];

      }

      return (node!=null && node.isEndOfWord) ;

    }

}
