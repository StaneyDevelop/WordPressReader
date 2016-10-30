package stan.dev.wpreader;

import android.app.Application;

import stan.dev.wpreader.db.SQliteApi;

public class App
        extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        SQliteApi.getInstanse().createDB(getApplicationContext());
    }
}