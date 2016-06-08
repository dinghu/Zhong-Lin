package android.support.v4.provider;

import android.net.*;
import android.provider.*;
import java.util.*;
import android.util.*;
import android.content.*;
import android.database.*;

class DocumentsContractApi21
{
    private static final String TAG = "DocumentFile";
    
    private static void closeQuietly(final AutoCloseable autoCloseable) {
        if (autoCloseable == null) {
            return;
        }
        try {
            autoCloseable.close();
        }
        catch (RuntimeException ex) {
            throw ex;
        }
        catch (Exception ex2) {}
    }
    
    public static Uri createDirectory(final Context context, final Uri uri, final String s) {
        return createFile(context, uri, "vnd.android.document/directory", s);
    }
    
    public static Uri createFile(final Context context, final Uri uri, final String s, final String s2) {
        return DocumentsContract.createDocument(context.getContentResolver(), uri, s, s2);
    }
    
    public static Uri[] listFiles(Context context, final Uri uri) {
        final ContentResolver contentResolver = context.getContentResolver();
        final Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        final ArrayList<Uri> list = new ArrayList<Uri>();
        Object o = null;
        context = null;
        try {
            Object query = null;
            Label_0133: {
                try {
                    query = contentResolver.query(buildChildDocumentsUriUsingTree, new String[] { "document_id" }, (String)null, (String[])null, (String)null);
                    while (true) {
                        context = (Context)query;
                        o = query;
                        if (!((Cursor)query).moveToNext()) {
                            break Label_0133;
                        }
                        context = (Context)query;
                        o = query;
                        list.add(DocumentsContract.buildDocumentUriUsingTree(uri, ((Cursor)query).getString(0)));
                    }
                }
                catch (Exception ex) {
                    o = context;
                    Log.w("DocumentFile", "Failed query: " + ex);
                }
                return list.toArray(new Uri[list.size()]);
            }
            closeQuietly((AutoCloseable)query);
            return list.toArray(new Uri[list.size()]);
        }
        finally {
            closeQuietly((AutoCloseable)o);
        }
    }
    
    public static Uri prepareTreeUri(final Uri uri) {
        return DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
    }
    
    public static Uri renameTo(final Context context, final Uri uri, final String s) {
        return DocumentsContract.renameDocument(context.getContentResolver(), uri, s);
    }
}
