package stan.dev.wpreader.ui.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import stan.dev.wpreader.R;
import stan.dev.wpreader.db.SQliteApi;
import stan.dev.wpreader.db.Tables;
import stan.dev.wpreader.models.Post;
import stan.dev.wpreader.ui.fragments.MainFragment;

public class MainActivity
        extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        init();
    }

    private void init()
    {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame, new MainFragment())
                .commit();
//        write();
//        read();
//        writeMulti();
        readMulti();
    }

    private void write()
    {
        Post post = new Post();
        post.id = 1;
        post.title = "post1";
        post.short_descr = "this is post #1";
        SQliteApi.getInstanse().addPost(post);
    }
    private void read()
    {
        Cursor cursor = SQliteApi.getInstanse().getPosts();
        cursor.moveToFirst();
        String post = "";
        post += "title " + cursor.getString(cursor.getColumnIndex(Tables.Posts.Columns.title));
        post += "\n";
        post += "short_descr " + cursor.getString(cursor.getColumnIndex(Tables.Posts.Columns.short_descr));
        Log.e(getClass().getName(), post);
        cursor.close();
    }
    private void writeMulti()
    {
        int i = 10;
        while(i > 0)
        {
            Post post = new Post();
            post.id = i;
            post.title = "post" + i;
            post.short_descr = "this is post #" + i;
            SQliteApi.getInstanse().addPost(post);
            i--;
        }
    }
    private void readMulti()
    {
        Cursor cursor = SQliteApi.getInstanse().getPosts();
        if(cursor.moveToFirst())
        {
            do
            {
                String post = "";
                post += "title " + cursor.getString(cursor.getColumnIndex(Tables.Posts.Columns.title));
                post += "\n";
                post += "short_descr " + cursor.getString(cursor.getColumnIndex(Tables.Posts.Columns.short_descr));
                Log.e(getClass().getName(), post);
            }while(cursor.moveToNext());
        }
        cursor.close();
    }
}