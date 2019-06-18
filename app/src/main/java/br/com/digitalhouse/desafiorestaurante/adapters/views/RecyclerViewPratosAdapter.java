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
import br.com.digitalhouse.desafiorestaurante.interfaces.views.RecyclerViewPratoClickListener;
import br.com.digitalhouse.desafiorestaurante.model.views.Prato;

public class RecyclerViewPratosAdapter extends RecyclerView.Adapter<RecyclerViewPratosAdapter.ViewHolder> {

    private List<Prato> pratos;
    private RecyclerViewPratoClickListener listener;


    public RecyclerViewPratosAdapter(List<Prato> pratos, RecyclerViewPratoClickListener listener) {
        this.pratos = pratos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewPratosAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int position) {

        View itemview = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recyclerview_prato_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerViewPratosAdapter.ViewHolder viewHolder, int position) {

        final Prato prato = pratos.get(position);

        viewHolder.mostrarPratos(prato);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onClick(prato);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewFotoPrato;
        private TextView textViewNomePrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFotoPrato = itemView.findViewById(R.id.imageRecyclerPrato);
            textViewNomePrato = itemView.findViewById(R.id.nomePrato);
        }

        public void mostrarPratos(Prato prato) {

            imageViewFotoPrato.setImageDrawable(ContextCompat.getDrawable(
                    imageViewFotoPrato.getContext(), prato.getFotoPrato()));

            textViewNomePrato.setText(prato.getNomePrato());
        }
    }
}
