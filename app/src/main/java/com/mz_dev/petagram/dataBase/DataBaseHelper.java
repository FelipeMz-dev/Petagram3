package com.mz_dev.petagram.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mz_dev.petagram.pojo.Pet;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private Context context;
    public DataBaseHelper(@Nullable Context context) {
        super(context, ConstDataBase.DATABASE_NAME, null, ConstDataBase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryPets = "CREATE TABLE " + ConstDataBase.TABLE_PETS + "(" +
                ConstDataBase.TABLE_PETS_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstDataBase.TABLE_PETS_NAME   + " TEXT, " +
                ConstDataBase.TABLE_PETS_IMAGE  + " INTEGER)";

        String queryPetRating = "CREATE TABLE " + ConstDataBase.TABLE_PET_RATING + "(" +
                ConstDataBase.TABLE_PET_RATING_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstDataBase.TABLE_PET_RATING_RATING + " INTEGER, " +
                ConstDataBase.TABLE_PET_RATING_PET_ID + " INTEGER, " +
                "FOREIGN KEY (" + ConstDataBase.TABLE_PET_RATING_PET_ID + ") REFERENCES " +
                ConstDataBase.TABLE_PETS + "(" + ConstDataBase.TABLE_PETS_ID + "))";

        db.execSQL(queryPets);
        db.execSQL(queryPetRating);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstDataBase.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstDataBase.TABLE_PET_RATING);
        onCreate(db);
    }

    public ArrayList<Pet> getAllPets(){
        ArrayList<Pet> pets = new ArrayList<>();
        String queryPets = "SELECT * FROM " + ConstDataBase.TABLE_PETS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryPets, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int image = cursor.getInt(2);
            Pet pet = new Pet(id, name, image, 0);
            int rating = getPetRating(pet);
            pet.setRating(rating);
            pets.add(pet);
        }
        db.close();
        return pets;
    }

    public void insertPet(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstDataBase.TABLE_PETS, null, values);
        db.close();
    }

    public void insertPetRating(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstDataBase.TABLE_PET_RATING, null, values);
        db.close();
    }

    public int getPetRating(Pet pet){
        int rating = 0;
        String queryPetRating = "SELECT COUNT(" + ConstDataBase.TABLE_PET_RATING_RATING + ") FROM " +
                ConstDataBase.TABLE_PET_RATING + " WHERE " +
                ConstDataBase.TABLE_PET_RATING_PET_ID + " = " + pet.getId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryPetRating, null);
        if (cursor.moveToNext()){
            rating = cursor.getInt(0);
        }
        db.close();
        return rating;
    }

    public ArrayList<Pet> getLastFiveRatedPets(){
        ArrayList<Pet> pets = new ArrayList<>();
        String queryPetRating = "SELECT * FROM " + ConstDataBase.TABLE_PET_RATING + " ORDER BY " +
                ConstDataBase.TABLE_PET_RATING_RATING + " DESC LIMIT 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryPetRating, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int image = cursor.getInt(2);
            int rating = cursor.getInt(3);
            Pet pet = new Pet(id, name, image, rating);
            pets.add(pet);
        }
        db.close();
        return pets;
    }
}
