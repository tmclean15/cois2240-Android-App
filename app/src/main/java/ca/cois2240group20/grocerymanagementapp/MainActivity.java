package ca.cois2240group20.grocerymanagementapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    // The viewPager is the main layout widget that will show all the different page fragments
    ViewPager viewPager;
    // The pagerAdapter is what handles which pages get shown in the viewPager
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        ActionBar actionBar = getSupportActionBar();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // A tab listener is needed to specify which actions to take when the user selects a tab
        TabLayout.OnTabSelectedListener listener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Uses the pagerAdapter getItem() to determine what fragment is at the position of the selected tab
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Nothing really needs to be done here. We could potentially hide the page,
                // but that wouldn't be particularly useful to the user. This method needs to exist
                // either way to satisfy the TabListener abstract class methods.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Similarly, nothing really needs to be done.
            }
        };

        tabLayout.addOnTabSelectedListener(listener);

        // This next few lines of code sets up a listener for our viewPager that changes tabs
        // when the user swipes through pages on their phone.
        viewPager.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        viewPager.setCurrentItem(position);

                    }
                });

        // We need to add the 3 action bar tabs
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Inventory"));
        tabLayout.addTab(tabLayout.newTab().setText("Grocery List"));
    }
}
