package com.pao.laboratory04.enums;

public class PriorityEnum
{
    private enum Priority{
        LOW(1, "green")
        {
            @Override public String getEmoji() {return "🟢";}
        },
        MEDIUM(2, "yellow")
        {
            @Override public String getEmoji() {return "🟡";}
        },
        HIGH(3, "orange")
        {
            @Override public String getEmoji() {return "🟠";}
        },
        CRITICAL(4, "red")
        {
            @Override public String getEmoji() {return "🔴";}
        };

    private int level;
    private String color;

    private Priority(int level, String color)
    {
        this.color = color;
        this.level = level;
    }

    public int getLevel(){return this.level;}
    public String getColor(){return this.color;}

    public abstract String getEmoji();
    }
}