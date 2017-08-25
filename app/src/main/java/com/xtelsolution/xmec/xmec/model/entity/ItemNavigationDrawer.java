package com.xtelsolution.xmec.xmec.model.entity;

/**
 * Created by vivh on 24/08/2017.
 */

public class ItemNavigationDrawer {

    private String name;

    private int resource;

    private int type = 0;

    public ItemNavigationDrawer() {
    }

    public ItemNavigationDrawer(int resource, String name) {
        this.name = name;
        this.resource = resource;
    }

    public ItemNavigationDrawer(int resource, String name, int type) {
        this.name = name;
        this.resource = resource;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ItemNavigationDrawer{" +
                "name='" + name + '\'' +
                ", resource=" + resource +
                ", type=" + type +
                '}';
    }
}
