package com.tartalo.task.taskandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.Timer;
import java.util.TimerTask;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Rodolfo on 07/06/2016.
 */

public class MainActivity extends ListActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TWITTER_KEY = "OO5p5kLQaD56EBZ8nvJQSfrcp";
    private static final String TWITTER_SECRET = "dDOmrh0q8JVE6vvjvuJTTQo7rEm7gNgdu7tB65Lkd57XmsxdU6";

    TweetTimelineListAdapter adapter;
    private Timer mTimer = null;
    Toolbar toolbar;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        progressBar= (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        TwitterAuthConfig authConfig =  new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });

    }

    @Override
    protected void onResume() {


        if (App.GetApp().getTipeSearch()==0)
        {
            toolbar.setTitle(App.GetApp().getWordSearch0());
            final UserTimeline userTimeline = new UserTimeline.Builder()
                    .screenName(App.GetApp().getWordSearch0())
                    .build();
            adapter = new TweetTimelineListAdapter.Builder(this)
                    .setTimeline(userTimeline)
                    .build();
        }else
        {
            toolbar.setTitle(App.GetApp().getWordSearch1());
            final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                    .query(App.GetApp().getWordSearch1())
                    .build();
            adapter = new TweetTimelineListAdapter.Builder(this)
                    .setTimeline(searchTimeline)
                    .build();
        }


        setListAdapter(adapter);

        this.mTimer = new Timer();
        this.mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                refresh();
            }
        }, 0, 1000 * App.GetApp().getTimeRefresh());
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.timeRefresh) {
            Intent acti = new Intent(this, TimeRefresh.class);
            this.startActivity(acti);
        } else if (id == R.id.findCriteria) {
            Intent acti = new Intent(this, WordSearch.class);
            this.startActivity(acti);
        } else if (id == R.id.about){
            Intent acti = new Intent(this, About.class);
            this.startActivity(acti);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void refresh()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
                adapter.refresh(new Callback<TimelineResult<Tweet>>() {
                    @Override
                    public void success(Result<TimelineResult<Tweet>> result) {
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

    }
}
