package com.example.spotitv2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddSpotFragment extends Fragment {


    public AddSpotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_spot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn_new_spot = view.findViewById(R.id.btn_new_spot);

        RecyclerView recyclerView = view.findViewById(R.id.spot_list);
        recyclerView.setAdapter(new SpotsAdapter());

        btn_new_spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Aqui elegimos a que fragment navegar
                Navigation.findNavController(view).navigate(R.id.newSpotFragment);

            }
        });
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

    class SpotsAdapter extends RecyclerView.Adapter<AddSpotFragment.SpotViewHolder>{

        @NonNull
        @Override
        public AddSpotFragment.SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SpotViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_spot, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AddSpotFragment.SpotViewHolder holder, int position) {
            Spot spot = Dataset.spotList.get(position);

            holder.spotTextView.setText(spot.nombre);

            Glide.with(requireActivity()).load(spot.imagenURL).into(holder.spotImageView);

        }

        @Override
        public int getItemCount() {
            return Dataset.spotList.size();
        }
    }
}
