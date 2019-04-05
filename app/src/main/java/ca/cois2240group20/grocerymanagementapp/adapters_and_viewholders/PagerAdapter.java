package ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ca.cois2240group20.grocerymanagementapp.page_fragments.GroceryListFragment;
import ca.cois2240group20.grocerymanagementapp.page_fragments.HomeFragment;
import ca.cois2240group20.grocerymanagementapp.page_fragments.InventoryFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private String[] tabTitles = new String[]{"Inventory", "Grocery List"};
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    // Gets called when viewPager.setCurrentItem() is called
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new InventoryFragment();
            case 1:
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
