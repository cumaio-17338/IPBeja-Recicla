package pt.ipbeja.pdm.ipbejarecicla;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listFragment = new ArrayList<>();
    private final List<String> listImpacts = new ArrayList<>();


    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listImpacts.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listImpacts.get(position);
    }

    public void AddFragment(Fragment fragment, String impact)
    {
        listFragment.add(fragment);
        listImpacts.add(impact);
    }
}
