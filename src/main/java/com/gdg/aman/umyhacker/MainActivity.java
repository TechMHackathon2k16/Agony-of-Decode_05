package com.gdg.aman.umyhacker;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;
  //  PagerAdapter mPagerAdapter;
    ImageView cmd, recentUploads, networking, customLinuxOs, database, first, third, fourth;
    public static List<UmyhackerPojo> items = new ArrayList<>();
    ArrayAdapter<UmyhackerPojo> myArrayAdapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList, HomeListView;
    ArrayAdapter<String> listAdapter, mAdapter;
 //   String myArray[] = {"hello","hi"};
    private String mActivityTitle;
    ImageView databaseImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navList);
        HomeListView = (ListView) findViewById(R.id.HomeListView);

        /*getWindow().requestFeature(Window.FEATURE_ACTION_BAR);*/

        /*setContentView(R.layout.activity_main);*/

        // experiment with the ActionBar
     /*   ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00BCF2")));*/
       /* listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArray);*/
        mDrawerList.setAdapter(listAdapter);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

     /*   mPager = (ViewPager) findViewById(R.id.viewPager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mPager.setAdapter(new MyAdapter(fragmentManager));*/

        myArrayAdapter = new UmyhackerAdapter(MainActivity.this, items);
        HomeListView.setAdapter(myArrayAdapter);

        createData();

        HomeListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 0)
                {
                    Intent intent = new Intent(MainActivity.this, CmdTutorial.class);
                    intent.putExtra("first_type", "f1");
                    startActivity(intent);
                }
                if ( position == 1)
                {
                    Intent intent = new Intent(MainActivity.this, NetworkingTutorial.class);
                    intent.putExtra("second_type", "f1");
                    startActivity(intent);
                }

            }
        });

      /*  HomeListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (items.get(position).getName().equals("Recent Upload"))
                {
                    Intent intent = new Intent(MainActivity.this, RecentUpload.class);
                    intent.putExtra("first_type", "f1");
                    startActivity(intent);
                }
                if (items.get(position).getName().equals("CMD Tutorials"))
                {
                    Intent intent = new Intent(MainActivity.this, CmdTutorial.class);
                    intent.putExtra("second_type", "f2");
                    startActivity(intent);
                }
                if (items.get(position).getName().equals("Database"))
                {
                    Intent intent = new Intent(MainActivity.this, DatabaseTutorial.class);
                    intent.putExtra("third_type", "f3");
                    startActivity(intent);
                }
                if (items.get(position).getName().equals("Networking"))
                {
                    Intent intent = new Intent(MainActivity.this, NetworkingTutorial.class);
                    intent.putExtra("fourth_type", "f4");
                    startActivity(intent);
                }
                if (items.get(position).getName().equals("Custom Linux OS"))
                {
                    Intent intent = new Intent(MainActivity.this, CustomLinuxOs.class);
                    intent.putExtra("fifth_type", "f5");
                    startActivity(intent);
                }
            }
        });*/
    }

    private void addDrawerItems()
    {
        String[] osArray = { "Home", "Recent Upload", "Playlist", "Quick Links", "Online events",
                            "YuvaManthan", "StartUp Discussion", "Contact Us", "Our Initiatives"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 1)
                {
                    Intent intent = new Intent(MainActivity.this, RecentUpload.class);
                    intent.putExtra("first_type", "f1");
                    startActivity(intent);
                }

               // Toast.makeText(MainActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupDrawer()
    {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void createData()
    {
       /* UmyhackerPojo pojo1 = new UmyhackerPojo(R.drawable.cmd, "CMD Tutorials");
        UmyhackerPojo pojo2 = new UmyhackerPojo(R.drawable.database, "Database Administration tutorials");
        UmyhackerPojo pojo3 = new UmyhackerPojo(R.drawable.networking, "Networking tutorials");
        UmyhackerPojo pojo4 = new UmyhackerPojo(R.drawable.custom_linux, "Custom Linux OS");
        UmyhackerPojo pojo5 = new UmyhackerPojo(R.drawable.popular_upload, "Popular Upload");
        UmyhackerPojo pojo6 = new UmyhackerPojo(R.drawable.recent_upload, "Recent Upload");
        UmyhackerPojo pojo7 = new UmyhackerPojo(R.drawable.startup_discussion, "Startup Discussion");
        UmyhackerPojo pojo8 = new UmyhackerPojo(R.drawable.startup_discussion, "YuvaManthan");
        //
        UmyhackerPojo pojo9 = new UmyhackerPojo(R.drawable.startup_it_knowledge, "Startups IT knowledge base");
        UmyhackerPojo pojo10 = new UmyhackerPojo(R.drawable.windows_10_phone, "Windows Phone 10");
        UmyhackerPojo pojo11 = new UmyhackerPojo(R.drawable.windows_server, "Windows server 2016");
        UmyhackerPojo pojo13 = new UmyhackerPojo(R.drawable.virtualization, "Virtualization");
        UmyhackerPojo pojo14 = new UmyhackerPojo(R.drawable.knowledgebase, "KnowledgeBase");
        UmyhackerPojo pojo15 = new UmyhackerPojo(R.drawable.hyper_v, "Hyper V Tutorials");
        UmyhackerPojo pojo16 = new UmyhackerPojo(R.drawable.linux_tut_for_beg, "Linux tutorial for beginners");
        UmyhackerPojo pojo17 = new UmyhackerPojo(R.drawable.wiindows_10_desktop, "Windows 10 desktop");
        UmyhackerPojo pojo18 = new UmyhackerPojo(R.drawable.windows_10_all_plat, "Windows 10 All Platforms");
        UmyhackerPojo pojo19 = new UmyhackerPojo(R.drawable.aws, "Amazon Web Service Tutorial");
        UmyhackerPojo pojo20 = new UmyhackerPojo(R.drawable.windows_server, "Windows server 2012");
        UmyhackerPojo pojo22 = new UmyhackerPojo(R.drawable.virtual_private, "Virtual private Server(VPS) Tutorials");
        UmyhackerPojo pojo23 = new UmyhackerPojo(R.drawable.cloud_computing, "Cloud Computing tutorials");
        UmyhackerPojo pojo24 = new UmyhackerPojo(R.drawable.azure, "Microsoft Azure Tutorials");
        UmyhackerPojo pojo25 = new UmyhackerPojo(R.drawable.wordpress, "Wordpress Development tutorials");
        UmyhackerPojo pojo26 = new UmyhackerPojo(R.drawable.web_hosting, "Web Hosting tutorials");
        UmyhackerPojo pojo27 = new UmyhackerPojo(R.drawable.windows_xp, "Windows XP Tutorials");
        UmyhackerPojo pojo28 = new UmyhackerPojo(R.drawable.red_hat, "RHEL 6.0 Tutorial track");
        UmyhackerPojo pojo29 = new UmyhackerPojo(R.drawable.windows7, "Windows 7 Tutorials");
        UmyhackerPojo pojo30 = new UmyhackerPojo(R.drawable.windows81, "Windows 8.1 Tutorial");
        UmyhackerPojo pojo31 = new UmyhackerPojo(R.drawable.ubuntu, "Ubuntu Tutorials");
        UmyhackerPojo pojo32 = new UmyhackerPojo(R.drawable.facebook, "Facebook Tutorials");
        UmyhackerPojo pojo33 = new UmyhackerPojo(R.drawable.windows_server, "Windows troubleshooting");
        UmyhackerPojo pojo34 = new UmyhackerPojo(R.drawable.windows8, "Windows 8 tutorial");
        UmyhackerPojo pojo35 = new UmyhackerPojo(R.drawable.live_events, "Live Events");
        UmyhackerPojo pojo36 = new UmyhackerPojo(R.drawable.digital_marketting, "Digital Marketing");*/


        UmyhackerPojo pojo1 = new UmyhackerPojo(R.drawable.cmd, "CMD Tutorials", R.drawable.database, "Database Tutorial");
        UmyhackerPojo pojo2 = new UmyhackerPojo(R.drawable.networking, "Networking Tutorials", R.drawable.custom_linux, "Custom Linux OS");
        UmyhackerPojo pojo3 = new UmyhackerPojo(R.drawable.popular_upload, "Popular Upload", R.drawable.recent_upload, "Recent Upload");
        UmyhackerPojo pojo4 = new UmyhackerPojo(R.drawable.startup_discussion, "StartUp Discussion", R.drawable.startup_discussion, "Yuvamanthan");
        UmyhackerPojo pojo5 = new UmyhackerPojo(R.drawable.startup_it_knowledge, "Startup IT Knowledge Base", R.drawable.windows_10_phone, "Windows Phone 10");
        UmyhackerPojo pojo6 = new UmyhackerPojo(R.drawable.windows_server, "Windows Server 2016", R.drawable.virtualization, "Virtualization");
        UmyhackerPojo pojo7 = new UmyhackerPojo(R.drawable.knowledgebase, "Knowledgebase", R.drawable.hyper_v, "Hyper V Tutorials");
        UmyhackerPojo pojo8 = new UmyhackerPojo(R.drawable.linux_tut_for_beg, "Linux Tutorial for Beginnners", R.drawable.wiindows_10_desktop, "Windows 10 desktop");
        UmyhackerPojo pojo9 = new UmyhackerPojo(R.drawable.windows_10_all_plat, "Windows 10 All Platforms", R.drawable.aws, "Amazon Web Service Tutorial");
        UmyhackerPojo pojo10 = new UmyhackerPojo(R.drawable.windows_server, "Windows server 2012", R.drawable.virtual_private, "Virtual private Server(VPS) Tutorials");
        UmyhackerPojo pojo11 = new UmyhackerPojo(R.drawable.cloud_computing, "Cloud Computing tutorials", R.drawable.azure, "Microsoft Azure Tutorials");
        UmyhackerPojo pojo12 = new UmyhackerPojo(R.drawable.wordpress, "Wordpress Development tutorials", R.drawable.web_hosting, "Web Hosting tutorials");
        UmyhackerPojo pojo13 = new UmyhackerPojo(R.drawable.windows_xp, "Windows XP Tutorials", R.drawable.red_hat, "RHEL 6.0 Tutorial track");
        UmyhackerPojo pojo14 = new UmyhackerPojo(R.drawable.windows7, "Windows 7 Tutorials", R.drawable.windows81, "Windows 8.1 Tutorial");
        UmyhackerPojo pojo15 = new UmyhackerPojo(R.drawable.ubuntu, "Ubuntu tutorials", R.drawable.facebook, "Facebook Tutorials");
        UmyhackerPojo pojo16 = new UmyhackerPojo(R.drawable.windows_server, "Windows troubleshooting", R.drawable.windows8, "Windows 8 tutorial");
        UmyhackerPojo pojo17 = new UmyhackerPojo(R.drawable.live_events, "Live Events", R.drawable.digital_marketting, "Digital Marketing");




    /*

       *//* pojo1.setName("CMD Tutorials");
        pojo1.setImages(R.drawable.cmd);*//*
        items.add(pojo1);

       *//* pojo2.setName("Database");
        pojo2.setImages(R.drawable.database);*//*
        items.add(pojo2);

       *//* pojo3.setName("Networking");
        pojo3.setImages(R.drawable.networking);*//*
        items.add(pojo3);

       *//* pojo4.setName("Custom Linux OS");
        pojo4.setImages(R.drawable.custom_linux);*//*
        items.add(pojo4);

       *//* pojo5.setName("Popular Upload");
        pojo5.setImages(R.drawable.first);*//*
        items.add(pojo5);

       *//* pojo6.setName("Recent upload");
        pojo6.setImages(R.drawable.second);*//*
        items.add(pojo6);

      *//*  pojo7.setName("StartUp Discussion");
        pojo7.setImages(R.drawable.third);*//*
        items.add(pojo7);

       *//* pojo2.setName("Yuvamantra");
        pojo2.setImages(R.drawable.fourth);*//*
        items.add(pojo2);

        items.add(pojo8);
        items.add(pojo9);
        items.add(pojo10);
        items.add(pojo11);
        items.add(pojo13);
        items.add(pojo14);
        items.add(pojo15);
        items.add(pojo16);
        items.add(pojo17);
        items.add(pojo18);
        items.add(pojo19);
        items.add(pojo20);
        items.add(pojo22);
        items.add(pojo23);
        items.add(pojo24);
        items.add(pojo25);
        items.add(pojo26);
        items.add(pojo27);
        items.add(pojo28);
        items.add(pojo29);
        items.add(pojo30);
        items.add(pojo31);
        items.add(pojo32);
        items.add(pojo33);
        items.add(pojo34);
        items.add(pojo35);
        items.add(pojo36);*/

        items.add(pojo1);
        items.add(pojo2);
        items.add(pojo3);
        items.add(pojo4);
        items.add(pojo5);
        items.add(pojo6);
        items.add(pojo7);
        items.add(pojo8);
        items.add(pojo9);
        items.add(pojo10);
        items.add(pojo11);
        items.add(pojo12);
        items.add(pojo13);
        items.add(pojo14);
        items.add(pojo15);
        items.add(pojo16);
        items.add(pojo17);
    }





   /* public class MyAdapter extends FragmentStatePagerAdapter
    {

        public MyAdapter(android.support.v4.app.FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int i)
        {
            Fragment fragment = null;
            if (i == 0)
            {
                fragment = new FragmentD();
            }
            if (i == 1)
            {
                fragment = new FragmentB();
            }
            if (i == 2)
            {
                fragment = new FragmentC();
            }
            if (i == 3)
            {
                fragment = new FragmentA();
            }
            return fragment;
        }

        @Override
        public int getCount()
        {
            return 4;
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
