package com.example.grouprecyclerview;

public class TaskItem extends ListItem {
    private DataModel dataModel;

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public int getType() {
        return TYPE_TASK;
    }
}
