import imp.AddCollectionImp;
import imp.AddRemoveCollectionImp;
import imp.MyListImp;
import interfaces.AddCollection;
import interfaces.AddRemoveCollection;
import interfaces.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] words = input.readLine().split("\\s+");
        int wordsCount = Integer.parseInt(input.readLine());

        AddCollection addCollection = new AddCollectionImp();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollectionImp();
        MyList myList = new MyListImp();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();

        for (String word : words) {
            sb1.append(addCollection.add(word)).append(" ");
            sb2.append(addRemoveCollection.add(word)).append(" ");
            sb3.append(myList.add(word)).append(" ");
        }

        for (int i = 0; i < wordsCount; i++) {
            sb4.append(addRemoveCollection.remove()).append(" ");
            sb5.append(myList.remove()).append(" ");
        }

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
        System.out.println(sb4);
        System.out.println(sb5);
    }
}
