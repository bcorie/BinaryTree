package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Corie and Thibault
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("words.txt");

        Scanner sc = new Scanner(file);
        String text = "";
        while(sc.hasNext()){ text = text + " " + sc.next(); }

        ArrayList<String> words = getWord(text);
        BinaryTree tree = new BinaryTree();
        System.out.println(words);
        for (String word : words) {
            tree.add(word); }
        System.out.println(tree);
    }

    public static ArrayList<String> getWord (String text){
        ArrayList<String> words = new ArrayList<>();
        text = text.toLowerCase();
        Scanner x = new Scanner(text);

        while (x.hasNext()) {
            String word = x.next();

            if (word.chars().count() > 3) {
                word = word.replace("-", "");
                word = word.replace(".", "");
                word = word.replace(",", "");
                word = word.replace(";", "");
                words.add(word);
            }
        }
        return words;
    }
}