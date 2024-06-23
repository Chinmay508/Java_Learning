import java.util.*;
public class Wordwise
{
    // Class level variable to accept sentence
    String str;
    Wordwise()
    {
        this.str = "I am Bob";
    }

    // Accepting sentence from user
    void readsent()
    {
        System.out.println("Enter a sentence:");
        Scanner sc = new Scanner(System.in);
        this.str = sc.nextLine();
    }

    // Finds frequency of vowels
    int freq_vowel(String w)
    {
        int count = 0;
        for(int i = 0;i < w.length();i++)
        {
            char x = w.charAt(i);
            x = Character.toLowerCase(x);
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
            {
               count++;
            }
        }
        return count;
    }
    
    /* Arranges the words in sentences
     * And finds frequency of vowels in words
     */
    public void arrange() 
    {
        String[] words = new String[str.length()];
        int index = 0;
        for(int i = 0; i < str.length(); i++)
        {
            words[i] = "";
            for(int j = index; j < str.length(); j++)
            {
                index++;
                if(str.charAt(j) == ' ')
                break;
                words[i] = words[i] + str.charAt(j);
                
            }
        }

        for(int i = 0; i < words.length; i++)
        {
            if(words[i] == "")
            break;

            int freq = this.freq_vowel(words[i]);
            System.out.println(words[i] + "\n frequency:" + freq);
        }
    }
    public static void main(String[] args) 
    {
        Wordwise obj = new Wordwise();
        obj.readsent();
        obj.arrange();
    } // main closed
} // class closed
