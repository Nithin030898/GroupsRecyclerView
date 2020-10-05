package com.example.grouprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    private List<DataModel> dataModelList = new ArrayList<>();
    List<ListItem> consolidatedList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        dataModelList.add(new DataModel("Send report to Frank.", "2020-10-21"));
        dataModelList.add(new DataModel("Review subscriptions.", "2020-10-05"));
        dataModelList.add(new DataModel("Call Chris.", "2020-10-05"));
        dataModelList.add(new DataModel("Visit Dentist.", "2020-11-17"));
        dataModelList.add(new DataModel("David's birthday!", "2020-11-17"));
        dataModelList.add(new DataModel("Meet Laura.", "2020-11-17"));
        dataModelList.add(new DataModel("Email bills to John.", "2020-12-17"));
        dataModelList.add(new DataModel("Get my computer fixed.", "2020-10-05"));
        dataModelList.add(new DataModel("Plan for weekend.", "2020-12-17"));

        TreeMap<String, List<DataModel>> groupedHashMap = groupData(dataModelList);


        for (String date : groupedHashMap.keySet()) {
            DateItem dateItem = new DateItem();
            dateItem.setDate(date);
            consolidatedList.add(dateItem);


            for (DataModel dataModel : groupedHashMap.get(date)) {
                TaskItem taskItem = new TaskItem();
                taskItem.setDataModel(dataModel);//setBookingDataTabs(bookingDataTabs);
                consolidatedList.add(taskItem);
            }
        }


        adapter = new Adapter(getApplicationContext(), consolidatedList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    private TreeMap<String, List<DataModel>> groupData(List<DataModel> listOfDataModel) {

        TreeMap<String, List<DataModel>> groupedTreeMap = new TreeMap<>();

        for (DataModel dataModel : listOfDataModel) {

            String treeMapKey = dataModel.getDate();

            if (groupedTreeMap.containsKey(treeMapKey)) {
                groupedTreeMap.get(treeMapKey).add(dataModel);
            } else {
                List<DataModel> list = new ArrayList<>();
                list.add(dataModel);
                groupedTreeMap.put(treeMapKey, list);
            }
        }


        return groupedTreeMap;
    }


}
