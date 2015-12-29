import java.io.File;
import java.util.Formatter;

import java.util.Scanner;

public class fileManagement{
   // String selectedFileName;
    // File structure: Name of object (string name) + Number of said object (int quantity).
    public static void makeFile(String newFileName)
    {

        try {

            newFileName = newFileName + ".txt";
            Formatter x;
            x = new Formatter("ListsFile\\" + newFileName);

        }
        catch (Exception e)
        {
            System.out.println("Please enter a valid file name.");
              /* Android stuff
                Toast errorToast = Toast.makeText(getApplicationContext(),"Please enter a valid file name.",Toast.LENGTH_LONG);
             errorToast.show();

                 */
        }
    }

    public static File populateFileFromList(List k, String path)
    {
        File returnedFile = new File("ListsFile\\" + path + ".txt");
        try {
            String nameToWrite;
            String amountToWrite;
            Formatter writerToFile = new Formatter(returnedFile);
            int i;
            for(i = 0;i < 50; i++ )
            {

                nameToWrite = k.itemsInList[i].nameOfObject;
                amountToWrite = Integer.toString(k.itemsInList[i].amountOfObjects);
                System.out.println(nameToWrite);
                System.out.println(amountToWrite);
                writerToFile.format((nameToWrite));
                writerToFile.format((" "));
                writerToFile.format((amountToWrite));
                writerToFile.format(("\r\n"));
                if (k.itemsInList[i + 1].nameOfObject == null)
                {
                    break;
                }
            }

        writerToFile.close();
        }
        catch (Exception e)
        {
            //Toast errorToast = Toast.makeText(getApplicationContext(),"File is corrupt or invalid. Select another.,Toast.LENGTH_LONG);
            //errorToast.show();
       System.out.println("File is corrupt or invalid. Select a different one.");
        }
        return returnedFile;
    }

         public static List populateListFromFile(String path)
            {
                
               List generatedList = new List(path);
                String nameOfItem;
                int quantity;

                Items genericItem;

             try{
                 Scanner fileReader = new Scanner(new File(path));
                 int i = 0;
                do {


                    nameOfItem = fileReader.next();
                    quantity = Integer.parseInt(fileReader.next());
                 genericItem = new Items(nameOfItem, quantity);
                    generatedList.itemsInList[i] = genericItem;
                   System.out.println("List object name " +  " " + generatedList.itemsInList[i].nameOfObject);
                    System.out.println("Amount of that object: " +  " " + generatedList.itemsInList[i].amountOfObjects);
                   i++;

                } while(fileReader.hasNext());
            fileReader.close();
             }
                catch(Exception e)
                {
                    System.out.println("File is corrupt or invalid. Select another.");
                    // Android stuff
                    //Toast errorToast = Toast.makeText(getApplicationContext(),"File is corrupt or invalid. Select another.,Toast.LENGTH_LONG);
                 //errorToast.show();


                }


                return generatedList;

            }
    public static void deleteFile(String path)
    {
 File aFile = new File("ListsFile\\" + path + ".txt");
        if (aFile.exists())
        {
            aFile.delete();
            System.out.println("The file " + aFile.getName() + " has been deleted.");
        }
    }

public static boolean fileExists(String path)
{
    File aFile = new File("ListsFile\\" + path + ".txt");
    if(aFile.exists())
    {
        System.out.println("The file: " + aFile.getName() + " does exist.");
        return true;
    }
else

  return false;
}




}// Handles the writing of the files. Handled by Eric.