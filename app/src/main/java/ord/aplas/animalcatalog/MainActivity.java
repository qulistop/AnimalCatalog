package ord.aplas.animalcatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcView;
    private ArrayList<DataItem> mData;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the RecyclerView
        rcView = (RecyclerView)findViewById(R.id.dataView);

        //Set the Layout Manager
        rcView.setLayoutManager(new LinearLayoutManager(this));

        //Initialize the ArrayLIst that will contain the data
        mData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new DataAdapter(this, mData);


        ItemTouchHelper.Callback callback =
                new ItemMoveCallback(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rcView);

        rcView.setAdapter(mAdapter);
        //Get the data
        initializeData();
    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] listTitles = getResources().getStringArray(R.array.animal_titles);
        String[] listInfo = getResources().getStringArray(R.array.animal_info);
        String[] listYoutube = getResources().getStringArray(R.array.animal_youtube);
        String[] listVideo = getResources().getStringArray(R.array.animal_video);
        String[] listIcon = getResources().getStringArray(R.array.animal_icon);

        //Clear the existing data (to avoid duplication)
        mData.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for (int i=0; i<listTitles.length; i++) {
            mData.add(new DataItem(listTitles[i],listInfo[i],getId(listIcon[i],R.drawable.class),
                    listYoutube[i],getId(listVideo[i],R.drawable.class)));
        }

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            //throw new RuntimeException("No resource ID found for: "
            //        + resourceName + " / " + c, e);
            return -1;
        }
    }
}