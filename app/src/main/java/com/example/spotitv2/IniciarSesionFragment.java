package com.example.spotitv2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class IniciarSesionFragment extends Fragment {


    public IniciarSesionFragment() {
        // Required empty public constructor
    }


    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false);

//        //Remove title bar
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//    //Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//    //set content view AFTER ABOVE sequence (to avoid crash)
//        this.setContentView(R.layout.fragment_iniciar_sesion);

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        Button btn_iniciar_sesion = view.findViewById(R.id.btn_iniciar_sesion);

        final EditText username = view.findViewById(R.id.user_login);
        final EditText userpassword = view.findViewById(R.id.password_login);

        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui elegimos a que fragment navegar

                String name = username.getText().toString();
                String password = userpassword.getText().toString();
                if (name.matches("") || password.matches("")){

                    Toast.makeText(getActivity(), "Introduce un usuario y contraseña",
                            Toast.LENGTH_LONG).show();

                }else {
                    Navigation.findNavController(view).navigate(R.id.homeFragment);
                    Toast.makeText(getActivity(), "Login Correcto",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        view.findViewById(R.id.registerUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.registerFragment);
            }
        });



    }

}
