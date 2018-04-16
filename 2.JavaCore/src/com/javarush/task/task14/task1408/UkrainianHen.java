package com.javarush.task.task14.task1408;

/**
 * Created by tums on 07.07.2017.
 */
public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +  " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
