package com.example.attila.mobilszoftlab.repository;

import android.content.Context;

import com.example.attila.mobilszoftlab.model.Book;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Book> getBooks() {
        return SugarRecord.listAll(Book.class);
    }

    @Override
    public void saveBook(Book book) {
        SugarRecord.saveInTx(book);
    }
/*
    @Override
    public void updateSessions(List<Session> sessions) {
        List<Session> mySessions = getSessions();
        List<Session> toUpdate = new ArrayList<>(mySessions.size());
        for (Session mySession : mySessions) {
            for (Session session : sessions) {
                if (session.getId().equals(mySession.getId())) {
                    toUpdate.add(session);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }
*/
    @Override
    public void removeBook(Book book) {
        SugarRecord.deleteInTx(book);
    }

    @Override
    public boolean isInDB(Book book) {
        return SugarRecord.findById(Book.class, book.getIsbn()) != null;
    }
}
