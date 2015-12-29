public class listManagement{

    public static Items add(List k, String nameofobject, int amountofobject) {

        Items ReturnItem = new Items(nameofobject, amountofobject);

        int i = 0;
        do {
            i++;
        }while(k.itemsInList[i].nameOfObject == null);


        return k.itemsInList[i]=ReturnItem;
    }


    public static void Remove(List k,int position) {

        k.itemsInList[position].nameOfObject = null;
        k.itemsInList[position].amountOfObjects = 0;
        if (k.itemsInList[position + 1].nameOfObject != null) {
            int i;

            for (i = position; i < 50; i++) {

                k.itemsInList[position] = k.itemsInList[position + 1];

            }

        }
    }
}