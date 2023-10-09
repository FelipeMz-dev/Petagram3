package com.mz_dev.petagram.dataBase;

import android.content.ContentValues;
import android.content.Context;

import com.mz_dev.petagram.R;
import com.mz_dev.petagram.pojo.Pet;

import java.util.ArrayList;

public class PetsBuilder {
    private Context context;

    public PetsBuilder(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> getPetData(){
        DataBaseHelper dbHelper = new DataBaseHelper(context);
        insertPetData(dbHelper);
        return dbHelper.getAllPets();
    }

    public void insertPetData(DataBaseHelper dbHelper){
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Simon", R.drawable.pet1, 20));
        pets.add(new Pet("Negra", R.drawable.pet2, 5));
        pets.add(new Pet("Lulu", R.drawable.pet3, 6));
        pets.add(new Pet("Luna", R.drawable.pet4, 5));
        pets.add(new Pet("Midas", R.drawable.pet5, 12));
        dbHelper.insertPet(pets.get(0).toContentValues());
        dbHelper.insertPet(pets.get(1).toContentValues());
        dbHelper.insertPet(pets.get(2).toContentValues());
        dbHelper.insertPet(pets.get(3).toContentValues());
        dbHelper.insertPet(pets.get(4).toContentValues());
    }

    public void insertPetRating(Pet pet){
        DataBaseHelper dbHelper = new DataBaseHelper(context);
        ContentValues values = new ContentValues();
        values.put(ConstDataBase.TABLE_PET_RATING_PET_ID, pet.getId());
        values.put(ConstDataBase.TABLE_PET_RATING_RATING, 1);
        dbHelper.insertPetRating(values);
    }

    public int getPetRating(Pet pet){
        DataBaseHelper dbHelper = new DataBaseHelper(context);
        return dbHelper.getPetRating(pet);
    }

    public ArrayList<Pet> getLastRatedPets(){
        DataBaseHelper dbHelper = new DataBaseHelper(context);
        return dbHelper.getLastFiveRatedPets();
    }
}
