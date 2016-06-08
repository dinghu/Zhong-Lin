package android.support.v7.internal.view.menu;

import android.annotation.*;
import android.content.*;
import android.support.v4.internal.view.*;
import android.view.*;

@TargetApi(16)
class MenuItemWrapperJB extends MenuItemWrapperICS
{
    MenuItemWrapperJB(final Context context, final SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }
    
    @Override
    ActionProviderWrapper createActionProviderWrapper(final ActionProvider actionProvider) {
        return new ActionProviderWrapperJB(this.mContext, actionProvider);
    }
    
    class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider$VisibilityListener
    {
        VisibilityListener mListener;
        
        public ActionProviderWrapperJB(final Context context, final android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }
        
        public boolean isVisible() {
            return this.mInner.isVisible();
        }
        
        public void onActionProviderVisibilityChanged(final boolean b) {
            if (this.mListener != null) {
                this.mListener.onActionProviderVisibilityChanged(b);
            }
        }
        
        public View onCreateActionView(final MenuItem menuItem) {
            return this.mInner.onCreateActionView(menuItem);
        }
        
        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }
        
        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }
        
        public void setVisibilityListener(final VisibilityListener mListener) {
            this.mListener = mListener;
            final android.view.ActionProvider mInner = this.mInner;
            Object visibilityListener;
            if (mListener != null) {
                visibilityListener = this;
            }
            else {
                visibilityListener = null;
            }
            mInner.setVisibilityListener((ActionProvider$VisibilityListener)visibilityListener);
        }
    }
}
