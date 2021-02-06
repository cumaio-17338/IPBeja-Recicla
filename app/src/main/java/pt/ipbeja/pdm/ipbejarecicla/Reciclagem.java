package pt.ipbeja.pdm.ipbejarecicla;

public class Reciclagem {
    private String my_type_of_material_saved, my_type_of_material_capacity_saved;
    private double my_co2_saved, my_energy_saved, my_petroleum_saved;

    public Reciclagem(String my_type_of_material_saved, String my_type_of_material_capacity_saved, double my_co2_saved, double my_energy_saved, double my_petroleum_saved) {
        this.my_type_of_material_saved = my_type_of_material_saved;
        this.my_type_of_material_capacity_saved = my_type_of_material_capacity_saved;
        this.my_co2_saved = my_co2_saved;
        this.my_energy_saved = my_energy_saved;
        this.my_petroleum_saved = my_petroleum_saved;
    }

    public String getMy_type_of_material_saved() {
        return my_type_of_material_saved;
    }

    public String getMy_type_of_material_capacity_saved() {
        return my_type_of_material_capacity_saved;
    }

    public double getMy_co2_saved() {
        return my_co2_saved;
    }

    public double getMy_energy_saved() {
        return my_energy_saved;
    }

    public double getMy_petroleum_saved() {
        return my_petroleum_saved;
    }
}
