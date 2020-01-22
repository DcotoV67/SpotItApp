package com.example.spotitv2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn_add_spot = view.findViewById(R.id.btn_add_spot);
        Button btn_search_spot = view.findViewById(R.id.btn_search_spot);
        Button btn_manage_spot = view.findViewById(R.id.btn_manage_spot);
        Button btn_enter_profile = view.findViewById(R.id.btn_ver_perfil);
        Button btn_see_spot = view.findViewById(R.id.btn_see_spot);


        //Accion del boton add_spot
        btn_add_spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent addSpotActivity = new Intent(MainActivity.this, addSpotActivity.class);
//                startActivity(addSpotActivity);

                //Aqui elegimos a que fragment navegar
                Navigation.findNavController(view).navigate(R.id.addSpotFragment);

            }
        });

        //Accion del boton search_spot
        btn_search_spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent searchSpotactivity = new Intent(MainActivity.this, searchSpotActivity.class);
//                startActivity(searchSpotactivity);

                //Aqui elegimos a que fragment navegar

            }
        });

        btn_manage_spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent gestionarSpotActivity = new Intent(MainActivity.this, gestionarSpotActivity.class);
//                startActivity(gestionarSpotActivity);

                //Aqui elegimos a que fragment navegar
                Navigation.findNavController(view).navigate(R.id.manageSpotFragment2);

            }
        });

        btn_enter_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent gestionarSpotActivity = new Intent(MainActivity.this, gestionarSpotActivity.class);
//                startActivity(gestionarSpotActivity);

                //Aqui elegimos a que fragment navegar
                Navigation.findNavController(view).navigate(R.id.userProfileFragment);

            }
        });

        btn_see_spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent gestionarSpotActivity = new Intent(MainActivity.this, gestionarSpotActivity.class);
//                startActivity(gestionarSpotActivity);

                //Aqui elegimos a que fragment navegar
                Navigation.findNavController(view).navigate(R.id.seeSpotFragment);

            }
        });

    }
}

