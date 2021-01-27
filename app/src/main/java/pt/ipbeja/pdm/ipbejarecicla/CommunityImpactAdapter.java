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
    private List<Reciclagens> data;


    CommunityImpactAdapter(Context context, List<Reciclagens> data){

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

        holder.textViewTotalRec_Edit.setText(String.valueOf(data.get(position).getTotalRec()));
        holder.textViewEnergiaPoupada_Edit.setText(String.valueOf(data.get(position).getEnergiaPoupada()));
        holder.textViewCo2Absorvido_Edit.setText(String.valueOf(data.get(position).getCo2Absorvido()));
        holder.textViewPetroleoPoupado_Edit.setText(String.valueOf(data.get(position).getPetroleoPoupado()));


        holder.textViewTotalRec.setText("Total Reciclagens");
        holder.textViewEnergiaPoupada.setText("Energia Poupada");
        holder.textViewCo2Absorvido.setText("Co2 Absorvido");
        holder.textViewPetroleoPoupado.setText("Petroleo Poupado");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView textViewTotalRec;
        TextView textViewTotalRec_Edit;
        TextView textViewEnergiaPoupada;
        TextView textViewEnergiaPoupada_Edit;
        TextView textViewCo2Absorvido;
        TextView textViewCo2Absorvido_Edit;
        TextView textViewPetroleoPoupado;
        TextView textViewPetroleoPoupado_Edit;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTotalRec = itemView.findViewById(R.id.total_reciclagens);
            textViewTotalRec_Edit = itemView.findViewById(R.id.total_reciclagens_edit);

            textViewEnergiaPoupada = itemView.findViewById(R.id.energia_poupada);
            textViewEnergiaPoupada_Edit = itemView.findViewById(R.id.energia_poupada_edit);

            textViewCo2Absorvido = itemView.findViewById(R.id.co2_absorvido);
            textViewCo2Absorvido_Edit = itemView.findViewById(R.id.co2_absorvido_edit);

            textViewPetroleoPoupado = itemView.findViewById(R.id.petroleo_poupado);
            textViewPetroleoPoupado_Edit  = itemView.findViewById(R.id.petroleo_poupado_edit);

        }
    }
}
