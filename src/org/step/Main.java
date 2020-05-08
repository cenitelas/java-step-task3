package org.step;

import java.io.IOException;
import java.security.KeyPair;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer,LocaleImpl> locales = new HashMap<Integer, LocaleImpl>();
        locales.put(1,new LocaleImpl(new Locale("ru","RU")));
        locales.put(2,new LocaleImpl(new Locale("en","US")));

        Integer userInput = 0;
        LocaleImpl locale = null;

        do{
            String ru = locales.get(1).getValue("language");
            String en = locales.get(2).getValue("language");

            System.out.printf("1. - %s\n",ru);
            System.out.printf("2. - %s\n",en);
            System.out.printf("0. - Выход\\Exit\n");

            System.out.printf(">");
            Scanner in = new Scanner(System.in);
            userInput = in.nextInt();

            switch (userInput){
                case 1:
                case 2:
                    locale = locales.get(userInput);
                    userInput=0;
                    break;
                case 0:break;
                default:
                    System.out.println("Нет такого пункта меню.");
                    break;
            }
        }while (userInput>0);

        System.out.println("");

        Map<String, String> quests = new HashMap<>();
        Enumeration<String> keys = locale.getAllKeys();

        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            quests.put(key,locale.getValue(key));
        }

        do{
            int index = 0;
            for(String key : quests.keySet()){
                if(quests.containsKey("quest"+ ++index))
                    System.out.printf("%d. - %s\n",index,quests.get("quest"+index));
            }
            System.out.printf("0. - Выход\\Exit\n");
            System.out.printf(">");
            Scanner in = new Scanner(System.in);
            userInput = in.nextInt();
            index=0;
            switch (userInput){
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.printf("\n%s\n", quests.get("answer" + userInput));
                    System.out.println("Продолжить...");
                    in.nextLine();
                    in.nextLine();
                case 0:break;
                default:
                    System.out.println("Нет такого пункта меню.");
                    break;
            }
            System.out.println("");
        }while (userInput>0);

    }
}
