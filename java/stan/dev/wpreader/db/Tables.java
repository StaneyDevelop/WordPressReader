package stan.dev.wpreader.db;

public interface Tables
{
    interface Posts
    {
        String TABLE_NAME = Posts.class.getCanonicalName().toLowerCase().replace('.', '_') + "_table";
        String CREATE_TABLE = "create table if not exists " + TABLE_NAME + " (" +
                Columns.id + " integer primary key autoincrement" + "," +
                Columns.title + " text" + "," +
                Columns.short_descr + " text" +
                ");";
        interface Columns
        {
            String id = TABLE_NAME + "_" + "id";
            String title = TABLE_NAME + "_" + "title";
            String short_descr = TABLE_NAME + "_" + "short_descr";
        }
    }
}