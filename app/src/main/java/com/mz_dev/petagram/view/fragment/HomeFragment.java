package com.mz_dev.petagram.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mz_dev.petagram.R;
import com.mz_dev.petagram.adapter.PetAdapter;
import com.mz_dev.petagram.pojo.Pet;
import com.mz_dev.petagram.presenter.HomeFragmentPresenter;
import com.mz_dev.petagram.presenter.IHomeFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by FelipeMz on 25/09/2023
 */
public class HomeFragment extends Fragment implements IHomeFragmentView {

    private RecyclerView rvMainPetsList;
    private ArrayList<Pet> pets;
    private IHomeFragmentPresenter presenter;

    /*public HomeFragment(ArrayList<Pet> pets) {
        this.pets = pets;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        presenter = new HomeFragmentPresenter(this, getContext());
        return view;
    }

    /*
    public ArrayList<Pet> getRvMainPetsList(){
        return petAdapter.getFavoritePets();
    }*/

    private void initUI(View view){
        rvMainPetsList = view.findViewById(R.id.rvMainPetsList);
    }

    @Override
    public void generateLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMainPetsList.setLayoutManager(linearLayoutManager);
    }

    @Override
    public PetAdapter makePetAdapter(ArrayList<Pet> pets) {
        PetAdapter petAdapter = new PetAdapter(pets, getActivity());
        return petAdapter;
    }

    @Override
    public void initPetAdapter(PetAdapter petAdapter) {
        rvMainPetsList.setAdapter(petAdapter);
    }
}