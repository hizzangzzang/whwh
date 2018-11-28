package com.example.hwanghuijeong.bookreviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqlHelper db = new SqlHelper(this);

        /** CRUD Operations **/
        // add Books
        Log.i("Name","huijeong");
        db.addBook(new Book("Android Studio Development Essentials", "Neil Smyth"));
        db.addBook(new Book("Beginning Android Application Development", "Wei-Meng Lee"));
        db.addBook(new Book("Programming Android", "Wallace Jackson"));
        db.addBook(new Book("Hello, Android", "Wallace Jackson"));

// get all books
        List<Book> list = db.getAllBooks();

// update one book
        int j = db.updateBook(list.get(3),"Hello, Android","Ben Jackson");


// delete one book
        db.deleteBook(list.get(0));

// get all books
        db.getAllBooks();

        ListView listContent = (ListView) findViewById(R.id.list);
        list = new ArrayList<Book>();
        list=db.getAllBooks();


//get data from the table by the ListAdapter
        ListAdapter customAdapter = new ListAdapter(this, R.layout.itemlistrow,list);
        listContent.setAdapter(customAdapter);

        Log.d("Book Count", db.getIds() + "");
    }
}

