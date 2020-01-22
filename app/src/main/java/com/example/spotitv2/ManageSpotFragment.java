package com.example.spotitv2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManageSpotFragment extends Fragment {


    public ManageSpotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manage_spot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView recyclerView = view.findViewById(R.id.spot_list);
        recyclerView.setAdapter(new SpotsAdapter());


    }

    class SpotViewHolder extends RecyclerView.ViewHolder {
        TextView spotTextView;
        ImageView spotImageView;

        SpotViewHolder(@NonNull View itemView) {
            super(itemView);
            spotTextView = itemView.findViewById(R.id.spotTextView);
            spotImageView = itemView.findViewById(R.id.spotImageView);
        }
    }

    class SpotsAdapter extends RecyclerView.Adapter<SpotViewHolder>{

        @NonNull
        @Override
        public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SpotViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_spot, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {
            final Spot spot = Dataset.spotList.get(position);

            holder.spotTextView.setText(spot.nombre);

            Glide.with(requireActivity()).load(spot.imagenURL).into(holder.spotImageView);

            //-----------------Dani del futuro, pon el onClick para cada elemento, att Dani del pasado-------------------

            //  Sigue esa práctica, zoquete https://gerardfp.github.io/mp08/p5/#5


            //------------------------------------


        }

        @Override
        public int getItemCount() {
            return Dataset.spotList.size();
        }
    }

}
