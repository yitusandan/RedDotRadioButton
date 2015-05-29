package com.cx.reddotradiobutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

public class RedDotRadioButton extends RadioButton {
	private static final String TAG = "RedDotRadioButton";

	private Drawable mDrawable;
	private Drawable mDrawableTop;

	private boolean mVisibility = false;

	private int topWidth;
	private int topHeight;

	public RedDotRadioButton(Context context) {
		this(context, null);
	}

	public RedDotRadioButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RedDotRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.RedDotRadioButton);
		mDrawable = a.getDrawable(R.styleable.RedDotRadioButton_src);
		mVisibility = a.getBoolean(R.styleable.RedDotRadioButton_visibility,
				false);
		mDrawableTop = a.getDrawable(R.styleable.RedDotRadioButton_drawableTop);

		a.recycle();

		if (mDrawable != null) {

		}
		if (mDrawableTop != null) {
			topWidth = mDrawableTop.getMinimumWidth();
			topHeight = mDrawableTop.getMinimumHeight();
			mDrawableTop.setBounds(0, 0, topWidth, topHeight);
			setCompoundDrawables(null, mDrawableTop, null, null);
		}

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// int height = getMeasuredHeight();
		int width = getMeasuredWidth();

		if (mVisibility && mDrawable != null) {
			int minimumWidth = mDrawable.getMinimumWidth();
			int minimumHeight = mDrawable.getMinimumHeight();
			canvas.translate(width / 2 + topWidth / 2 - minimumWidth / 2, 0);
			mDrawable.setBounds(0, 0, minimumWidth, minimumHeight);
			mDrawable.draw(canvas);
		}

	}

	public void setRedDotVisibility(boolean visibility) {
		mVisibility = visibility;
		invalidate();
	}
}
