package pt.ipbeja.pdm.ipbejarecicla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyImpactAdapter extends RecyclerView.Adapter <MyImpactAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private List<Reciclagem> data;

    MyImpactAdapter(Context context, List<Reciclagem> data)
    {
        this.layoutInflater =  LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycling_card_view, parent, false);
        return new MyImpactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String type_of_material_and_capacity = data.get(position).getMy_type_of_material_saved()+""+ data.get(position).getMy_type_of_material_capacity_saved();

        holder.textView_my_type_of_material_and_capacity_saved.setText(type_of_material_and_capacity);

        String co2_saved = data.get(position).getMy_co2_saved()+" kg";
        holder.textView_my_co2_saved.setText(co2_saved);

        String energy_saved = data.get(position).getMy_energy_saved()+" kWh";
        holder.textView_my_energy_saved.setText(energy_saved);

        String petroleum_saved = data.get(position).getMy_petroleum_saved()+" L";
        holder.textView_my_petroleum_saved.setText(petroleum_saved);
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_my_type_of_material_and_capacity_saved;
        TextView textView_my_co2_saved;
        TextView textView_my_energy_saved;
        TextView textView_my_petroleum_saved;

        public ViewHolder(@NonNull View view) {
            super(view);
            textView_my_type_of_material_and_capacity_saved = view.findViewById(R.id.my_type_of_material_and_capacity_saved_textView);
            textView_my_co2_saved = view.findViewById(R.id.my_co2_saved_textView);
            textView_my_energy_saved = view.findViewById(R.id.my_energy_saved_textView);
            textView_my_petroleum_saved = view.findViewById(R.id.my_petroleum_saved_textView);
        }
    }
}





