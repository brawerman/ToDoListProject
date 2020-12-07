package com.example.todolistproject.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int DB_VERSION = 1;
    public static String DB_NAME = "TODO.DB";
    public static String TABLE1_NAME = "todos";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE1_NAME
            + " ( id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL ); ";

        try {
            sqLiteDatabase.execSQL(CREATE_SQL);
            Log.i("INFO DB", "Tabela criada.");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao criar tabela." + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Código para mudança do BD
        //Método chamado apenas quando a versão do DB mudar
        //Código exemplo para alterar
        //String ALTER_SQL = "ALTER TABLE " + TABLE1_NAME
        //        + " ADD COLUMN status VARCHAR(3) ";

        String sql = "DROP TABLE IF EXISTS " + TABLE1_NAME + ";";
        try {
            sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
            Log.i("INFO DB", "Tabela atualizada.");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao atualizar tabela." + e.getMessage());
        }

    }
}
