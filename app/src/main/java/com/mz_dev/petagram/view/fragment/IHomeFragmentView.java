package com.mz_dev.petagram.view.fragment;

import com.mz_dev.petagram.adapter.PetAdapter;
import com.mz_dev.petagram.pojo.Pet;

import java.util.ArrayList;

public interface IHomeFragmentView {

    public void generateLinearLayoutVertical();

    public PetAdapter makePetAdapter(ArrayList<Pet> pets);

    public void initPetAdapter(PetAdapter petAdapter);
}
