package csu.csci325.GroceryApp;


public class List {
public List(String nameOfList)
{
    for(int i = 0;i < 50; i++) {
        Items anItem = new Items(null, 0);
        itemsInList[i] = anItem;
    }
    }

    Items[] itemsInList = new Items[50];


}
class Items{
    public Items(String name, int quantity)
    {
        name = nameOfObject;
        quantity = amountOfObject;

    }
    String nameOfObject;
    int amountOfObject;



}
