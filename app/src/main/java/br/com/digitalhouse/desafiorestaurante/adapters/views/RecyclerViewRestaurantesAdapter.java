package br.com.digitalhouse.desafiorestaurante.adapters.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.desafiorestaurante.R;
import br.com.digitalhouse.desafiorestaurante.interfaces.views.RecyclerViewRestauranteClickListener;
import br.com.digitalhouse.desafiorestaurante.model.views.Restaurante;

public class RecyclerViewRestaurantesAdapter extends RecyclerView.Adapter<
        RecyclerViewRestaurantesAdapter.ViewHolder> {

    private List<Restaurante> restaurantes;
    private RecyclerViewRestauranteClickListener listener;

    public RecyclerViewRestaurantesAdapter(
            List<Restaurante> restaurantes, RecyclerViewRestauranteClickListener listener) {
        this.restaurantes = restaurantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewRestaurantesAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int position) {

        View itemview = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recyclerview_restaurante_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerViewRestaurantesAdapter.ViewHolder viewHolder, int position) {

        final Restaurante restaurante = restaurantes.get(position);

        viewHolder.mostrarRestauranteNaTela(restaurante);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                listener.onClick(restaurante);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewFotoRestaurante;
        private TextView textViewNomeRestaurante;
        private TextView textViewEnderecoRestaurante;
        private TextView textViewHorarioRestaurante;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFotoRestaurante = itemView.findViewById(R.id.imageRestaurante);
            textViewNomeRestaurante = itemView.findViewById(R.id.nomeRestaurante);
            textViewEnderecoRestaurante = itemView.findViewById(R.id.textViewEnderecoRestaurante);
            textViewHorarioRestaurante = itemView.findViewById(R.id.horarioRestaurante);
        }

        public void mostrarRestauranteNaTela(Restaurante restaurante) {

            imageViewFotoRestaurante.setImageDrawable(ContextCompat.getDrawable(imageViewFotoRestaurante.getContext(), restaurante.getFotoRestaurante()));

            textViewNomeRestaurante.setText(restaurante.getNome());

            textViewEnderecoRestaurante.setText(restaurante.getEndereco());

            textViewHorarioRestaurante.setText(restaurante.getHorario());
        }
    }
}
