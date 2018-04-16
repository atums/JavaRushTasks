package com.javarush.task.task14.task1408;

/**
 * Created by tums on 07.07.2017.
 */
public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +  " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
