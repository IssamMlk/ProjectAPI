package com.vogella.android.projectapi;

public class ListItem {

    private String name;
    private String num;
    private String Height;
    private String Weight;
    private String Candy;
    private String Candy_count;
    private String Egg;
    private String imageUrl;


    public ListItem(String name, String num) {
        this.name = name;
        this.num=num;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return Height;
    }

    public String getWeight() {
        return Weight;
    }

    public String getCandy() {
        return Candy;
    }

    public String getCandy_count() {
        return Candy_count;
    }

    public String getEgg() {
        return Egg;
    }

    public String getNum(){
        return num;
    }


    public String getImageUrl(){
        return imageUrl;
    }
}
