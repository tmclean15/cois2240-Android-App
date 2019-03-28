package ca.cois2240group20.grocerymanagementapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ca.cois2240group20.grocerymanagementapp.page_fragments.GroceryListFragment;
import ca.cois2240group20.grocerymanagementapp.page_fragments.HomeFragment;
import ca.cois2240group20.grocerymanagementapp.page_fragments.InventoryFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    // Gets called when viewPager.setCurrentItem() is called
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new InventoryFragment();
            case 2:
                return new GroceryListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
