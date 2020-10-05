package com.example.grouprecyclerview;

public abstract class ListItem {
    public static final int TYPE_DATE = 0;
    public static final int TYPE_TASK = 1;

    abstract public int getType();
}
