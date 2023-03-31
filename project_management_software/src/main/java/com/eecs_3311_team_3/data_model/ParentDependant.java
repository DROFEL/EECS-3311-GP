package com.eecs_3311_team_3.data_model;

public interface ParentDependant<K,T> {

    public void setParentID(K parentID);

    public void setID(T id);
}
