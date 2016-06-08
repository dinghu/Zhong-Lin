package android.support.v7.widget;

import android.graphics.*;
import android.support.v7.internal.widget.*;
import android.widget.*;
import android.support.v4.widget.*;
import android.support.v4.graphics.drawable.*;
import android.graphics.drawable.*;
import android.os.*;
import android.util.*;
import android.support.v7.appcompat.*;
import android.support.v7.graphics.drawable.*;
import android.support.annotation.*;
import android.content.res.*;

class AppCompatCompoundButtonHelper
{
    private ColorStateList mButtonTintList;
    private PorterDuff$Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;
    private final TintManager mTintManager;
    private final CompoundButton mView;
    
    AppCompatCompoundButtonHelper(final CompoundButton mView, final TintManager mTintManager) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = mView;
        this.mTintManager = mTintManager;
    }
    
    void applyButtonTint() {
        final Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable != null && (this.mHasButtonTint || this.mHasButtonTintMode)) {
            final Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat.setTintList(mutate, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(mutate);
        }
    }
    
    int getCompoundPaddingLeft(final int n) {
        int n2 = n;
        if (Build$VERSION.SDK_INT < 17) {
            final Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
            n2 = n;
            if (buttonDrawable != null) {
                n2 = n + buttonDrawable.getIntrinsicWidth();
            }
        }
        return n2;
    }
    
    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }
    
    PorterDuff$Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }
    
    void loadFromAttributes(AttributeSet obtainStyledAttributes, int resourceId) {
        obtainStyledAttributes = (AttributeSet)this.mView.getContext().obtainStyledAttributes(obtainStyledAttributes, R.styleable.CompoundButton, resourceId, 0);
        try {
            if (((TypedArray)obtainStyledAttributes).hasValue(R.styleable.CompoundButton_android_button)) {
                resourceId = ((TypedArray)obtainStyledAttributes).getResourceId(R.styleable.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.mView.setButtonDrawable(this.mTintManager.getDrawable(resourceId));
                }
            }
            if (((TypedArray)obtainStyledAttributes).hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.mView, ((TypedArray)obtainStyledAttributes).getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (((TypedArray)obtainStyledAttributes).hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(((TypedArray)obtainStyledAttributes).getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        }
        finally {
            ((TypedArray)obtainStyledAttributes).recycle();
        }
    }
    
    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        this.applyButtonTint();
    }
    
    void setSupportButtonTintList(final ColorStateList mButtonTintList) {
        this.mButtonTintList = mButtonTintList;
        this.mHasButtonTint = true;
        this.applyButtonTint();
    }
    
    void setSupportButtonTintMode(@Nullable final PorterDuff$Mode mButtonTintMode) {
        this.mButtonTintMode = mButtonTintMode;
        this.mHasButtonTintMode = true;
        this.applyButtonTint();
    }
    
    interface DirectSetButtonDrawableInterface
    {
        void setButtonDrawable(final Drawable p0);
    }
}
