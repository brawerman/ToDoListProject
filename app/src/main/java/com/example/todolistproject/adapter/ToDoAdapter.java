package com.example.todolistproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistproject.R;
import com.example.todolistproject.model.ToDo;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {
    private List<ToDo> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView toDo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            toDo = itemView.findViewById(R.id.textViewToDo);
        }
    }

    public ToDoAdapter(List<ToDo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View toDoItem =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_cell,
                        parent, false);
        return new MyViewHolder(toDoItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ToDo toDo = list.get(position);
        holder.toDo.setText(toDo.getToDoName());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
