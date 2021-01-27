package pt.ipbeja.pdm.ipbejarecicla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommunityImpactAdapter extends RecyclerView.Adapter<CommunityImpactAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> data;


    CommunityImpactAdapter(Context context, List<String> data){

        this.layoutInflater =  LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public CommunityImpactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.school_statistics_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //TODO
        String titleTotRec = data.get(i); //Neste não preciso colocar a partir dos dados do adapter, ver bem deposi
        holder.textViewTotalRec.setText(titleTotRec);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //TODO
        TextView textViewTotalRec; //Colocar as outras


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTotalRec = itemView.findViewById(R.id.totalReciclagens)
        }
    }
}
