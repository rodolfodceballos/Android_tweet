package com.tartalo.task.taskandroid;

import android.app.Application;

/**
 * Created by Rodolfo on 07/06/2016.
 */

public class App extends Application {


    private static final String USERNAME= "marcmarquez93";
    private static final String HASHTAG = "#MotoGP";
    private static final int TIMEDEFAULT = 60;
    
    protected static App m_ThisApp;
    protected static int tipeSearch;
    protected static String wordSearch1;
    protected static String wordSearch0;
    protected static int timeRefresh=TIMEDEFAULT;



    @Override
    public void onCreate() {
        super.onCreate();
        App.m_ThisApp = this;
    }

    public static App GetApp() {
        return m_ThisApp;
    }

    public static int getTimeRefresh() {
        return timeRefresh;
    }

    public static void setTimeRefresh(int timeRefresh) {
        App.timeRefresh = timeRefresh;
    }

    public static int getTipeSearch() {
        return tipeSearch;
    }

    public static void setTipeSearch(int tipeSearch) {
        App.tipeSearch = tipeSearch;
    }

    public static String getWordSearch0() {
        if (App.wordSearch0== null || App.wordSearch0.length()==0)
            return USERNAME;
        return App.wordSearch0;
    }

    public static void setWordSearch0(String wordSearch0) {
        App.wordSearch0 = wordSearch0;
    }

    public static String getWordSearch1() {
        if (App.wordSearch1== null || App.wordSearch1.length()==0)
            return HASHTAG;
        return wordSearch1;
    }

    public static void setWordSearch1(String wordSearch1) {
        App.wordSearch1 = wordSearch1;
    }
}
