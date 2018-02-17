package com.prathameshmore.collegeinsider;

/**
 * Created by Prathamesh More on 17-02-2018.
 */

public class LostItem {

    private String name;
    private String item;
    private String contact;

    public LostItem() {

    }

    public LostItem(String name, String item, String contact) {
        this.name = name;
        this.item = item;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
