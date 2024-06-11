package genspark.pbc.OnlineBookstore.Service;

import genspark.pbc.OnlineBookstore.Entity.Book;

import java.util.List;

public interface OnlineBookService {
    List<Book> getAllTask();
    Book getTaskById(long taskId);
    Book addTask(Book task);
    Book updateTask(Book task);
    String deleteTaskById(long taskId);
}
