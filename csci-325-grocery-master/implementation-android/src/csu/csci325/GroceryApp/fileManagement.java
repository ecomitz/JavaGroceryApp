package csu.csci325.GroceryApp;




import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class fileManagement {

    public static List populateListFromFile(String path)
    {
        List generatedList = new List(path);
        String nameOfItem;
        int quantity;
        Items genericItem;
        try {
            Scanner fileReader = new Scanner(new File(path));
            int i = 0;
            do{
                nameOfItem = fileReader.next();
                quantity = Integer.parseInt(fileReader.next());
                genericItem = new Items(nameOfItem, quantity);
                generatedList.itemsInList[i] = genericItem;
                i++;
            } while(fileReader.hasNext());
            fileReader.close();
        }
        catch(Exception e)
        {
            // File error. Will result in producing a toast.
        }

      return generatedList;

    }
    public static File populateFileFromList(List k, String path)
    {
        File returnedFile = new File("ListsFile\\" + path + ".txt");
        try {
            String nameToWrite;
            String amountToWrite;
            Formatter writerToFile = new Formatter(returnedFile);
            int i;
            for (i = 0; i < 50; i++)
            {
             nameToWrite = k.itemsInList[i].nameOfObject;
               amountToWrite = Integer.toString(k.itemsInList[i].amountOfObject);
                writerToFile.format(nameToWrite);
                writerToFile.format(" ");
                writerToFile.format(amountToWrite);
                writerToFile.format("\r\n");
                if(k.itemsInList[i + 1].nameOfObject == null)
                {
                    break;
                }
            }

        } catch (Exception e)
        {

        }

        return returnedFile;
    }

    public static boolean testFileValidity(String path)
    {
        try{
            Scanner fileReader = new Scanner(new File(path));
            fileReader.close();
        }catch(Exception e){

        return false; // file loading failed.
    }


        return true; // file loaded successfully.
    }

}
