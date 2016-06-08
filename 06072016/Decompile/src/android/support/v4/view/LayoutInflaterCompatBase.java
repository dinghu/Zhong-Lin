package android.support.v4.view;

import android.content.*;
import android.util.*;
import android.view.*;

class LayoutInflaterCompatBase
{
    static void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        Object factory;
        if (layoutInflaterFactory != null) {
            factory = new FactoryWrapper(layoutInflaterFactory);
        }
        else {
            factory = null;
        }
        layoutInflater.setFactory((LayoutInflater$Factory)factory);
    }
    
    static class FactoryWrapper implements LayoutInflater$Factory
    {
        final LayoutInflaterFactory mDelegateFactory;
        
        FactoryWrapper(final LayoutInflaterFactory mDelegateFactory) {
            this.mDelegateFactory = mDelegateFactory;
        }
        
        public View onCreateView(final String s, final Context context, final AttributeSet set) {
            return this.mDelegateFactory.onCreateView(null, s, context, set);
        }
        
        @Override
        public String toString() {
            return this.getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }
}
