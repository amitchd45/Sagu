package com.omninous.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.omninous.Fragments.PastFragment;
import com.omninous.Fragments.UpcomingFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public SectionsPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PastFragment pastFragment = new PastFragment();
                return pastFragment;
            case 1:
                UpcomingFragment upcomingFragment = new UpcomingFragment();
                return upcomingFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return "Past";
            case 1:
                return "Upcoming";

            default:
                return null;
        }

    }
}
