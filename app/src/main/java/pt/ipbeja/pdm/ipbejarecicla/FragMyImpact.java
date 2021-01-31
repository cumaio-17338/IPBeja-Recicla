package pt.ipbeja.pdm.ipbejarecicla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragMyImpact extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Reciclagens> reciclagens;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        
        reciclagens = new ArrayList<>();
        reciclagens.add(new Reciclagens(30, 5.7, 1.5, 2.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
        reciclagens.add(new Reciclagens(20, 3.3, 1.8, 1.7));
    }


    public FragMyImpact()
    {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragments_community_impact, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.community_impact_recyclerview);
        CommunityImpactAdapter recyclerViewAdapter = new CommunityImpactAdapter(getContext(), reciclagens);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }
}