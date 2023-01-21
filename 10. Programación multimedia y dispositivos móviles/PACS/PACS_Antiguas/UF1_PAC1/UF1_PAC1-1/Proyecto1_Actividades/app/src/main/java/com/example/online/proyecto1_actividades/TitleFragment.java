package com.example.online.proyecto1_actividades;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Online on 19/09/2016.
 */
public class TitleFragment extends Fragment {

    @Override
    public void onCreate(Bundle sb){
        super.onCreate(sb);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.title, container,false);
    }
}