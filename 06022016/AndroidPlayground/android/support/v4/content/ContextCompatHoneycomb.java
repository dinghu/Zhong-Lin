package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

class ContextCompatHoneycomb
{
  public static File getObbDir(Context paramContext)
  {
    return paramContext.getObbDir();
  }
  
  static void startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    paramContext.startActivities(paramArrayOfIntent);
  }
}


/* Location:              C:\playground\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\content\ContextCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */