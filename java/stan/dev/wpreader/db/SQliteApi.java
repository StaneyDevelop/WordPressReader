package stan.dev.wpreader.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import stan.dev.wpreader.models.Post;

public class SQliteApi
{
    static private final String DB_NAME = "wpreader";
    static private final int DB_VERSION = 1610301821;
    static private volatile SQliteApi instanse;

    static public SQliteApi getInstanse()
    {
        if(instanse == null)
        {
            instanse = new SQliteApi();
        }
        return instanse;
    }

    private SQLiteDatabase sdb;

    private SQliteApi()
    {

    }

    public void createDB(Context context)
    {
        sdb = new SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)
        {
            @Override
            public void onCreate(SQLiteDatabase db)
            {
                createTables(db);
            }
            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
            {
                clearTables(db);
                onCreate(db);
            }
        }.getWritableDatabase();
    }

    public void addPost(Post post)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Tables.Posts.Columns.id, post.id);
        contentValues.put(Tables.Posts.Columns.title, post.title);
        contentValues.put(Tables.Posts.Columns.short_descr, post.short_descr);
        sdb.insert(Tables.Posts.TABLE_NAME, null, contentValues);
    }

    private void clearTables(SQLiteDatabase db)
    {
        db.execSQL("drop table if exists " + Tables.Posts.TABLE_NAME);
    }

    private void createTables(SQLiteDatabase db)
    {
        db.execSQL(Tables.Posts.CREATE_TABLE);
    }
}