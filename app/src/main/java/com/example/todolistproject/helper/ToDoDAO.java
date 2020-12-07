package com.example.todolistproject.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.todolistproject.model.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {

    private SQLiteDatabase write; //Para escrever nas tabelas
    private SQLiteDatabase read; //Para ler nas tabelas

    public ToDoDAO(Context context) {
        DBHelper db = new DBHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    public boolean insertToDo(ToDo toDo) {
        ContentValues values = new ContentValues();
        values.put("name", toDo.getToDoName());
        try {
            write.insert(DBHelper.TABLE1_NAME, null, values);
            Log.i("INFO", "Tarefa salva com sucesso. ");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao salvar tarefa. " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateToDo(ToDo toDo) {
        ContentValues values = new ContentValues();
        values.put("name", toDo.getToDoName());
        try {
            String[] args = { toDo.getId().toString()};
            write.update(DBHelper.TABLE1_NAME, values, "id=?", args);
            Log.i("INFO", "Tarefa ataulizada com sucesso. ");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao atualizar tarefa. " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteToDo(ToDo toDo) {
        try {
            String[] args = { toDo.getId().toString()};
            write.delete(DBHelper.TABLE1_NAME, "id=?", args);
            Log.i("INFO", "Tarefa removida com sucesso. ");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao excluir tarefa. " + e.getMessage());
            return false;
        }
        return true;
    }

    public List<ToDo> getAllToDos() {
        List<ToDo> toDoList = new ArrayList<>();
        Cursor cursor = read.query(DBHelper.TABLE1_NAME, new String[]{"id", "name"},
                null, null, null, null, null );

        while(cursor.moveToNext()) {
            ToDo toDo = new ToDo();
            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String toDoName = cursor.getString(cursor.getColumnIndex("name"));
            toDo.setId(id);
            toDo.setToDoName(toDoName);
            toDoList.add(toDo);
        }
        return toDoList;
    }
}
