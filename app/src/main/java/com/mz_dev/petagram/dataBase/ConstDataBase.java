package com.mz_dev.petagram.dataBase;

public final class ConstDataBase {
    //DataBase
    public static final String DATABASE_NAME = "pets_db";
    public static final int DATABASE_VERSION = 1;
    //Pets entity
    public static final String TABLE_PETS = "pet";
    public static final String TABLE_PETS_ID = "id";
    public static final String TABLE_PETS_NAME = "name";
    public static final String TABLE_PETS_IMAGE = "image";
    public static final String TABLE_PETS_RATING = "rating";
    //Rating entity
    public static final String TABLE_PET_RATING = "pet_rating";
    public static final String TABLE_PET_RATING_ID = "id";
    public static final String TABLE_PET_RATING_RATING = "rating";
    public static final String TABLE_PET_RATING_PET_ID = "pet_id";

}
