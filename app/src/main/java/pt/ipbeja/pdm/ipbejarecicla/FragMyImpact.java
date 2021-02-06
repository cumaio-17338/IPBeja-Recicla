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
    private List<Reciclagem> reciclagem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        reciclagem = new ArrayList<>();
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Refrigerante", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Água", "1L", 0.05, 0.19, 0.09));
        reciclagem.add(new Reciclagem("Garrafa de Refrigerante", "1L", 0.05, 0.19, 0.09));

    }

    public FragMyImpact() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragments_my_impact, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.my_impact_recyclerview);
        MyImpactAdapter recyclerViewAdapter = new MyImpactAdapter(getContext(), reciclagem);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }
}