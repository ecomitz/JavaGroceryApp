package csu.csci325.GroceryApp;

import android.app.Activity;
import android.os.Bundle;
// import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
Button button1 = (Button) findViewById(R.id.FirstButton);
Button button2 = (Button) findViewById(R.id.SecondButton);
Button button3 = (Button) findViewById(R.id.ThirdButton);
        ListView theList = (ListView) findViewById(R.id.ListOfItems);


button1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view){
        String currentButtonText = button1.getText().toString();
        if(currentButtonText.equals("Create List"))
        {
            button1.setText("Add");
            button2.setText("Remove");
            button3.setText("Save");
            button3.setVisibility(View.VISIBLE);
            button3.setClickable(true);

        }

    }
});

button2.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view)
    {
        String currentButtonText = button2.getText().toString();
        if(currentButtonText.equals("View List"))
        {
            String placeholder = "ph";
            button1.setText("Edit");
            button2.setText("Send");
            List currentlyViewedList = new List(placeholder);
            fileManagement.populateListFromFile(placeholder);
            if (!fileManagement.testFileValidity(placeholder));
            {
                Toast errorToast = Toast.makeText(getApplicationContext(), "There was an error with this file.", Toast.LENGTH_SHORT);
                errorToast.show();
            }

        }
    }
});


    }





}
