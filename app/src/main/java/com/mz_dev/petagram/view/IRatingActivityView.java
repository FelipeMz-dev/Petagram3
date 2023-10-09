package com.mz_dev.petagram.view;

import com.mz_dev.petagram.adapter.PetAdapter;
import com.mz_dev.petagram.pojo.Pet;

import java.util.ArrayList;

public interface IRatingActivityView {
    void generateLinearLayoutVertical();
    PetAdapter makePetAdapter(ArrayList<Pet> pets);
    void initPetAdapter(PetAdapter petAdapter);
}
